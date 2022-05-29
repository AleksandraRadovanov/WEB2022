package com.ftn.wolt2022.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor

public class Porudzbina {
	enum Status {
		OBRADA,
		U_PRIPREMI,
		CEKA_DOSTAVLJACA,
		U_TRANSPORTU,
		DOSTAVLJENA,
		OTKAZANA
	}
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int Id; //Long, promenio UID
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Column
	private Set<Artikal> PoruceniArtikli = new HashSet<>();
	@Column
	private Restoran restoran;
	@Column
	private String DatumIVreme;
	@Column
	private double Cena;
	@Column
	private Long KupacID; //relacija
	@Column
	private Status Status;
	@OneToMany(mappedBy = "dostavljac", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Dostavljac Dostavljac;
	@OneToMany(mappedBy = "kupac", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Kupac kupac;


}
