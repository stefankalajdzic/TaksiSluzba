package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import enums.EModelAutomobila;
import enums.EPol;
import enums.EProizvodjacAutomobila;
import enums.EStatusVoznje;
import enums.ETelefonskaOdeljenja;
import enums.EVrstaTaksiVozila;
import pojo.Automobil;
import pojo.Dispecer;
import pojo.Korisnik;
import pojo.Musterija;
import pojo.TaksiSluzba;
import pojo.Vozac;
import pojo.Voznja;

public class RadSaDatotekama {
	
	private ArrayList<Korisnik> korisnici;
	private ArrayList<Vozac> vozaci;
	private ArrayList<Musterija> musterije;
	private ArrayList<Dispecer> dispeceri;
	private ArrayList<Automobil> automobili;
	private ArrayList<TaksiSluzba> taksiSluzbe;
	private ArrayList<Voznja> voznje;
	
	public RadSaDatotekama() {
		this.korisnici = new ArrayList<Korisnik>();
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
	
	public ArrayList<Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(ArrayList<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}

	public void ucitajDispecere(String putanja){
		
		try {
			File file = new File(putanja);
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
				korisnici.add(dispecer);
			} 
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom citanja dispecera iz datoteke");
		}
	}
	
	public void snimiDispecere(String putanja) {
		
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
	
	public void ucitajMusterije(String putanja){
		
		try {
			File file = new File(putanja);
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
				ArrayList<Voznja> njegoveVoznje = new ArrayList<Voznja>();
				
				Musterija musterija = new Musterija(id, korisnickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona, njegoveVoznje, obrisan);
				musterije.add(musterija);
				korisnici.add(musterija);
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
	
	public void ucitajAutomobile(String putanja) {
		
		try {
			File file = new File(putanja);
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
				Boolean obrisan = Boolean.parseBoolean(lineSplit[6]);
				
				
				Automobil automobil = new Automobil(id, model, proizvodjac, godinaProizvodnje, brRegistarskeOznake, vrstaTaksiVozila, obrisan);
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
						+ automobil.getBrRegistarskeOznake() + "|" + automobil.getVrstaTaksiVozila().ordinal() + "|" + automobil.isObrisan() + "\n";
			}
			
			writer.write(sadrzaj);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom upisa musterija u fajl.");
		}
	}
	
	public void ucitajVozace(String putanja){
			
			try {
				File file = new File(putanja);
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
					Automobil automobil = NadjiAutomobil(Integer.parseInt(lineSplit[11]));
					Boolean obrisan = Boolean.parseBoolean(lineSplit[12]);
					ArrayList<Voznja> voznje = new ArrayList<Voznja>();
					
					Vozac vozac = new Vozac(id, korisnickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona, plata, brojClanskeKarteUdruzenjaTaksista, automobil, obrisan, voznje);
					vozaci.add(vozac);
					korisnici.add(vozac);
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
	
	public void ucitajVoznje(String putanja){
		
		try {
			File file = new File(putanja);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String linija = null;
			while((linija = reader.readLine()) != null) {
				String[] lineSplit = linija.split("\\|");
				int id = Integer.parseInt(lineSplit[0]);
				String datum = lineSplit[1];
				String vremePorudzbine = lineSplit[2];
				String adresaPolaska = lineSplit[3];
				String adresaDestinacije = lineSplit[4];
				Musterija musterija = NadjiMusteriju(Integer.parseInt(lineSplit[5]));
				Vozac vozac = nadjiVozaca(Integer.parseInt(lineSplit[6]));
				String brojPredjenihKilometara = lineSplit[7];
				String trajanjeVoznje = lineSplit[8];
				EStatusVoznje status = EStatusVoznje.values()[Integer.parseInt(lineSplit[9])];
				Boolean obrisan = Boolean.parseBoolean(lineSplit[10]);
				
				Voznja voznja = new Voznja(id, datum, vremePorudzbine, adresaPolaska, adresaDestinacije, musterija, vozac, brojPredjenihKilometara, trajanjeVoznje, status, obrisan);
				vozac.getVoznje().add(voznja);
				musterija.getNjegoveVoznje().add(voznja);

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
						+ voznja.getStatus().ordinal() + "|" + voznja.isObrisan() + "\n";
			}
			
			writer.write(sadrzaj);
			writer.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom upisa voznje u fajl.");
		}
	}
	
	public void ucitajTaksiSluzbe(String putanja){
		
		try {
			File file = new File(putanja);
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
	
	public Korisnik login(String korisnickoIme, String lozinka) {
		for (Korisnik korisnik : korisnici) {
			if(korisnik.getKorisnickoIme().equalsIgnoreCase(korisnickoIme) && 
					korisnik.getLozinka().equals(lozinka) && !korisnik.isObrisan()) {
				return korisnik;
			}
		}
		return null;
	}
	
	
	public Musterija NadjiMusteriju(int id) {
		for(Musterija a : this.musterije) {
			if (a.getId() == id) {
				return a;
			}
		}
		return null;
	}
	
	public ArrayList<Dispecer> sviNeobrisaniDispeceri() {
		ArrayList<Dispecer> neobrisani = new ArrayList<Dispecer>();
		for (Dispecer dispecer : dispeceri) {
			if(!dispecer.isObrisan()) {
				neobrisani.add(dispecer);
			}
		}
		return neobrisani;
	}
	
	public ArrayList<Vozac> sviNeobrisaniVozaci() {
		ArrayList<Vozac> neobrisani = new ArrayList<Vozac>();
		for (Vozac vozac : vozaci) {
			if(!vozac.isObrisan()) {
				neobrisani.add(vozac);
			}
		}
		return neobrisani;
	}
	
	public ArrayList<Musterija> sveNeobrisaneMusterije() {
		ArrayList<Musterija> neobrisani = new ArrayList<Musterija>();
		for (Musterija musterija : musterije) {
			if(!musterija.isObrisan()) {
				neobrisani.add(musterija);
			}
		}
		return neobrisani;
	}
	
	public ArrayList<Automobil> sviNeobrisaniAutomobili() {
		ArrayList<Automobil> neobrisani = new ArrayList<Automobil>();
		for (Automobil automobil : automobili) {
			if(!automobil.isObrisan()) {
				neobrisani.add(automobil);
			}
		}
		return neobrisani;
	}
	
	public ArrayList<Voznja> sveNeobrisaneVoznje() {
		ArrayList<Voznja> neobrisane = new ArrayList<Voznja>();
		for (Voznja voznja : voznje) {
			if(!voznja.isObrisan()) {
				neobrisane.add(voznja);
			}
		}
		return neobrisane;
	}
	
	
	
	public Musterija NadjiMusterijuPoKorisnickomImenu(String korisnickoIme) {
		for(Musterija a : this.musterije) {
			if (a.getKorisnickoIme() == korisnickoIme) {
				return a;
			}
		}
		return null;
	}
	
	public Vozac NadjiVozaca(int id) {
		for(Vozac a : this.vozaci) {
			if (a.getId() == id) {
				return a;
			}
		}
		return null;
	}
	
	public Vozac NadjiVozacaPoKorisnickomImenu(String korisnickoIme) {
		for(Vozac a : this.vozaci) {
			if (a.getKorisnickoIme() == korisnickoIme) {
				return a;
			}
		}
		return null;
	}
	
	public Dispecer NadjiDispecera(int id) {
		for(Dispecer a : this.dispeceri) {
			if (a.getId() == id) {
				return a;
			}
		}
		return null;
	}
	
	public Dispecer NadjiDispeceraPoKorisnickomImenu(String korisnickoIme) {
		for(Dispecer a : this.dispeceri) {
			if (a.getKorisnickoIme() == korisnickoIme) {
				return a;
			}
		}
		return null;
	}
	
	public TaksiSluzba NadjiTaksiSluzbu(int pib) {
		for(TaksiSluzba a : this.taksiSluzbe) {
			if (a.getPib() == pib) {
				return a;
			}
		}
		return null;
	}
	
	public Voznja NadjiVoznju(int id) {
		for(Voznja a : this.voznje) {
			if (a.getId() == id) {
				return a;
			}
		}
		return null;
	}
	
	public Automobil NadjiAutomobil(int id) {
		for(Automobil a : this.automobili) {
			if (a.getId() == id) {
				return a;
			}
		}
		return null;
	}
	
	public Automobil pronadjiAutomobilPoBrRegistarskeOznake(String brRegistarskeOznake) {
		for (Automobil automobil : this.sviNeobrisaniAutomobili()) {
			if(automobil.getBrRegistarskeOznake().equalsIgnoreCase(brRegistarskeOznake)) {
				return automobil;
			}
		}
		return null;
	}
	
	public Vozac pronadjiAutomobil(Automobil id) {
		for (Vozac vozac : this.vozaci) {
			if(vozac.getAutomobil() == id) {
				return vozac;
			}
		}
		return null;
	}
	
	public Vozac pronadjiVozaca(Voznja voznja) {
		for (Vozac vozac : sviNeobrisaniVozaci()) {
			if (vozac.getVoznje().contains(voznja)) {
				return vozac;
			}
		}
		return null;
	}
	
	public Voznja pronadjiVoznju(String adresaPolaska) {
		for (Vozac vozac : vozaci) {
			for(Voznja voznja : vozac.getVoznje()) {
				if(voznja.getAdresaPolaska().equals(adresaPolaska)) {
					return voznja;
				}
			}
		}
		return null;
	}
	
//	public void snimiSve() {
//		snimiAutomobile();
//		snimiDispecere();
//		snimiMusterije();
//		snimiTaksiSluzbe();
//		snimiVozace();
//		snimiVoznje();
//	}

	
}