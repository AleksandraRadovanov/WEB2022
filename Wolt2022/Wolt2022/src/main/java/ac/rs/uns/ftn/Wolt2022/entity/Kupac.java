package com.ftn.wolt2022.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Kupac extends Korisnik {

	public com.ftn.wolt2022.entity.TipKupca getTipKupca() {
		return TipKupca;
	}
	@Column
	private TipKupca TipKupca;
	@Column
	
	private int SakulpljeniBodovi;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Komentar> komentari = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Porudzbina> porudzbine = new HashSet<>();


}
