package gui.formeZaPrikaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import pojo.Automobil;
import pojo.Korisnik;
import pojo.Musterija;
import pojo.Vozac;
import pojo.Voznja;
import util.RadSaDatotekama;
import enums.EPol;
import enums.EStatusVoznje;
import gui.LoginProzor;
import main.Main;

public class DodeliVoznjuVozacuProzor extends JFrame {

	//zavrseno
	private JLabel lblId = new JLabel("Id");
	private JTextField txtId = new JTextField(20);
	private JLabel lblDatum = new JLabel("Datum");
	private JTextField txtDatum = new JTextField(20);
	private JLabel lblVremePorudzbine = new JLabel("Vreme porudzbine");
	private JTextField txtVremePorudzbine= new JTextField(20);
	private JLabel lblAdresaPolaska = new JLabel("Adresa polaska");
	private JTextField txtAdresaPolaska = new JTextField(20);
	private JLabel lblAdresaDestinacije = new JLabel("Adresa destinacije");
	private JTextField txtAdresaDestinacije = new JTextField(20);
	private JLabel lblMusterija = new JLabel("Musterija");
	private JComboBox<String> cbMusterija = new JComboBox<String>();
	private JLabel lblVozac = new JLabel("Vozac");
	private JComboBox<String> cbVozac = new JComboBox<String>();
	private JLabel lblStatusVoznje = new JLabel("Status voznje");
	private JComboBox<EStatusVoznje> cbStatusVoznje = new JComboBox<EStatusVoznje>(EStatusVoznje.values());
	


	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private RadSaDatotekama rsd;
	private Voznja voznja;
	
	public DodeliVoznjuVozacuProzor(RadSaDatotekama rsd, Voznja voznja) {
		this.rsd = rsd;
		this.voznja = voznja;
		setTitle("Dodela voznje - " + voznja.getDatum());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(500, 500);
		initGUI();
		initActions();
		setResizable(true);
		pack();
		getRootPane().setDefaultButton(btnOk);
	}
	
	private void initGUI() {
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][][][][][][][]20[]");
		setLayout(layout);
		
		if(voznja!= null) {
			popuniPolja();
		}
//		cbAutomobil.addItem(vozac.getKorisnickoIme());
		for(Musterija a: this.rsd.getMusterije()) {
			cbMusterija.addItem(voznja.getMusterija().getKorisnickoIme());
		}
		
		for(Vozac a: this.rsd.sviNeobrisaniVozaci()) {
			cbVozac.addItem(a.getKorisnickoIme());
		}
		
		
		add(lblId);
		add(txtId);
		add(lblDatum);
		add(txtDatum);
		add(lblVremePorudzbine);
		add(txtVremePorudzbine);
		add(lblAdresaPolaska);
		add(txtAdresaPolaska);
		add(lblAdresaDestinacije);
		add(txtAdresaDestinacije);
		add(lblMusterija);
		add(cbMusterija);
		add(lblVozac);
		add(cbVozac);
		add(lblStatusVoznje);
		add(cbStatusVoznje);

		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCancel);
	}
	
	private void initActions() {
		
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {

					String vozacZaPronalazak = cbVozac.getSelectedItem().toString();
			
					Vozac vozac = rsd.NadjiVozacaPoKorisnickomImenu(vozacZaPronalazak);
						
						voznja.setVozac(vozac);
						voznja.setStatus(EStatusVoznje.DODELJENA);
						
					}
					rsd.snimiVoznje(Main.VOZNJE_FAJL);
					DodeliVoznjuVozacuProzor.this.dispose();
					DodeliVoznjuVozacuProzor.this.setVisible(false);
				
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DodeliVoznjuVozacuProzor.this.dispose();
				DodeliVoznjuVozacuProzor.this.setVisible(false);
				
			}
		});
		
	}
	
	private void popuniPolja() {
		txtId.setText(String.valueOf(voznja.getId()));
		txtId.setEnabled(false);
		txtDatum.setText(voznja.getDatum());
		txtDatum.setEnabled(false);
		txtVremePorudzbine.setText(voznja.getVremePorudzbine());
		txtVremePorudzbine.setEnabled(false);
		txtAdresaPolaska.setText(voznja.getAdresaPolaska());
		txtAdresaPolaska.setEnabled(false);
		txtAdresaDestinacije.setText(voznja.getAdresaDestinacije());
		txtAdresaDestinacije.setEnabled(false);
		cbMusterija.setSelectedItem(String.valueOf(voznja.getMusterija().getKorisnickoIme()));
		cbMusterija.setEnabled(false);
		cbStatusVoznje.setSelectedItem(voznja.getStatus());	
		cbStatusVoznje.setEnabled(false);
	}
	private boolean validacija() {
		
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		
		if(txtId.getText().trim().equals("")) {
			poruka += "- Unesite Id\n";
			ok = false;
		}else if(voznja == null) {
			int id = Integer.parseInt(txtId.getText().trim());
			Voznja pronadjena = rsd.NadjiVoznju(id);
			if(pronadjena != null && !pronadjena.isObrisan()) {
				poruka += "- Voznja sa unetim id-em vec postoji\n";
				ok = false;
			}
		}
		

		if(txtDatum.getText().trim().equals("")) {
			poruka += "- Unesite datum\n";
			ok = false;
		}
		
		
		if(txtVremePorudzbine.getText().trim().equals("")) {
			poruka += "- Unesite vreme porudzbine\n";
			ok = false;
		}
		
		if(txtAdresaPolaska.getText().trim().equals("")) {
			poruka += "- Unesite adresu polaska\n";
			ok = false;
		}
		
		if(txtAdresaDestinacije.getText().trim().equals("")) {
			poruka += "- Unesite adresu destinacije\n";
			ok = false;
		}
		
		//dodati ostalo
		
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		return ok;
	}
	
}