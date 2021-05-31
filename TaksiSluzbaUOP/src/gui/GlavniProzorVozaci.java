package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gui.formeZaPrikaz.VozaciProzor;
import gui.formeZaPrikaz.VoznjeProzor;
import pojo.Vozac;
import pojo.Voznja;
import util.RadSaDatotekama;

public class GlavniProzorVozaci extends JFrame {

	private JMenuBar mainMenu = new JMenuBar();
	private JMenu zavrsiVoznjuMenu = new JMenu("Zavrsi voznju");
	private JMenuItem zavrsiVoznjuItem = new JMenuItem("Zavrsi voznju");
	private JMenu voznjeMenu = new JMenu("Voznje");
	private JMenuItem voznjeItem = new JMenuItem("Voznje");
	
	private RadSaDatotekama rsd;
	private Vozac prijavljeniKorisnik;
	private Voznja voznja;
	
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
		mainMenu.add(zavrsiVoznjuMenu);
		zavrsiVoznjuMenu.add(zavrsiVoznjuItem);
		mainMenu.add(voznjeMenu);
		voznjeMenu.add(voznjeItem);
	}
	
	private void initActions() {
		
		voznjeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VoznjeProzor voznjep = new VoznjeProzor(rsd);
				voznjep.setVisible(true);
				
			}
		});
		
	}
	
	
}
