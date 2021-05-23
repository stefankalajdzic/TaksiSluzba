package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import gui.formeZaPrikaz.DispeceriProzor;
import pojo.Dispecer;
import util.RadSaDatotekama;

public class GlavniProzorDispeceri extends JFrame {

	private JMenuBar mainMenu = new JMenuBar();
	private JMenu dodeliVoznju = new JMenu("Dodeli voznju vozacu");
	private JMenu dispeceriMenu = new JMenu("Dispeceri");
	private JMenuItem dispeceriItem = new JMenuItem("Dispeceri");
	
	private RadSaDatotekama rsd;
	private Dispecer prijavljeniKorisnik;
	
	public GlavniProzorDispeceri(RadSaDatotekama rsd, Dispecer prijavljeniKorisnik) {
		this.rsd = rsd;
		this.prijavljeniKorisnik = prijavljeniKorisnik;
		setTitle("Dispecer: " + prijavljeniKorisnik.getKorisnickoIme());
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenu();
		initActions();
	}
	
	private void initMenu() {
		setJMenuBar(mainMenu);
		mainMenu.add(dodeliVoznju);
		mainMenu.add(dispeceriMenu);
		dispeceriMenu.add(dispeceriItem);
	}
	
	private void initActions() {
		
		dispeceriItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				DispeceriProzor dp = new DispeceriProzor(rsd);
				dp.setVisible(true);
				
			}
		});
		
	}
}