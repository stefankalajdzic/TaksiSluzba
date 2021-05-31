package gui.formeZaPrikaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import enums.EStatusVoznje;
import main.Main;
import net.miginfocom.swing.MigLayout;
import pojo.Musterija;
import pojo.Voznja;
import util.RadSaDatotekama;

public class NaruciVoznjuProzor extends JFrame {
	private JLabel lblNazivTaksiSluzbe = new JLabel("Dobro dosli u nasu Taksi Sluzbu!");
	private JLabel lbladresaTaksiSluzbe = new JLabel("Sediste firme: Bulevar Oslobodjenja 25");
	private JLabel lblcenaStartaVoznje = new JLabel("Cena starta voznje: 120 RSD");
	private JLabel lblcenaVoznjePoKilometru = new JLabel("Cena voznje po kilometru: 150 RSD");
	private JLabel lblAdresaPolaska = new JLabel("Adresa polaska");
	private JTextField txtAdresaPolaska = new JTextField(20);
	private JLabel lblAdresaDestinacije = new JLabel("Adresa destinacije");
	private JTextField txtAdresaDestinacije = new JTextField(20);
	private JButton btnNaruciVoznju = new JButton("Naruci voznju");
	private JButton btnCancel = new JButton("Cancel");
	
	private RadSaDatotekama rsd;
	private Musterija musterija;
	
	public NaruciVoznjuProzor(RadSaDatotekama rsd, Musterija musterija) {
		this.musterija = musterija;
		this.rsd = rsd;
		setTitle("Dobrodosli u Kalaj Taxi - " + " postovani/a " + musterija.getIme());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(true);
		pack();
		getRootPane().setDefaultButton(btnNaruciVoznju);
	}
	
	private void initGUI() {
		
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[]10[]10[]");
		setLayout(mig);
		
		add(lblNazivTaksiSluzbe);
		add(new JLabel());
		add(lbladresaTaksiSluzbe);
		add(new JLabel());
		add(lblcenaStartaVoznje);
		add(new JLabel());
		add(lblcenaVoznjePoKilometru);
		add(new JLabel());
		add(lblAdresaPolaska);
		add(txtAdresaPolaska);
		add(lblAdresaDestinacije);
		add(txtAdresaDestinacije);
		add(new JLabel());
		add(btnNaruciVoznju, "split 2");
		add(btnCancel);
		
		getRootPane().setDefaultButton(btnNaruciVoznju);
	}
	
	private void initActions() {
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NaruciVoznjuProzor.this.dispose();
				NaruciVoznjuProzor.this.setVisible(false);
				
			}
		});
		
		btnNaruciVoznju.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Voznja v = new Voznja();
				v.setId(rsd.getVoznje().get(rsd.getVoznje().size() - 1).getId() + 1);
				v.setMusterija(musterija);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
				LocalDateTime now = LocalDateTime.now();  
				String datum = dtf.format(now);
				DateTimeFormatter tdf = DateTimeFormatter.ofPattern("HH:mm:ss");  
				LocalDateTime now2 = LocalDateTime.now();
				String vreme = tdf.format(now2);
				v.setDatum(datum);
				v.setVremePorudzbine(vreme);
				String polazak = txtAdresaPolaska.getText().trim();
				String dolazak = txtAdresaDestinacije.getText().trim();
				v.setAdresaPolaska(polazak);
				v.setAdresaDestinacije(dolazak);
				v.setStatus(EStatusVoznje.KREIRANA);
				v.setObrisan(false);
				
				rsd.getVoznje().add(v);
				rsd.snimiVoznje(Main.VOZNJE_FAJL);
				
				NaruciVoznjuProzor.this.dispose();
				NaruciVoznjuProzor.this.setVisible(false);
				
			}
		});
	}
	
}