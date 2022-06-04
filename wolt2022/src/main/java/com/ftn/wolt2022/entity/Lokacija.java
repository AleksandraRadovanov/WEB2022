package com.ftn.wolt2022.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Lokacija {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private double GeografskaDuzina;
	private double GeografskaSirina;
	private String Adresa;

	@Override
	public String toString() {
		return "Lokacija [GeografskaDuzina=" + GeografskaDuzina + ", GeografskaSirina=" + GeografskaSirina + ", Adresa="
				+ Adresa + "]";
	}
}
