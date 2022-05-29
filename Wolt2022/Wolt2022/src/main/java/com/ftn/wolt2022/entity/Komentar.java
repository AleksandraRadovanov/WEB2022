package com.ftn.wolt2022.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Komentar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column

	private String KorisnikoImeKupca;
	@Column
	private Long IDRestorana;
	@Column
	private String Tekst;
	@Column
	private int Ocena;
	@OneToMany(mappedBy = "restoran", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Restoran restoran;

	@OneToMany(mappedBy = "kupac", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Kupac kupac;

	@Override
	public String toString() {
		return "Komentar [KorisnikoImeKupca=" + KorisnikoImeKupca + ", IDRestorana=" + IDRestorana + ", Tekst=" + Tekst
				+ ", Ocena=" + Ocena + "]";
	}
}
