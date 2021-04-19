package pojo;

import enums.Pol;

public class Musterija extends Korisnik {

	public Musterija() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Musterija(int id, String korisnickoIme, String lozinka, String ime, String prezime, String jmbg,
			String adresa, Pol pol, String brojTelefona) {
		super(id, korisnickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona);
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Musterija [id=" + id + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", ime=" + ime
				+ ", prezime=" + prezime + ", jmbg=" + jmbg + ", adresa=" + adresa + ", pol=" + pol + ", brojTelefona="
				+ brojTelefona + "]";
	}

	
	
}
