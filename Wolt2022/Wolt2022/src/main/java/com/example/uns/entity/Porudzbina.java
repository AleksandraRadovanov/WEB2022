package main.java.Wolt.entity;

import java.util.HashSet;
import java.util.Set;

public class Porudzbina {
	enum Status {
		OBRADA,
		U_PRIPREMI,
		CEKA_DOSTAVLJACA,
		U_TRANSPORTU,
		DOSTAVLJENA,
		OTKAZANA
	}
	private int UUID;
	private Set<Artikal> PoruceniArtikli = new HashSet<>();
	private Restoran Restoran;
	private String DatumIVreme;
	private double Cena;
	private String KorisnickoImeKupca;
	private Status Status;
	//@ManyToOne
	//@JoinColumn(name = "wolt")
	private Dostavljac Dostavljac;
	public Porudzbina(int uUID, Set<Artikal> poruceniArtikli, main.java.Wolt.entity.Restoran restoran,
			String datumIVreme, double cena, String korisnickoImeKupca,
			main.java.Wolt.entity.Porudzbina.Status status) {
		super();
		UUID = uUID;
		PoruceniArtikli = poruceniArtikli;
		Restoran = restoran;
		DatumIVreme = datumIVreme;
		Cena = cena;
		KorisnickoImeKupca = korisnickoImeKupca;
		Status = status;
	}
	public int getUUID() {
		return UUID;
	}
	public void setUUID(int uUID) {
		UUID = uUID;
	}
	public Set<Artikal> getPoruceniArtikli() {
		return PoruceniArtikli;
	}
	public void setPoruceniArtikli(Set<Artikal> poruceniArtikli) {
		PoruceniArtikli = poruceniArtikli;
	}
	public Restoran getRestoran() {
		return Restoran;
	}
	public void setRestoran(Restoran restoran) {
		Restoran = restoran;
	}
	public String getDatumIVreme() {
		return DatumIVreme;
	}
	public void setDatumIVreme(String datumIVreme) {
		DatumIVreme = datumIVreme;
	}
	public double getCena() {
		return Cena;
	}
	public void setCena(double cena) {
		Cena = cena;
	}
	public String getKorisnickoImeKupca() {
		return KorisnickoImeKupca;
	}
	public void setKorisnickoImeKupca(String korisnickoImeKupca) {
		KorisnickoImeKupca = korisnickoImeKupca;
	}
	public Status getStatus() {
		return Status;
	}
	public void setStatus(Status status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "Porudzbina [UUID=" + UUID + ", PoruceniArtikli=" + PoruceniArtikli + ", Restoran=" + Restoran
				+ ", DatumIVreme=" + DatumIVreme + ", Cena=" + Cena + ", KorisnickoImeKupca=" + KorisnickoImeKupca
				+ ", Status=" + Status + "]";
	}
	
	
}
