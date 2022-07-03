package com.ftn.wolt2022.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Korisnik implements Serializable {
	public enum Uloga {
		ADMIN,
		MENADZER,
		DOSTAVLJAC,
		KUPAC
	}
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	@Column
	private String korisnickoIme;
	@Column
	private String lozinka;
	@Column
	private String ime;
	@Column
	private String prezime;
	@Column
	private String pol;
	@Column
	private LocalDate datumRodjenja;
	@Column
	private Uloga uloga;

	@Override
	public String toString() {
		return "Korisnik [KorisnickoIme=" + korisnickoIme + ", Lozinka=" + lozinka + ", Ime=" + ime + ", Prezime="
				+ prezime + ", Pol=" + pol + ", DatumRodjenja=" + datumRodjenja + ", Uloga=" + uloga + "]";
	}
}
