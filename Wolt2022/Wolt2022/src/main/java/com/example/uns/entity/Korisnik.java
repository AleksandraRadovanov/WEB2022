package main.java.Wolt.entity;

import java.io.Serializable;

public class Korisnik implements Serializable {
	enum Uloga {
		ADMIN,
		MENADZER,
		DOSTAVLJAC,
		KUPAC
	}
	private Long ID;
	private String KorisnickoIme;
	private String Lozinka;
	private String Ime;
	private String Prezime;
	private String Pol;
	private String DatumRodjenja;
	private Uloga Uloga;
	
	public String getKorisnickoIme() {
		return KorisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		KorisnickoIme = korisnickoIme;
	}
	public String getID() {
		return ID;
	}
	public void setID(Long id) {
		ID = id;
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
			main.java.Wolt.entity.Korisnik.Uloga uloga) {
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
