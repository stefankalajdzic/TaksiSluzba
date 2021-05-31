package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gui.formeZaPrikaz.DispeceriProzor;
import gui.formeZaPrikaz.NaruciVoznjuProzor;
import pojo.Musterija;
import pojo.Voznja;
import util.RadSaDatotekama;

public class GlavniProzorMusterije extends JFrame {

	private JMenuBar mainMenu = new JMenuBar();
	private JMenu rezervisiVoznju = new JMenu("Rezervisi voznju");
	private JMenuItem putemTelefonaItem = new JMenuItem("Telefonom");
	
	private RadSaDatotekama rsd;
	private Musterija prijavljeniKorisnik;
	
	public GlavniProzorMusterije(RadSaDatotekama rsd, Musterija prijavljeniKorisnik) {
		this.rsd = rsd;
		this.prijavljeniKorisnik = prijavljeniKorisnik;
		setTitle("Musterija: " + prijavljeniKorisnik.getKorisnickoIme());
		setSize(500, 500);
		setResizable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenu();
		initActions();
		
	}
	
	private void initMenu() {
		setJMenuBar(mainMenu);
		mainMenu.add(rezervisiVoznju);
		rezervisiVoznju.add(putemTelefonaItem);
	}
	
	private void initActions() {
		putemTelefonaItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				NaruciVoznjuProzor nvp = new NaruciVoznjuProzor(rsd, prijavljeniKorisnik);
				nvp.setVisible(true);
				
			}
		});
	}
}
