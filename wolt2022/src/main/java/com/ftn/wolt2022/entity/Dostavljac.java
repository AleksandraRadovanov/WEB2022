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
	@OneToMany(cascade = CascadeType.ALL)
	private List<Porudzbina> porudzbine = new ArrayList<>(0);
}
