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
@Entity
public class Komentar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String Tekst;
	@Column
	private int Ocena;

	@Override
	public String toString() {
		return "Komentar [KorisnikoImeKupca="  + ", Tekst=" + Tekst
				+ ", Ocena=" + Ocena + "]";
	}
}
