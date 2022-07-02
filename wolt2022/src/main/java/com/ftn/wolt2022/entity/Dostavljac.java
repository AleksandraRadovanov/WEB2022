package com.ftn.wolt2022.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Dostavljac extends Korisnik {
	public Dostavljac(List<Porudzbina> porudzbine) {
		this.porudzbine = porudzbine;
	}

	@OneToMany(cascade = CascadeType.ALL)
	private List<Porudzbina> porudzbine = new ArrayList<>(0);

	public Dostavljac(Long id,
					  String korisnickoIme,
					  String lozinka,
					  String ime,
					  String prezime,
					  String pol,
					  LocalDate datumRodjenja,
					  Korisnik.Uloga uloga,
					  List<Porudzbina> porudzbine)
	{
		super();
	}
}
