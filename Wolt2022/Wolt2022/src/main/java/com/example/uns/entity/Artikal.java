package main.java.Wolt.entity;

public class Artikal {
	enum Tip {
		HRANA,
		PICE
	}
	@Id
	@GeneratedValue(strategy = GenerationTyoe.)
	private Long ID;
	private String Naziv;
	private double Cena;
	private Tip Tip;
	private int Kolicina;
	private String Opis;
	@ManyToOne(fetch = FetchType.EAGER)
	private Restoran Restoran;
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public Artikal(Long iD, String naziv, double cena, main.java.Wolt.entity.Artikal.Tip tip, int kolicina,
			String opis) {
		super();
		ID = iD;
		Naziv = naziv;
		Cena = cena;
		Tip = tip;
		Kolicina = kolicina;
		Opis = opis;
	}
	public String getNaziv() {
		return Naziv;
	}
	public void setNaziv(String naziv) {
		Naziv = naziv;
	}
	public double getCena() {
		return Cena;
	}
	public void setCena(double cena) {
		Cena = cena;
	}
	public Tip getTip() {
		return Tip;
	}
	public void setTip(Tip tip) {
		Tip = tip;
	}
	public int getKolicina() {
		return Kolicina;
	}
	public void setKolicina(int kolicina) {
		Kolicina = kolicina;
	}
	public String getOpis() {
		return Opis;
	}
	public void setOpis(String opis) {
		Opis = opis;
	}
	@Override
	public String toString() {
		return "Artikal [Naziv=" + Naziv + ", Cena=" + Cena + ", Tip=" + Tip + ", Kolicina=" + Kolicina + ", Opis="
				+ Opis + "]";
	}
	
	
}
