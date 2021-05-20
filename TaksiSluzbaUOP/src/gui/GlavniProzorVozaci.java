package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import pojo.Vozac;
import util.RadSaDatotekama;

public class GlavniProzorVozaci extends JFrame {

	private JMenuBar mainMenu = new JMenuBar();
	private JMenu rezervisiVoznju = new JMenu("Rezervisi voznju");
	private JMenuItem putemTelefonaItem = new JMenuItem("Telefonom");
	private JMenuItem putemMailaItem = new JMenuItem("Mailom");
	
	private RadSaDatotekama rsd;
	private Vozac prijavljeniKorisnik;
	
	public GlavniProzorVozaci(RadSaDatotekama rsd, Vozac prijavljeniKorisnik) {
		this.rsd = rsd;
		this.prijavljeniKorisnik = prijavljeniKorisnik;
		setTitle("Vozac: " + prijavljeniKorisnik.getKorisnickoIme());
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
		rezervisiVoznju.add(putemMailaItem);
	}
	
	private void initActions() {
		
	}
}
