package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
	
	public void dodajVozaca(Vozac vozac) {
		this.vozaci.add(vozac);
	}
	
	public void obrisiVozaca(Vozac vozac) {
		this.vozaci.remove(vozac);
	}
	
	public Vozac nadjiVozaca(int id) {
		for (Vozac vozac : vozaci) {
			if (vozac.getId() == id) {
				return vozac;
			}
		}
		return null;
	}

	public Vozac izmeniVozaca(Vozac v) {
		for(Vozac vozac: vozaci) {
			if(vozac.getId()==v.getId()) {
				vozac.setIme(v.getIme());
				vozac.setPrezime(v.getPrezime());
			}
			else {
				System.out.println("Ne postoji taj Vozac");
			}
		}
		return v;
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
	
	public void dodajAutomobil(Automobil automobil) {
		this.automobili.add(automobil);
	}
	
	public void obrisiAutomobil(Automobil automobil) {
		this.automobili.remove(automobil);
	}

	public ArrayList<TaksiSluzba> getTaksiSluzbe() {
		return taksiSluzbe;
	}

	public void setTaksiSluzbe(ArrayList<TaksiSluzba> taksiSluzbe) {
		this.taksiSluzbe = taksiSluzbe;
	}
	
	public void dodajTaksiSluzbu(TaksiSluzba taksiSluzba) {
		this.taksiSluzbe.add(taksiSluzba);
	}
	
	public void obrisiTaksiSluzbu(TaksiSluzba taksiSluzba) {
		this.taksiSluzbe.remove(taksiSluzba);
	}

	public ArrayList<Voznja> getVoznje() {
		return voznje;
	}

	public void setVoznje(ArrayList<Voznja> voznje) {
		this.voznje = voznje;
	}
	
	public void dodajVoznju(Voznja voznja) {
		this.voznje.add(voznja);
	}
	
	public void obrisiVoznju(Voznja voznja) {
		this.voznje.remove(voznja);
	}
	
	public Musterija login(String korisnickoIme, String lozinka) {
		for (Musterija musterija : musterije) {
			if(musterija.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) && 
					musterija.getLozinka().equals(lozinka) && !musterija.isObrisan()) {
				return musterija;
			}
		}
		return null;
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
				EPol pol = EPol.values()[Integer.parseInt(lineSplit[7])];
				String brojTelefona = lineSplit[8];
				double plata = Double.parseDouble(lineSplit[9]);
				String brojTelefonskeLinije = lineSplit[10];
				ETelefonskaOdeljenja telefonskaOdeljenja = ETelefonskaOdeljenja.values()[Integer.parseInt(lineSplit[11])];
				Boolean obrisan = Boolean.parseBoolean(lineSplit[12]);
				
				Dispecer dispecer = new Dispecer(id, korisnickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona, plata, brojTelefonskeLinije, telefonskaOdeljenja, obrisan);
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
						+ dispecer.getTelefonskaOdeljenja().ordinal() + "|" + dispecer.isObrisan() + "\n";
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
				EPol pol = EPol.values()[Integer.parseInt(lineSplit[7])];
				String brojTelefona = lineSplit[8];
				Boolean obrisan = Boolean.parseBoolean(lineSplit[9]);
				
				Musterija musterija = new Musterija(id, korisnickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona, obrisan);
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
						+ musterija.getPol().ordinal() + "|" + musterija.getBrojTelefona() + "|" + musterija.isObrisan() + "\n";
			}
			
			writer.write(sadrzaj);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom upisa musterija u fajl.");
		}
	}
	
	public void ucitajAutomobile() {
		
		try {
			File file = new File("src/files/automobili.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String linija = null;
			while((linija = reader.readLine()) != null) {
				String[] lineSplit = linija.split("\\|");
				int id = Integer.parseInt(lineSplit[0]);
				EModelAutomobila model = EModelAutomobila.values()[Integer.parseInt(lineSplit[1])];
				EProizvodjacAutomobila proizvodjac = EProizvodjacAutomobila.values()[Integer.parseInt(lineSplit[2])];
				String godinaProizvodnje = lineSplit[3];
				String brRegistarskeOznake = lineSplit[4];
				EVrstaTaksiVozila vrstaTaksiVozila = EVrstaTaksiVozila.values()[Integer.parseInt(lineSplit[5])];
				
				
				Automobil automobil = new Automobil(id, model, proizvodjac, godinaProizvodnje, brRegistarskeOznake, vrstaTaksiVozila);
				automobili.add(automobil);
			} 
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom citanja automobila iz datoteke");
		}
	}
	
	public void snimiAutomobile() {
		
		try {
			File file = new File("src/files/automobili.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Automobil automobil : automobili) {
				sadrzaj += automobil.getId() + "|" + automobil.getModel().ordinal() + "|" 
						+ automobil.getProizvodjac().ordinal() + "|" + automobil.getGodinaProizvodnje() + "|"
						+ automobil.getBrRegistarskeOznake() + "|" + automobil.getVrstaTaksiVozila().ordinal() + "\n";
			}
			
			writer.write(sadrzaj);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom upisa musterija u fajl.");
		}
	}
	
	public void ucitajVozace(){
			
			try {
				File file = new File("src/files/vozaci.txt");
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
					EPol pol = EPol.values()[Integer.parseInt(lineSplit[7])];
					String brojTelefona = lineSplit[8];
					Double plata = Double.parseDouble(lineSplit[9]);
					String brojClanskeKarteUdruzenjaTaksista = lineSplit[10];
					Automobil automobil = new Automobil();
					automobil.setId(Integer.parseInt(lineSplit[11]));
					Boolean obrisan = Boolean.parseBoolean(lineSplit[12]);
					
					Vozac vozac = new Vozac(id, korisnickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona, plata, brojClanskeKarteUdruzenjaTaksista, automobil, obrisan);
					vozaci.add(vozac);
				} 
				reader.close();
			} catch (IOException e) {
				System.out.println("Greska prilikom citanja vozaca iz datoteke");
			}
		}

	public void snimiVozace() {
		
		try {
			File file = new File("src/files/vozaci.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Vozac vozac : vozaci) {
				sadrzaj += vozac.getId() + "|" + vozac.getKorisnickoIme() + "|" + vozac.getLozinka() + "|" 
						+ vozac.getIme() + "|" + vozac.getPrezime() + "|"
						+ vozac.getJmbg() + "|" + vozac.getAdresa() + "|" 
						+ vozac.getPol().ordinal() + "|" + vozac.getBrojTelefona() + "|" + vozac.getPlata() + "|" 
						+ vozac.getBrojClanskeKarteUdruzenjaTaksista() + "|" + String.valueOf(vozac.getAutomobil().getId()) + "|"
						+ vozac.isObrisan() + "\n";
			}
			
			writer.write(sadrzaj);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom upisa vozaca u fajl.");
		}
	}
	
	public void ucitajVoznje(){
		
		try {
			File file = new File("src/files/voznje.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String linija = null;
			while((linija = reader.readLine()) != null) {
				String[] lineSplit = linija.split("\\|");
				int id = Integer.parseInt(lineSplit[0]);
				String datum = lineSplit[1];
				String vremePorudzbine = lineSplit[2];
				String adresaPolaska = lineSplit[3];
				String adresaDestinacije = lineSplit[4];
				Musterija musterija = new Musterija();
				musterija.setId(Integer.parseInt(lineSplit[5]));
				Vozac vozac = new Vozac();
				vozac.setId(Integer.parseInt(lineSplit[6]));
				String brojPredjenihKilometara = lineSplit[7];
				String trajanjeVoznje = lineSplit[8];
				EStatusVoznje status = EStatusVoznje.values()[Integer.parseInt(lineSplit[9])];
				
				Voznja voznja = new Voznja(id, datum, vremePorudzbine, adresaPolaska, adresaDestinacije, musterija, vozac, brojPredjenihKilometara, trajanjeVoznje, status);
				voznje.add(voznja);
			} 
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom citanja voznje iz datoteke");
		}
	}

	public void snimiVoznje() {
		
		try {
			File file = new File("src/files/voznje.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (Voznja voznja : voznje) {
				sadrzaj += voznja.getId() + "|" + voznja.getDatum() + "|" 
						+ voznja.getVremePorudzbine() + "|" 
						+ voznja.getAdresaPolaska() + "|" + voznja.getAdresaDestinacije() + "|"
						+ String.valueOf(voznja.getMusterija().getId()) + "|" 
						+ String.valueOf(voznja.getVozac().getId()) + "|" 
						+ voznja.getBrojPredjenihKilometara() + "|" + voznja.getTrajanjeVoznje() + "|" 
						+ voznja.getStatus().ordinal() + "\n";
			}
			
			writer.write(sadrzaj);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom upisa voznje u fajl.");
		}
	}
	
	public void ucitajTaksiSluzbe(){
		
		try {
			File file = new File("src/files/taksiSluzbe.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String linija = null;
			while((linija = reader.readLine()) != null) {
				String[] lineSplit = linija.split("\\|");
				int pib = Integer.parseInt(lineSplit[0]);
				String naziv = lineSplit[1];
				String adresa = lineSplit[2];
				Double cenaStartaVoznje = Double.parseDouble(lineSplit[3]);
				Double cenaPoKilometru = Double.parseDouble(lineSplit[4]);
				TaksiSluzba taksiSluzba = new TaksiSluzba(pib, naziv, adresa, cenaStartaVoznje, cenaPoKilometru);
				taksiSluzbe.add(taksiSluzba);
			} 
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom citanja taksiSluzbe iz datoteke");
		}
	}
	
	public void snimiTaksiSluzbe() {
		
		try {
			File file = new File("src/files/taksiSluzbe.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String sadrzaj = "";
			for (TaksiSluzba taksiSluzba : taksiSluzbe) {
				sadrzaj += taksiSluzba.getPib() + "|" + taksiSluzba.getNaziv() + "|" + taksiSluzba.getAdresa() + "|" 
						+ taksiSluzba.getCenaStartaVoznje() + "|" + taksiSluzba.getCenaPoKilometru() + "\n";
			}
			
			writer.write(sadrzaj);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom upisa taksiSluzbe u fajl.");
		}
	}

	
}