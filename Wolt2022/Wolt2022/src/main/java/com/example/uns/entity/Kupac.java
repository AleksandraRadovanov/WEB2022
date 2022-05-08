package main.java.Wolt.entity;

import java.util.HashSet;
import java.util.Set;

public class Kupac extends Korisnik {
	
	private Long ID;
	private TipKupca TipKupca;
	
	private int SakulpljeniBodovi;
	
	//@ManyToMany
	private Set<Porudzbina> porudzbine = new HashSet<>();
	
	
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Kupac(String korisnickoIme, String lozinka, String ime, String prezime, String pol, String datumRodjenja,
			main.java.Wolt.entity.Korisnik.Uloga uloga, Long iD, main.java.Wolt.entity.TipKupca tipKupca,
			int sakulpljeniBodovi, Set<Porudzbina> porudzbine) {
		super(korisnickoIme, lozinka, ime, prezime, pol, datumRodjenja, uloga);
		ID = iD;
		TipKupca = tipKupca;
		SakulpljeniBodovi = sakulpljeniBodovi;
		this.porudzbine = porudzbine;
	}

	public TipKupca getTipKupca() {
		return TipKupca;
	}

	public void setTipKupca(TipKupca tipKupca) {
		TipKupca = tipKupca;
	}

	public int getSakulpljeniBodovi() {
		return SakulpljeniBodovi;
	}

	public void setSakulpljeniBodovi(int sakulpljeniBodovi) {
		SakulpljeniBodovi = sakulpljeniBodovi;
	}

	public Set<Porudzbina> getPorudzbine() {
		return porudzbine;
	}

	public void setPorudzbine(Set<Porudzbina> porudzbine) {
		this.porudzbine = porudzbine;
	}
	

}
