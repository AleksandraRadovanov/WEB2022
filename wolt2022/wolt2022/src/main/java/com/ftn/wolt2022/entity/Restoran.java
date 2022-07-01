package com.ftn.wolt2022.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restoran {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	private String Naziv;
	private TipRestorana TipRestorana;
	@OneToMany(mappedBy = "restoran", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Artikal> artikli = new ArrayList<>();

	@OneToMany(mappedBy = "restoran",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Komentar> komentari = new ArrayList<>(0);

	@OneToOne
	@MapsId
	private Lokacija Lokacija;
	private boolean Otvoren;

	@OneToOne
	@JoinColumn(name = "manager_id")
	private Menadzer menadzer;

	@Override
	public String toString() {
		return "Restoran [Naziv=" + Naziv + ", TipRestotana=" + TipRestorana + ", artikli=" + artikli + ", Lokacija="
				+ Lokacija + "]";
	}
}
