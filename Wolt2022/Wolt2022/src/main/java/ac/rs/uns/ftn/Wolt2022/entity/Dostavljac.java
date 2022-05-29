package com.ftn.wolt2022.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Dostavljac extends Korisnik{
	@OneToMany(mappedBy = "porudzbina", cascade = CascadeType.ALL)
	private Set<Porudzbina> porudzbine = new HashSet<>();

	public Dostavljac(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String pol, LocalDate datumRodjenja, Korisnik.Uloga uloga, Set<Porudzbina> porudzbine) {
	}
}
