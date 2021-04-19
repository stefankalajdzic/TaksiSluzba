package pojo;

import enums.Pol;

public abstract class Korisnik {

	//korisnicko ime, lozinka, ime, prezime, JMBG, adresa, pol, broj telefona. 
	protected int id;
	protected String korisnickoIme;
	protected String lozinka;
	protected String ime;
	protected String prezime;
	protected String jmbg;
	protected String adresa;
	protected Pol pol;
	protected String brojTelefona;
	
	public Korisnik() {
		this.id = 0;
		this.korisnickoIme = "";
		this.lozinka = "";
		this.ime = "";
		this.prezime = "";
		this.jmbg = "";
		this.adresa = "";
		this.pol = null;
		this.brojTelefona = "";
	}

	public Korisnik(int id, String korisnickoIme, String lozinka, String ime, String prezime, String jmbg,
			String adresa, Pol pol, String brojTelefona) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.adresa = adresa;
		this.pol = pol;
		this.brojTelefona = brojTelefona;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Pol getPol() {
		return pol;
	}

	public void setPol(Pol pol) {
		this.pol = pol;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	@Override
	public String toString() {
		return "Korisnik [id=" + id + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", ime=" + ime
				+ ", prezime=" + prezime + ", jmbg=" + jmbg + ", adresa=" + adresa + ", pol=" + pol + ", brojTelefona="
				+ brojTelefona + "]";
	}
	
	
}
