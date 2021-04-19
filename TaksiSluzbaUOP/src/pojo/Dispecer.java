package pojo;

import enums.Pol;
import enums.TelefonskaOdeljenja;

public class Dispecer extends Korisnik {

	private double plata;
	private String brojTelefonskeLinije;
	private TelefonskaOdeljenja telefonskaOdeljenja;
	
	public Dispecer() {
		this.plata = 0;
		this.brojTelefonskeLinije = "";
		this.telefonskaOdeljenja = null;
	}

	public Dispecer(int id, String korisnickoIme, String lozinka, String ime, String prezime, String jmbg,
			String adresa, Pol pol, String brojTelefona, double plata, String brojTelefonskeLinije,
			TelefonskaOdeljenja telefonskaOdeljenja) {
		super(id, korisnickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona);
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

	public TelefonskaOdeljenja getTelefonskaOdeljenja() {
		return telefonskaOdeljenja;
	}

	public void setTelefonskaOdeljenja(TelefonskaOdeljenja telefonskaOdeljenja) {
		this.telefonskaOdeljenja = telefonskaOdeljenja;
	}

	@Override
	public String toString() {
		return "Dispecer [plata=" + plata + ", brojTelefonskeLinije=" + brojTelefonskeLinije + ", telefonskaOdeljenja="
				+ telefonskaOdeljenja + ", id=" + id + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka
				+ ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", adresa=" + adresa + ", pol=" + pol
				+ ", brojTelefona=" + brojTelefona + "]";
	}
	
	
	
}
