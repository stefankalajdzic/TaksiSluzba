package pojo;

import java.util.ArrayList;

import enums.EPol;

public class Vozac extends Korisnik {
	
	private double plata;
	private String brojClanskeKarteUdruzenjaTaksista;
	private Automobil automobil;
	private ArrayList<Voznja> voznje;
	
	public Vozac() {
		this.plata = 0;
		this.brojClanskeKarteUdruzenjaTaksista = "";
		this.automobil = new Automobil();
		this.voznje = new ArrayList<Voznja>();
	}

	

	public Vozac(int id, String korisnickoIme, String lozinka, String ime, String prezime, String jmbg, String adresa,
			EPol pol, String brojTelefona, double plata, String brojClanskeKarteUdruzenjaTaksista,
			Automobil automobil, boolean obrisan, ArrayList<Voznja> voznje) {
		super(id, korisnickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona, obrisan);
		this.plata = plata;
		this.brojClanskeKarteUdruzenjaTaksista = brojClanskeKarteUdruzenjaTaksista;
		this.automobil = automobil;
		this.voznje = voznje;
	}




	public double getPlata() {
		return plata;
	}



	public void setPlata(double plata) {
		this.plata = plata;
	}



	public String getBrojClanskeKarteUdruzenjaTaksista() {
		return brojClanskeKarteUdruzenjaTaksista;
	}



	public void setBrojClanskeKarteUdruzenjaTaksista(String brojClanskeKarteUdruzenjaTaksista) {
		this.brojClanskeKarteUdruzenjaTaksista = brojClanskeKarteUdruzenjaTaksista;
	}



	public Automobil getAutomobil() {
		return automobil;
	}



	public void setAutomobil(Automobil automobil) {
		this.automobil = automobil;
	}
	
	

	public ArrayList<Voznja> getVoznje() {
		return voznje;
	}



	public void setVoznje(ArrayList<Voznja> voznje) {
		this.voznje = voznje;
	}



	@Override
	public String toString() {
		return "Vozac [ id=" + id + " plata=" + plata + ", brojClanskeKarteUdruzenjaTaksista=" + brojClanskeKarteUdruzenjaTaksista
				+ ", automobil=" + automobil + ", voznje=" + voznje + ", korisnickoIme=" + korisnickoIme
				+ ", lozinka=" + lozinka + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", adresa="
				+ adresa + ", pol=" + pol + ", brojTelefona=" + brojTelefona + ", obrisan=" + obrisan + "]";
	}
	
	



//	@Override
//	public String toString() {
//		String s = "Vozac " + super.toString() + 
//				"\nPlata: " + this.plata +
//				"\nbrojClanskeKarteUdruzenjaTaksista: " + this.brojClanskeKarteUdruzenjaTaksista + 
//				"\nAutomobil: " + this.automobil;
//		for (Voznja voznja : this.voznje) {
//			s += "\n" + voznja;
//		}
//		return s;
//	}


	

	
	
}
