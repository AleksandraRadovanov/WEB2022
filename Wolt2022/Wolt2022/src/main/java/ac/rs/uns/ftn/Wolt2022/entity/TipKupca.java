package com.ftn.wolt2022.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class TipKupca {
	enum Ime {
		ZLATNI,
		SREBRNI,
		BRONZANI
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Ime Ime;
	private float Popust;
	private int TrazeniBrojBodova;

	@Override
	public String toString() {
		return "TipKupca [Ime=" + Ime + ", Popust=" + Popust + ", TrazeniBrojBodova=" + TrazeniBrojBodova + "]";
	}
}
