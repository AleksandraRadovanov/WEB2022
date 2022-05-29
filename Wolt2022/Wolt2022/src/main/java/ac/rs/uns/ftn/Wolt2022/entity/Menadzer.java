package com.ftn.wolt2022.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Menadzer extends Korisnik {
	private Long restoranID;

	public Menadzer(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String pol, LocalDate datumRodjenja, Korisnik.Uloga uloga, Long restoranID) {

	}
}
