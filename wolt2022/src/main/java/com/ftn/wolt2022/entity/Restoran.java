package com.ftn.wolt2022.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.profile.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restoran {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String naziv;
	private TipRestorana tipRestorana;
	@OneToMany(mappedBy = "restoran", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Artikal> artikli = new ArrayList<>();

	@OneToMany(mappedBy = "restoran",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Komentar> komentari = new ArrayList<>(0);

	@OneToOne(fetch = FetchType.LAZY)
	private Lokacija lokacija;

	private boolean otvoren;

	@OneToOne(fetch = FetchType.LAZY)
	private Menadzer menadzer;

	@Override
	public String toString() {
		return "Restoran [Naziv=" + naziv + ", TipRestotana=" + tipRestorana + ", artikli=" + artikli + ", Lokacija="
				+ lokacija + "]";
	}
}
