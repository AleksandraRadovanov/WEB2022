package com.ftn.wolt2022.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Porudzbina {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long Id; //Long, promenio UID
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Artikal> PoruceniArtikli = new ArrayList<>();
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Restoran> restorani = new ArrayList<>();
	@Column
	private LocalDateTime DatumIVreme;
	@Column
	private double Cena;
	@Column
	private StatusPorudzbine Status;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Dostavljac dostavljac;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Kupac kupac;
}
