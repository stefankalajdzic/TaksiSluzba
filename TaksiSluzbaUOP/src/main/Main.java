package main;

import gui.LoginProzor;

import util.RadSaDatotekama;

public class Main {
	
	private static String AUTOMOBILI_FAJL = "src/files/automobili.txt";
	private static String DISPECERI_FAJL = "src/files/dispeceri.txt";
	private static String MUSTERIJE_FAJL = "src/files/musterije.txt";
	private static String TAKSI_SLUZBE_FAJL = "src/files/taksiSluzbe.txt";
	private static String VOZACI_FAJL = "src/files/vozaci.txt";
	private static String VOZNJE_FAJL = "src/files/voznje.txt";
	
	public static void main(String[] args) {
		
		RadSaDatotekama rsd = new RadSaDatotekama();
		rsd.ucitajAutomobile(AUTOMOBILI_FAJL);
		rsd.ucitajDispecere(DISPECERI_FAJL);
		rsd.ucitajMusterije(MUSTERIJE_FAJL);
		rsd.ucitajTaksiSluzbe(TAKSI_SLUZBE_FAJL);
		rsd.ucitajVozace(VOZACI_FAJL);
		rsd.ucitajVoznje(VOZNJE_FAJL);

		LoginProzor lp = new LoginProzor(rsd);
		lp.setVisible(true);
		
	}
}
