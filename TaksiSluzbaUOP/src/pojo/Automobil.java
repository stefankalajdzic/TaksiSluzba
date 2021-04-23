package pojo;

import enums.EModelAutomobila;
import enums.EProizvodjacAutomobila;
import enums.EVrstaTaksiVozila;

public class Automobil {

	private int id;
	private EModelAutomobila model;
	private EProizvodjacAutomobila proizvodjac;
	private String godinaProizvodnje;
	private String brRegistarskeOznake;
	private EVrstaTaksiVozila vrstaTaksiVozila;
	
	public Automobil() {
		this.id = 0;
		this.model = null;
		this.proizvodjac = null;
		this.godinaProizvodnje = "";
		this.brRegistarskeOznake = "";
		this.vrstaTaksiVozila = null;
	}

	public Automobil(int id, EModelAutomobila model, EProizvodjacAutomobila proizvodjac, String godinaProizvodnje,
			String brRegistarskeOznake, EVrstaTaksiVozila vrstaTaksiVozila) {
		super();
		this.id = id;
		this.model = model;
		this.proizvodjac = proizvodjac;
		this.godinaProizvodnje = godinaProizvodnje;
		this.brRegistarskeOznake = brRegistarskeOznake;
		this.vrstaTaksiVozila = vrstaTaksiVozila;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EModelAutomobila getModel() {
		return model;
	}

	public void setModel(EModelAutomobila model) {
		this.model = model;
	}

	public EProizvodjacAutomobila getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(EProizvodjacAutomobila proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	public String getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(String godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}

	public String getBrRegistarskeOznake() {
		return brRegistarskeOznake;
	}

	public void setBrRegistarskeOznake(String brRegistarskeOznake) {
		this.brRegistarskeOznake = brRegistarskeOznake;
	}

	public EVrstaTaksiVozila getVrstaTaksiVozila() {
		return vrstaTaksiVozila;
	}

	public void setVrstaTaksiVozila(EVrstaTaksiVozila vrstaTaksiVozila) {
		this.vrstaTaksiVozila = vrstaTaksiVozila;
	}

	@Override
	public String toString() {
		return "Automobil [id=" + id + ", model=" + model + ", proizvodjac=" + proizvodjac + ", godinaProizvodnje="
				+ godinaProizvodnje + ", brRegistarskeOznake=" + brRegistarskeOznake + ", vrstaTaksiVozila="
				+ vrstaTaksiVozila + "]";
	}

	
	
	
	
}
