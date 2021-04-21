package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import enums.Pol;
import enums.TelefonskaOdeljenja;
import pojo.Automobil;
import pojo.Dispecer;
import pojo.Musterija;
import pojo.TaksiSluzba;
import pojo.Vozac;
import pojo.Voznja;

public class RadSaDatotekama {

	private ArrayList<Vozac> vozaci;
	private ArrayList<Musterija> musterije;
	private ArrayList<Dispecer> dispeceri;
	private ArrayList<Automobil> automobili;
	private ArrayList<TaksiSluzba> taksiSluzbe;
	private ArrayList<Voznja> voznje;
	
	public RadSaDatotekama() {
		this.vozaci = new ArrayList<Vozac>();
		this.musterije = new ArrayList<Musterija>();
		this.dispeceri = new ArrayList<Dispecer>();
		this.automobili = new ArrayList<Automobil>();
		this.taksiSluzbe = new ArrayList<TaksiSluzba>();
		this.voznje = new ArrayList<Voznja>();
	}

	public ArrayList<Vozac> getVozaci() {
		return vozaci;
	}

	public void setVozaci(ArrayList<Vozac> vozaci) {
		this.vozaci = vozaci;
	}

	public ArrayList<Musterija> getMusterije() {
		return musterije;
	}

	public void setMusterije(ArrayList<Musterija> musterije) {
		this.musterije = musterije;
	}
	
	public void dodajMusteriju(Musterija musterija) {
		this.musterije.add(musterija);
	}

	public void obrisiDispecera(Musterija musterija) {
		this.musterije.remove(musterija);
	}

	public ArrayList<Dispecer> getDispeceri() {
		return dispeceri;
	}

	public void setDispeceri(ArrayList<Dispecer> dispeceri) {
		this.dispeceri = dispeceri;
	}
	
	public void dodajDispecera(Dispecer dispecer) {
		this.dispeceri.add(dispecer);
	}

	public void obrisiDispecera(Dispecer dispecer) {
		this.dispeceri.remove(dispecer);
	}
	
	public ArrayList<Automobil> getAutomobili() {
		return automobili;
	}

	public void setAutomobili(ArrayList<Automobil> automobili) {
		this.automobili = automobili;
	}

	public ArrayList<TaksiSluzba> getTaksiSluzbe() {
		return taksiSluzbe;
	}

	public void setTaksiSluzbe(ArrayList<TaksiSluzba> taksiSluzbe) {
		this.taksiSluzbe = taksiSluzbe;
	}

	public ArrayList<Voznja> getVoznje() {
		return voznje;
	}

	public void setVoznje(ArrayList<Voznja> voznje) {
		this.voznje = voznje;
	}
	
	public void ucitajDispecere(){
		
		try {
			File file = new File("src/files/dispeceri.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String linija = null;
			while((linija = reader.readLine()) != null) {
				String[] lineSplit = linija.split("\\|");
				int id = Integer.parseInt(lineSplit[0]);
				String korisnickoIme = lineSplit[1];
				String lozinka = lineSplit[2];
				String ime = lineSplit[3];
				String prezime = lineSplit[4];
				String jmbg = lineSplit[5];
				String adresa = lineSplit[6];
				Pol pol = Pol.values()[Integer.parseInt(lineSplit[7])];
				String brojTelefona = lineSplit[8];
				double plata = Double.parseDouble(lineSplit[9]);
				String brojTelefonskeLinije = lineSplit[10];
				TelefonskaOdeljenja telefonskaOdeljenja = TelefonskaOdeljenja.values()[Integer.parseInt(lineSplit[11])];
				
				Dispecer dispecer = new Dispecer(id, korisnickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona, plata, brojTelefonskeLinije, telefonskaOdeljenja);
				dispeceri.add(dispecer);
			} 
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom citanja dispecera iz datoteke");
		}
	}
	
	public void snimiDispecere() {
		try {
			File file = new File("src/files/dispeceri.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Dispecer dispecer : dispeceri) {
				sadrzaj += dispecer.getId() + "|" + dispecer.getKorisnickoIme() + "|" + dispecer.getLozinka() + "|" 
						+ dispecer.getIme() + "|" + dispecer.getPrezime() + "|"
						+ dispecer.getJmbg() + "|" + dispecer.getAdresa() + "|" 
						+ dispecer.getPol().ordinal() + "|" + dispecer.getBrojTelefona() + "|" 
						+ dispecer.getPlata() + "|" + dispecer.getBrojTelefonskeLinije() + "|" 
						+ dispecer.getTelefonskaOdeljenja().ordinal() + "\n";
			}
			
			writer.write(sadrzaj);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom upisa dispecera u fajl.");
		}
	}
	
	public void ucitajMusterije(){
		
		try {
			File file = new File("src/files/musterije.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String linija = null;
			while((linija = reader.readLine()) != null) {
				String[] lineSplit = linija.split("\\|");
				int id = Integer.parseInt(lineSplit[0]);
				String korisnickoIme = lineSplit[1];
				String lozinka = lineSplit[2];
				String ime = lineSplit[3];
				String prezime = lineSplit[4];
				String jmbg = lineSplit[5];
				String adresa = lineSplit[6];
				Pol pol = Pol.values()[Integer.parseInt(lineSplit[7])];
				String brojTelefona = lineSplit[8];
				
				Musterija musterija = new Musterija(id, korisnickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona);
				musterije.add(musterija);
			} 
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom citanja musterija iz datoteke");
		}
	}

	public void snimiMusterije() {
		try {
			File file = new File("src/files/musterije.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Musterija musterija : musterije) {
				sadrzaj += musterija.getId() + "|" + musterija.getKorisnickoIme() + "|" + musterija.getLozinka() + "|" 
						+ musterija.getIme() + "|" + musterija.getPrezime() + "|"
						+ musterija.getJmbg() + "|" + musterija.getAdresa() + "|" 
						+ musterija.getPol().ordinal() + "|" + musterija.getBrojTelefona() + "\n";
			}
			
			writer.write(sadrzaj);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom upisa musterija u fajl.");
		}
	}
	
	
}