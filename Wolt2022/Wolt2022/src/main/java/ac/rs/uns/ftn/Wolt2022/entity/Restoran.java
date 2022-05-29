package com.ftn.wolt2022.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Restoran {
	public Restoran(Long id, String naziv, Tip tipRestorana) {
		this.ID = id;
		this.Naziv = naziv;
		this.TipRestorana = tipRestorana;
	}

	public enum Tip {
		SRPSKI,
		ITALIJANSKI,
		KINESKI,
		TURSKI
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	private String Naziv;
	private Tip TipRestorana;
	@OneToMany(mappedBy = "restoran", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Artikal> artikli = new HashSet<>(); //relacija
	private Lokacija Lokacija; //relacija
	private boolean Otvoren;

	private Menadzer menadzer;

	@Override
	public String toString() {
		return "Restoran [Naziv=" + Naziv + ", TipRestotana=" + TipRestorana + ", artikli=" + artikli + ", Lokacija="
				+ Lokacija + "]";
	}
}
