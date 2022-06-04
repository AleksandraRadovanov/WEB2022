package com.ftn.wolt2022.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Artikal {
	enum Tip {
		HRANA,
		PICE
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	@Column
	private String Naziv;
	@Column
	private double Cena;
	@Column
	private Tip Tip;
	@Column
	private int Kolicina;
	@Column
	private String Opis;

//	@ManyToOne(fetch = FetchType.LAZY) //LAZY kad su liste u pitanju
//	private Restoran Restoran;

	@Override
	public String toString() {
		return "Artikal [Naziv=" + Naziv + ", Cena=" + Cena + ", Tip=" + Tip + ", Kolicina=" + Kolicina + ", Opis="
				+ Opis + "]";
	}
}
