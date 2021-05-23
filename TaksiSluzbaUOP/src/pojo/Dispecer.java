package pojo;

import enums.EPol;
import enums.ETelefonskaOdeljenja;

public class Dispecer extends Korisnik {

	private double plata;
	private String brojTelefonskeLinije;
	private ETelefonskaOdeljenja telefonskaOdeljenja;
	
	public Dispecer() {
		this.plata = 0;
		this.brojTelefonskeLinije = "";
		this.telefonskaOdeljenja = null;
	}

	public Dispecer(int id, String korisnickoIme, String lozinka, String ime, String prezime, String jmbg,
			String adresa, EPol pol, String brojTelefona, double plata, String brojTelefonskeLinije,
			ETelefonskaOdeljenja telefonskaOdeljenja, boolean obrisan) {
		super(id, korisnickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona, obrisan);
		this.plata = plata;
		this.brojTelefonskeLinije = brojTelefonskeLinije;
		this.telefonskaOdeljenja = telefonskaOdeljenja;
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public String getBrojTelefonskeLinije() {
		return brojTelefonskeLinije;
	}

	public void setBrojTelefonskeLinije(String brojTelefonskeLinije) {
		this.brojTelefonskeLinije = brojTelefonskeLinije;
	}

	public ETelefonskaOdeljenja getTelefonskaOdeljenja() {
		return telefonskaOdeljenja;
	}

	public void setTelefonskaOdeljenja(ETelefonskaOdeljenja telefonskaOdeljenja) {
		this.telefonskaOdeljenja = telefonskaOdeljenja;
	}

	@Override
	public String toString() {
		return "Dispecer [plata=" + plata + ", brojTelefonskeLinije=" + brojTelefonskeLinije + ", telefonskaOdeljenja="
				+ telefonskaOdeljenja + ", id=" + id + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka
				+ ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", adresa=" + adresa + ", pol=" + pol
				+ ", brojTelefona=" + brojTelefona + ", obrisan=" + obrisan + "]";
	}

}