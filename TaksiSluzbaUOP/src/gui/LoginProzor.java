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
import pojo.Musterija;
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
		initGUI();
		initActions();
		pack();
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
					JOptionPane.showMessageDialog(null, "Niste uneli sve podatke za prijavu.",
							"Greska", JOptionPane.WARNING_MESSAGE);
				}else {
					Musterija prijavljeni = rsd.login(korisnickoIme, sifra);
					if(prijavljeni == null) {
						JOptionPane.showMessageDialog(null, "Pogresni login podaci.",
								"Greska", JOptionPane.WARNING_MESSAGE);
					}else {
						System.out.println(prijavljeni);
					}
				}
			}
		});
		
		
	}
	
}