package com.ftn.wolt2022.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Korisnik implements Serializable {
	public enum Uloga {
		ADMIN,
		MENADZER,
		DOSTAVLJAC,
		KUPAC
	}
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long ID;
	@Column
	private String KorisnickoIme;
	@Column
	private String Lozinka;
	@Column
	private String Ime;
	@Column
	private String Prezime;
	@Column
	private String Pol;
	@Column
	private LocalDate DatumRodjenja;
	@Column
	private Uloga Uloga;

	public Korisnik(Long ID, String korisnickoIme, String lozinka, String ime, String prezime, String pol, LocalDate datumRodjenja, Korisnik.Uloga uloga) {
		this.ID = ID;
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
