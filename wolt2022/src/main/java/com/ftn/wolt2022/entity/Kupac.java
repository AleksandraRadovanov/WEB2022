package com.ftn.wolt2022.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Kupac extends Korisnik {

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private TipKupca TipKupca;
	@Column
	private int SakulpljeniBodovi;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Komentar> komentari = new ArrayList<>(0);

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Porudzbina> porudzbine = new ArrayList<>(0);
}
