package ac.rs.uns.ftn.Wolt2022.entity;

import javax.persistence.*;

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
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int UUID;
	@OneToMany(mappedBy = "artikal", 
			fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Artikal> PoruceniArtikli = new HashSet<>();
	@Column(name = "restoran")
	private Restoran Restoran;
	@Column(name = "datum_i_vreme")
	private String DatumIVreme;
	@Column(name = "cena")
	private double Cena;
	@Column(name = "korisnicko_ime")
	private String KorisnickoImeKupca;
	@Column(name = "status")
	private Status Status;
	@ManyToOne(fetch = FetchType.EAGER)
	private Dostavljac Dostavljac;

	public Porudzbina(int uUID, Set<Artikal> poruceniArtikli, ac.rs.uns.ftn.Wolt2022.entity.Restoran restoran,
			String datumIVreme, double cena, String korisnickoImeKupca,
			ac.rs.uns.ftn.Wolt2022.entity.Porudzbina.Status status,
			ac.rs.uns.ftn.Wolt2022.entity.Dostavljac dostavljac) {
		super();
		UUID = uUID;
		PoruceniArtikli = poruceniArtikli;
		Restoran = restoran;
		DatumIVreme = datumIVreme;
		Cena = cena;
		KorisnickoImeKupca = korisnickoImeKupca;
		Status = status;
		Dostavljac = dostavljac;
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
