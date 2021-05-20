package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import pojo.Dispecer;
import pojo.Musterija;
import pojo.Vozac;
import util.RadSaDatotekama;

public class LoginProzor extends JFrame {

	private JLabel lblGreeting = new JLabel("Dobrodosli, molimo da se prijavite.");
	
	private JLabel lblUsername = new JLabel("Korisnicko ime");
	private JTextField txtKorisnickoIme = new JTextField(20);
	
	private JLabel lblPassword = new JLabel("Lozinka ");
	private JPasswordField pfLozinka = new JPasswordField(20);
	
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	private RadSaDatotekama rsd;
	
	public LoginProzor(RadSaDatotekama rsd) {
		this.rsd = rsd;
		setTitle("Prijava");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		initGUI();
		initActions();
		pack();
		getRootPane().setDefaultButton(btnOk);
	}
	
	public void initGUI() {
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		setLayout(mig);
		
		add(lblGreeting, "span 2");
		add(lblUsername);
		add(txtKorisnickoIme);
		add(lblPassword);
		add(pfLozinka);
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCancel);
		
		getRootPane().setDefaultButton(btnOk);
		
	}
	
	public void initActions() {
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginProzor.this.dispose();
				LoginProzor.this.setVisible(false);
				
			}
		});
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String uneto_korisnicko = txtKorisnickoIme.getText().trim();
				String uneta_sifra = new String(pfLozinka.getPassword()).trim();
				
				int rez = 0;
				for(Vozac a : rsd.getVozaci()) {
					if(a.getKorisnickoIme().equalsIgnoreCase(uneto_korisnicko)) {
						rez += 1;
					}
				}for(Musterija a : rsd.getMusterije()) {
					if(a.getKorisnickoIme().equalsIgnoreCase(uneto_korisnicko)) {
						rez += 1;
					}
				}for(Dispecer a : rsd.getDispeceri()) {
					if(a.getKorisnickoIme().equalsIgnoreCase(uneto_korisnicko)) {
						rez += 1;
					}
				}

				if(rez == 0) {
					JOptionPane.showMessageDialog(null, "Uneseni podaci se ne podudaraju ni sa jednim korisnikom.", "Greska prilikom unosa!", JOptionPane.WARNING_MESSAGE);
				}
				if(uneto_korisnicko.equals("") || uneta_sifra.equals("")) {
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja.", "Greska prilikom unosa!", JOptionPane.WARNING_MESSAGE);

					
				}else {
					for(Vozac a : rsd.getVozaci()) {
						if(a.getKorisnickoIme().equalsIgnoreCase(uneto_korisnicko) && a.getLozinka().equals(uneta_sifra)) {
							LoginProzor.this.dispose();
							LoginProzor.this.setVisible(false);
							GlavniProzorVozaci gpv = new GlavniProzorVozaci(rsd, a);
							gpv.setVisible(true);
						}
					}for(Musterija m : rsd.getMusterije()) {
						if(m.getKorisnickoIme().equalsIgnoreCase(uneto_korisnicko) && m.getLozinka().equals(uneta_sifra)) {
							LoginProzor.this.dispose();
							LoginProzor.this.setVisible(false);
							GlavniProzorMusterije gpm = new GlavniProzorMusterije(rsd, m);
							gpm.setVisible(true);
						}
					}for(Dispecer d : rsd.getDispeceri()) {
						if(d.getKorisnickoIme().equalsIgnoreCase(uneto_korisnicko) && d.getLozinka().equals(uneta_sifra)) {
							LoginProzor.this.dispose();
							LoginProzor.this.setVisible(false);
							GlavniProzorDispeceri gpd = new GlavniProzorDispeceri(rsd, d);
							gpd.setVisible(true);
					}
				}
			}
		}
		
		
	});
	
	}
}