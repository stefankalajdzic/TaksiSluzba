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
import pojo.Korisnik;
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
				String korisnickoIme = txtKorisnickoIme.getText().trim();
				String sifra = new String(pfLozinka.getPassword()).trim();
				
				if(korisnickoIme.equals("") || sifra.equals("")) {
					JOptionPane.showMessageDialog(null, "Niste uneli sve podatke" , "Greska" , JOptionPane.WARNING_MESSAGE);
				}else {
					Korisnik prijavljeni = rsd.login(korisnickoIme, sifra);
					if(prijavljeni == null) {
						JOptionPane.showMessageDialog(null, "Pogresni login podaci", "Greska", JOptionPane.WARNING_MESSAGE);
					}else  {
						for (Musterija m : rsd.getMusterije()) {
							if(m.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) && m.getLozinka().equals(sifra)) {
								LoginProzor.this.dispose();
								LoginProzor.this.setVisible(false);
								GlavniProzorMusterije lpm = new GlavniProzorMusterije(rsd, m);
								lpm.setVisible(true);
							}
						}
						for (Dispecer d: rsd.getDispeceri()) {
							if(d.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) && d.getLozinka().equals(sifra)) {
								LoginProzor.this.dispose();
								LoginProzor.this.setVisible(false);
								GlavniProzorDispeceri lpd = new GlavniProzorDispeceri(rsd, d);
								lpd.setVisible(true);
							}
						}
						for (Vozac v: rsd.getVozaci()) {
							if(v.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) && v.getLozinka().equals(sifra)) {
								LoginProzor.this.dispose();
								LoginProzor.this.setVisible(false);
								GlavniProzorVozaci lpd = new GlavniProzorVozaci(rsd, v);
								lpd.setVisible(true);
							}
						}
						
						
					}
				}
			}
		
	});
	
	}
}