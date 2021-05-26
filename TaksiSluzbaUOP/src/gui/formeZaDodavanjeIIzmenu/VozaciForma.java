package gui.formeZaDodavanjeIIzmenu;

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
import gui.LoginProzor;
import main.Main;

public class VozaciForma extends JFrame {

	//zavrseno
	private JLabel lblId = new JLabel("Id");
	private JTextField txtId = new JTextField(20);
	private JLabel lblKorisnickoIme = new JLabel("Korisnicko ime");
	private JTextField txtKorisnickoIme = new JTextField(20);
	private JLabel lblLozinka = new JLabel("Lozinka");
	private JPasswordField pfLozinka = new JPasswordField(20);
	private JLabel lblIme = new JLabel("Ime");
	private JTextField txtIme = new JTextField(20);
	private JLabel lblPrezime = new JLabel("Prezime");
	private JTextField txtPrezime = new JTextField(20);
	private JLabel lblJmbg = new JLabel("Jmbg");
	private JTextField txtJmbg = new JTextField(20);
	private JLabel lblAdresa = new JLabel("Adresa");
	private JTextField txtAdresa = new JTextField(20);
	private JLabel lblPol = new JLabel("Pol");
	private JComboBox<EPol> cbPol = new JComboBox<EPol>(EPol.values());
	private JLabel lblBrTelefona = new JLabel("Broj telefona");
	private JTextField txtBrTelefona = new JTextField(20);
	private JLabel lblPlata = new  JLabel("Plata");
	private JTextField txtPlata = new JTextField(20);
	private JLabel lblbrojClanskeKarteUdruzenjaTaksista = new JLabel("Broj clanske karte");
	private JTextField txtbrojClanskeKarteUdruzenjaTaksista = new JTextField(20);
	private JLabel lblAutomobil = new JLabel("Automobil");
	private JComboBox<String> cbAutomobil = new JComboBox<String>();
	
	//dodati ostale fieldove za atribute!!!

	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private RadSaDatotekama rsd;
	private Vozac vozac;
	
	public VozaciForma(RadSaDatotekama rsd, Vozac vozac) {
		this.rsd = rsd;
		this.vozac = vozac;
		if(vozac == null) {
			setTitle("Dodavanje vozaca");
		}else {
			setTitle("Izmena podataka - " + vozac.getKorisnickoIme());
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		setResizable(false);
		pack();
	}
	
	private void initGUI() {
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][][][][][][][]20[]");
		setLayout(layout);
		
		if(vozac!= null) {
			popuniPolja();
		}
		
		add(lblId);
		add(txtId);
		add(lblKorisnickoIme);
		add(txtKorisnickoIme);
		add(lblLozinka);
		add(pfLozinka);
		add(lblIme);
		add(txtIme);
		add(lblPrezime);
		add(txtPrezime);
		add(lblJmbg);
		add(txtJmbg);
		add(lblAdresa);
		add(txtAdresa);
		add(lblPol);
		add(cbPol);
		add(lblBrTelefona);
		add(txtBrTelefona);
		add(lblPlata);
		add(txtPlata);
		add(lblbrojClanskeKarteUdruzenjaTaksista);
		add(txtbrojClanskeKarteUdruzenjaTaksista);
		add(lblAutomobil);
		add(cbAutomobil);
		//dodati ostatak
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCancel);
	}
	
	private void initActions() {
		
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validacija()) {
					int id = Integer.parseInt(txtId.getText().trim());
					String korisnickoIme = txtKorisnickoIme.getText().trim();
					String lozinka = new String(pfLozinka.getPassword()).trim();
					String ime = txtIme.getText().trim();
					String prezime = txtPrezime.getText().trim();
					String jmbg = txtJmbg.getText().trim();
					String adresa = txtAdresa.getText().trim();
					EPol pol = (EPol)cbPol.getSelectedItem();
					String brojTelefona = txtBrTelefona.getText().trim();
					double plata = Double.parseDouble(txtPlata.getText().trim());
					String brojClanskeKarteUdruzenjaTaksista = txtbrojClanskeKarteUdruzenjaTaksista.getText().trim();
					String auto = cbAutomobil.getSelectedItem().toString();
					int IdAuta = Integer.parseInt(auto);
					Automobil automobil = rsd.NadjiAutomobil(IdAuta);
					//dodati ostalo
					
					
					// DODAVANJE:
					if(vozac == null) { 
						Vozac novi = new Vozac(id, korisnickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona, plata, brojClanskeKarteUdruzenjaTaksista, automobil, false, new ArrayList<Voznja>());
						rsd.dodajVozaca(novi);
					// IZMJENA:
					}else { 
						vozac.setLozinka(lozinka);
						vozac.setIme(ime);
						vozac.setPrezime(prezime);
						vozac.setJmbg(jmbg);
						vozac.setAdresa(adresa);
						vozac.setPol(pol);
						vozac.setBrojTelefona(brojTelefona);
						vozac.setPlata(plata);
						vozac.setBrojClanskeKarteUdruzenjaTaksista(brojClanskeKarteUdruzenjaTaksista);
						vozac.setAutomobil(automobil);
						//dodati ostalo
					}
					rsd.snimiVozace(Main.VOZACI_FAJL);
					VozaciForma.this.dispose();
					VozaciForma.this.setVisible(false);
				}
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VozaciForma.this.dispose();
				VozaciForma.this.setVisible(false);
				
			}
		});
		
	}
	
	private void popuniPolja() {
		txtId.setText(String.valueOf(vozac.getId()));
		txtKorisnickoIme.setText(vozac.getKorisnickoIme());
		pfLozinka.setText(vozac.getLozinka());
		txtIme.setText(vozac.getIme());
		txtPrezime.setText(vozac.getPrezime());
		txtJmbg.setText(vozac.getJmbg());
		txtAdresa.setText(vozac.getAdresa());
		//za checkbox treba da postavimo da li je checkiran ili nije
		cbPol.setSelectedItem(vozac.getPol());
		txtBrTelefona.setText(vozac.getBrojTelefona());
		txtPlata.setText(String.valueOf(vozac.getPlata()));
		txtbrojClanskeKarteUdruzenjaTaksista.setText(vozac.getBrojClanskeKarteUdruzenjaTaksista());
		cbAutomobil.setSelectedItem(String.valueOf(vozac.getAutomobil().getId()));
		
		
	}
	private boolean validacija() {
		
		boolean ok = true;
		String poruka = "Molimo popravite sledece greske u unosu:\n";
		
		if(txtId.getText().trim().equals("")) {
			poruka += "- Unesite Id\n";
			ok = false;
		}else if(vozac == null) {
			int id = Integer.parseInt(txtId.getText().trim());
			Vozac pronadjeni = rsd.NadjiVozaca(id);
			if(pronadjeni != null && !pronadjeni.isObrisan()) {
				poruka += "- Vozac sa unetim id-em vec postoji\n";
				ok = false;
			}
		}
		
		/*Zasto ne radi validacija ako korisnik sa unetim korisnickim imenom vec postoji?! 
							Metoda iznad radi po istom principu?*/
		if(txtKorisnickoIme.getText().trim().equals("")) {
			poruka += "- Unesite korisnicko ime\n";
			ok = false;
		}else if(vozac == null){
			String korIme = txtKorisnickoIme.getText().trim();
			Korisnik pronadjeni = rsd.NadjiKorisnikaPoKorisnickomImenu(korIme);
			if(pronadjeni != null && !pronadjeni.isObrisan()) {
				poruka += "- Korisnik sa unetim korisnickim imenom vec postoji\n";
				ok = false;
			}
		}
		
		String lozinka = new String(pfLozinka.getPassword()).trim();
		if(lozinka.equals("")) {
			poruka += "- Unesite lozinku\n";
			ok = false;
		}
		

		if(txtIme.getText().trim().equals("")) {
			poruka += "- Unesite ime\n";
			ok = false;
		}
		
		
		if(txtJmbg.getText().trim().equals("")) {
			poruka += "- Unesite jmbg\n";
			ok = false;
		}
		
		if(txtPrezime.getText().trim().equals("")) {
			poruka += "- Unesite prezime\n";
			ok = false;
		}
		
		if(txtAdresa.getText().trim().equals("")) {
			poruka += "- Unesite adresu\n";
			ok = false;
		}
		
		if(txtBrTelefona.getText().trim().equals("")) {
			poruka += "- Unesite broj telefona\n";
			ok = false;
		}
		
		if(txtPlata.getText().trim().equals("")) {
			poruka += "- Unesite platu\n";
			ok = false;
		}else {
			try {
			Double.parseDouble(txtPlata.getText().trim());
			}catch (NumberFormatException e) {
				poruka += "- Plata mora biti unesena kao numericka vrednost\n";
				ok = false;
				}
		}
		
		if(txtbrojClanskeKarteUdruzenjaTaksista.getText().trim().equals("")) {
			poruka += "- Unesite broj clanske karte\n";
			ok = false;
		}
		
		//dodati ostalo
		
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		return ok;
	}
	
}