package main;

import enums.ModelAutomobila;
import enums.Pol;
import enums.ProizvodjacAutomobila;
import enums.StatusVoznje;
import enums.TelefonskaOdeljenja;
import enums.VrstaTaksiVozila;
import pojo.Automobil;
import pojo.Dispecer;
import pojo.Musterija;
import pojo.Vozac;
import pojo.Voznja;
import util.RadSaDatotekama;

public class Main {
	
	public static void main(String[] args) {
		
		RadSaDatotekama rsd = new RadSaDatotekama();
		rsd.ucitajDispecere();
		System.out.println("Ucitani dispeceri: ");
		ispisiDispecere(rsd);
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Dodavanje dispecera: ");
		Dispecer testDispecer = new Dispecer(3, "tanja", "tanja123", "Tanja", "Kojic", "12515251525125", "Brcko bb", Pol.ZENSKI, "065123456", 300000.0, "25", TelefonskaOdeljenja.ODELJENJE_ZA_REKLAMACIJE);
		rsd.dodajDispecera(testDispecer);
		rsd.snimiDispecere();
		System.out.println(testDispecer);
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		rsd.ucitajMusterije();
		System.out.println("Ucitane musterije: ");
		ispisiMusterije(rsd);
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Dodavanje musterije: ");
		Musterija testMusterija = new Musterija(2, "Mare", "mare123", "Marko", "Markovic", "15210521152", "Alekse Santica 5", Pol.MUSKI, "065424141");
		rsd.dodajMusteriju(testMusterija);
		rsd.snimiMusterije();
		System.out.println(testMusterija);
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		rsd.ucitajAutomobile();
		System.out.println("Ucitani automobili: ");
		ispisiAutomobile(rsd);
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Dodavanje automobila: ");
		Automobil testAutomobil = new Automobil(3, ModelAutomobila.A3 ,ProizvodjacAutomobila.AUDI, "2016", "NS-000 NI", VrstaTaksiVozila.PUTNICKI_AUTOMOBIL);
		rsd.dodajAutomobil(testAutomobil);
		rsd.snimiAutomobile();
		System.out.println(testAutomobil);
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		rsd.ucitajVozace();
		System.out.println("Ucitani vozaci: ");
		ispisiVozace(rsd);
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Dodavanje vozaca: ");
		Vozac testVozac = new Vozac(2, "pera", "pera123", "Petar", "Petrovic", "1508995181921", "Zrenjanin bb",Pol.MUSKI, "0665323123", 90000.0, "br 26", testAutomobil, false);
		rsd.dodajVozaca(testVozac);
		rsd.snimiVozace();
		System.out.println(testVozac);
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		rsd.ucitajVoznje();
		System.out.println("Ucitane voznje: ");
		ispisiVoznje(rsd);
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Dodavanje voznje: ");
		Voznja testVoznja = new Voznja(2, "22/4/2021", "15:03", "Boska Buhe 10A", "Novi Sad Strand", testMusterija, testVozac, "0.2", "7 min", StatusVoznje.DODELJENA);
		rsd.dodajVoznju(testVoznja);
		rsd.snimiVoznje();
		System.out.println(testVoznja);
	}
	
	public static void ispisiDispecere(RadSaDatotekama radSaDatotekama) {
		for (Dispecer dispecer : radSaDatotekama.getDispeceri()) {
			System.out.println(dispecer);
		}
	}
	
	public static void ispisiMusterije(RadSaDatotekama radSaDatotekama) {
		for (Musterija musterija : radSaDatotekama.getMusterije()) {
			System.out.println(musterija);
		}
	}
	
	public static void ispisiAutomobile(RadSaDatotekama radSaDatotekama) {
		for (Automobil automobil : radSaDatotekama.getAutomobili()) {
			System.out.println(automobil);
		}
	}
	
	public static void ispisiVozace(RadSaDatotekama radSaDatotekama) {
		for (Vozac vozac : radSaDatotekama.getVozaci()) {
			System.out.println(vozac);
		}
	}
	
	public static void ispisiVoznje(RadSaDatotekama radSaDatotekama) {
		for (Voznja voznja : radSaDatotekama.getVoznje()) {
			System.out.println(voznja);
		}
	}

}
