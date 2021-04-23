package pojo;

import enums.EStatusVoznje;

public class Voznja {

	private int id;
	private String datum;
	private String vremePorudzbine;
	private String adresaPolaska;
	private String adresaDestinacije;
	private Musterija musterija;
	private Vozac vozac;
	private String brojPredjenihKilometara;
	private String trajanjeVoznje;
	private EStatusVoznje status;
	
	public Voznja() {
		this.id = 0;
		this.datum = "";
		this.vremePorudzbine = "";
		this.adresaPolaska = "";
		this.adresaDestinacije = "";
		this.musterija = new Musterija();
		this.vozac = new Vozac();
		this.brojPredjenihKilometara = "";
		this.trajanjeVoznje = "";
		this.status = null;
	}

	public Voznja(int id, String datum, String vremePorudzbine, String adresaPolaska, String adresaDestinacije,
			Musterija musterija, Vozac vozac, String brojPredjenihKilometara, String trajanjeVoznje,
			EStatusVoznje status) {
		super();
		this.id = id;
		this.datum = datum;
		this.vremePorudzbine = vremePorudzbine;
		this.adresaPolaska = adresaPolaska;
		this.adresaDestinacije = adresaDestinacije;
		this.musterija = musterija;
		this.vozac = vozac;
		this.brojPredjenihKilometara = brojPredjenihKilometara;
		this.trajanjeVoznje = trajanjeVoznje;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getVremePorudzbine() {
		return vremePorudzbine;
	}

	public void setVremePorudzbine(String vremePorudzbine) {
		this.vremePorudzbine = vremePorudzbine;
	}

	public String getAdresaPolaska() {
		return adresaPolaska;
	}

	public void setAdresaPolaska(String adresaPolaska) {
		this.adresaPolaska = adresaPolaska;
	}

	public String getAdresaDestinacije() {
		return adresaDestinacije;
	}

	public void setAdresaDestinacije(String adresaDestinacije) {
		this.adresaDestinacije = adresaDestinacije;
	}

	public Musterija getMusterija() {
		return musterija;
	}

	public void setMusterija(Musterija musterija) {
		this.musterija = musterija;
	}

	public Vozac getVozac() {
		return vozac;
	}

	public void setVozac(Vozac vozac) {
		this.vozac = vozac;
	}

	public String getBrojPredjenihKilometara() {
		return brojPredjenihKilometara;
	}

	public void setBrojPredjenihKilometara(String brojPredjenihKilometara) {
		this.brojPredjenihKilometara = brojPredjenihKilometara;
	}

	public String getTrajanjeVoznje() {
		return trajanjeVoznje;
	}

	public void setTrajanjeVoznje(String trajanjeVoznje) {
		this.trajanjeVoznje = trajanjeVoznje;
	}

	public EStatusVoznje getStatus() {
		return status;
	}

	public void setStatus(EStatusVoznje status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		return "Voznja [id=" + id + ", datum=" + datum + ", vremePorudzbine=" + vremePorudzbine + ", adresaPolaska="
				+ adresaPolaska + ", adresaDestinacije=" + adresaDestinacije + ", musterija=" + musterija + ", vozac="
				+ vozac + ", brojPredjenihKilometara=" + brojPredjenihKilometara + ", trajanjeVoznje=" + trajanjeVoznje
				+ ", status=" + status + "]";
	}
	
}
