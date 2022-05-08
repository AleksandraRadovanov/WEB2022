package main.java.Wolt.entity;

import java.util.HashSet;
import java.util.Set;

public class Restoran {
	enum Tip {
		SRPSKI,
		ITALIJANSKI,
		KINESKI,
		TURSKI
	}
	private Long ID;
	private String Naziv;
	private Tip TipRestotana;
	//@OneToMany(mappedBy = "restoran", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Artikal> artikli = new HashSet<>();
	private Lokacija Lokacija;
	private bool Otvoren;
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	
	public bool getOtvoren() {
		return ID;
	}
	public void setOtvoren(bool otvoren) {
		Otvoren = otvoren;
	}
	public Restoran(Long iD, String naziv, Tip tipRestotana, Set<Artikal> artikli,
			main.java.Wolt.entity.Lokacija lokacija) {
		super();
		ID = iD;
		Naziv = naziv;
		TipRestotana = tipRestotana;
		this.artikli = artikli;
		Lokacija = lokacija;
	}
	public String getNaziv() {
		return Naziv;
	}
	public void setNaziv(String naziv) {
		Naziv = naziv;
	}
	public Tip getTipRestotana() {
		return TipRestotana;
	}
	public void setTipRestotana(Tip tipRestotana) {
		TipRestotana = tipRestotana;
	}
	public Set<Artikal> getArtikli() {
		return artikli;
	}
	public void setArtikli(Set<Artikal> artikli) {
		this.artikli = artikli;
	}
	public Lokacija getLokacija() {
		return Lokacija;
	}
	public void setLokacija(Lokacija lokacija) {
		Lokacija = lokacija;
	}
	@Override
	public String toString() {
		return "Restoran [Naziv=" + Naziv + ", TipRestotana=" + TipRestotana + ", artikli=" + artikli + ", Lokacija="
				+ Lokacija + "]";
	}
	
	
}
