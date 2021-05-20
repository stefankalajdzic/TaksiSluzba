package main;

import enums.EModelAutomobila;
import enums.EPol;
import enums.EProizvodjacAutomobila;
import enums.EStatusVoznje;
import enums.ETelefonskaOdeljenja;
import enums.EVrstaTaksiVozila;
import pojo.Automobil;
import pojo.Dispecer;
import pojo.Musterija;
import pojo.TaksiSluzba;
import pojo.Vozac;
import pojo.Voznja;
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

	}
}
