package ac.rs.uns.ftn.Wolt2022.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Korisnik implements Serializable {
	enum Uloga {
		ADMIN,
		MENADZER,
		DOSTAVLJAC,
		KUPAC
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String KorisnickoIme;
	
	@Column(name = "lozinka", unique = true)
	private String Lozinka;
	
	@Column(name = "ime")
	private String Ime;
	
	@Column(name = "prezime")
	private String Prezime;
	
	@Column(name = "pol")
	private String Pol;
	
	@Column(name = "datum_rodjenja")
	private String DatumRodjenja;
	
	@Column(name = "uloga")
	private Uloga Uloga;
	
	public String getKorisnickoIme() {
		return KorisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		KorisnickoIme = korisnickoIme;
	}
	public String getLozinka() {
		return Lozinka;
	}
	public void setLozinka(String lozinka) {
		Lozinka = lozinka;
	}
	public String getIme() {
		return Ime;
	}
	public void setIme(String ime) {
		Ime = ime;
	}
	public String getPrezime() {
		return Prezime;
	}
	public void setPrezime(String prezime) {
		Prezime = prezime;
	}
	public String getPol() {
		return Pol;
	}
	public void setPol(String pol) {
		Pol = pol;
	}
	public String getDatumRodjenja() {
		return DatumRodjenja;
	}
	public void setDatumRodjenja(String datumRodjenja) {
		DatumRodjenja = datumRodjenja;
	}
	public Uloga getUloga() {
		return Uloga;
	}
	public void setUloga(Uloga uloga) {
		Uloga = uloga;
	}
	public Korisnik(String korisnickoIme, String lozinka, String ime, String prezime, String pol, String datumRodjenja,
			ac.rs.uns.ftn.Wolt2022.entity.Korisnik.Uloga uloga) {
		super();
		KorisnickoIme = korisnickoIme;
		Lozinka = lozinka;
		Ime = ime;
		Prezime = prezime;
		Pol = pol;
		DatumRodjenja = datumRodjenja;
		Uloga = uloga;
	}
	@Override
	public String toString() {
		return "Korisnik [KorisnickoIme=" + KorisnickoIme + ", Lozinka=" + Lozinka + ", Ime=" + Ime + ", Prezime="
				+ Prezime + ", Pol=" + Pol + ", DatumRodjenja=" + DatumRodjenja + ", Uloga=" + Uloga + "]";
	}
}
