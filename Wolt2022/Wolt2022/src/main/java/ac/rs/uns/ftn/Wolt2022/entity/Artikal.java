package ac.rs.uns.ftn.Wolt2022.entity;

import javax.persistence.*;

@Entity
public class Artikal {
	enum Tip {
		HRANA,
		PICE
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Column(name = "naziv")
	private String Naziv;
	
	@Column(name = "cena")
	private double Cena;
	
	@Column(name = "tip")
	private Tip Tip;
	
	@Column(name = "kolicina")
	private int Kolicina;
	
	@Column(name = "opis")
	private String Opis;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Restoran Restoran;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Porudzbina Porudzbina;
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	
	public Artikal(Long iD, String naziv, double cena, ac.rs.uns.ftn.Wolt2022.entity.Artikal.Tip tip, int kolicina,
			String opis, ac.rs.uns.ftn.Wolt2022.entity.Restoran restoran) {
		super();
		ID = iD;
		Naziv = naziv;
		Cena = cena;
		Tip = tip;
		Kolicina = kolicina;
		Opis = opis;
		Restoran = restoran;
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
