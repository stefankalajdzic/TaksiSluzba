package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import pojo.Musterija;
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
		setResizable(false);
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
		
	}
}
