package pojo;

import enums.EPol;

public class Vozac extends Korisnik {
	
	private double plata;
	private String brojClanskeKarteUdruzenjaTaksista;
	private Automobil automobil;
	
	public Vozac() {
		this.plata = 0;
		this.brojClanskeKarteUdruzenjaTaksista = "";
		this.automobil = new Automobil();
	}

	

	public Vozac(int id, String korisnickoIme, String lozinka, String ime, String prezime, String jmbg, String adresa,
			EPol pol, String brojTelefona, double plata, String brojClanskeKarteUdruzenjaTaksista,
			Automobil automobil, boolean obrisan) {
		super(id, korisnickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona, obrisan);
		this.plata = plata;
		this.brojClanskeKarteUdruzenjaTaksista = brojClanskeKarteUdruzenjaTaksista;
		this.automobil = automobil;
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



	@Override
	public String toString() {
		return "Vozac [plata=" + plata + ", brojClanskeKarteUdruzenjaTaksista=" + brojClanskeKarteUdruzenjaTaksista
				+ ", automobil=" + automobil + ", id=" + id + ", korisnickoIme=" + korisnickoIme + ", lozinka="
				+ lozinka + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", adresa=" + adresa + ", pol="
				+ pol + ", brojTelefona=" + brojTelefona + ", obrisan=" + obrisan + "]";
	}



	

	
	
}
