package pojo;

import java.util.ArrayList;

import enums.EPol;

public class Musterija extends Korisnik {
	
	private ArrayList<Voznja> njegoveVoznje;
	
	
	
	public Musterija() {
		
		this.njegoveVoznje = new ArrayList<Voznja>();
		
	}
	
	

	public Musterija(int id, String korisnickoIme, String lozinka, String ime, String prezime, String jmbg,
			String adresa, EPol pol, String brojTelefona, ArrayList<Voznja> voznje, boolean obrisan) {
		
		super(id, korisnickoIme, lozinka, ime, prezime, jmbg, adresa, pol, brojTelefona, obrisan);
		
		this.njegoveVoznje = voznje;
		
	}

	
	
	
	public ArrayList<Voznja> getNjegoveVoznje() {
		return njegoveVoznje;
	}

	public void setNjegoveVoznje(ArrayList<Voznja> njegoveVoznje) {
		this.njegoveVoznje = njegoveVoznje;
	}

	@Override
	public String toString() {
		return "Musterija [njegoveVoznje=" + njegoveVoznje + ", id=" + id + ", korisnickoIme=" + korisnickoIme
				+ ", lozinka=" + lozinka + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", adresa="
				+ adresa + ", pol=" + pol + ", brojTelefona=" + brojTelefona + ", obrisan=" + obrisan + "]";
	}


	

	
}
