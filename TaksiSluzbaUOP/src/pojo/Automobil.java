package pojo;

import enums.ModelAutomobila;
import enums.ProizvodjacAutomobila;
import enums.VrstaTaksiVozila;

public class Automobil {

	private int id;
	private ModelAutomobila model;
	private ProizvodjacAutomobila proizvodjac;
	private String godinaProizvodnje;
	private String brRegistarskeOznake;
	private VrstaTaksiVozila vrstaTaksiVozila;
	
	public Automobil() {
		this.id = 0;
		this.model = null;
		this.proizvodjac = null;
		this.godinaProizvodnje = "";
		this.brRegistarskeOznake = "";
		this.vrstaTaksiVozila = null;
	}

	public Automobil(int id, ModelAutomobila model, ProizvodjacAutomobila proizvodjac, String godinaProizvodnje,
			String brRegistarskeOznake, VrstaTaksiVozila vrstaTaksiVozila) {
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

	public ModelAutomobila getModel() {
		return model;
	}

	public void setModel(ModelAutomobila model) {
		this.model = model;
	}

	public ProizvodjacAutomobila getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(ProizvodjacAutomobila proizvodjac) {
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

	public VrstaTaksiVozila getVrstaTaksiVozila() {
		return vrstaTaksiVozila;
	}

	public void setVrstaTaksiVozila(VrstaTaksiVozila vrstaTaksiVozila) {
		this.vrstaTaksiVozila = vrstaTaksiVozila;
	}

	@Override
	public String toString() {
		return "Automobil [id=" + id + ", model=" + model + ", proizvodjac=" + proizvodjac + ", godinaProizvodnje="
				+ godinaProizvodnje + ", brRegistarskeOznake=" + brRegistarskeOznake + ", vrstaTaksiVozila="
				+ vrstaTaksiVozila + "]";
	}

	
	
	
	
}
