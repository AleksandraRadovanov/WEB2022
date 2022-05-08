package main.java.Wolt.entity;

import java.util.HashSet;
import java.util.Set;

//@Entity
public class Dostavljac extends Korisnik{
	//@OneToMany(mappedBy = "dostavljac", cascade = CascadeType.ALL)
	private Set<Porudzbina> porudzbine = new HashSet<>();
	private Long ID;

	public Dostavljac(String korisnickoIme, String lozinka, String ime, String prezime, String pol,
			String datumRodjenja, main.java.Wolt.entity.Korisnik.Uloga uloga, Set<Porudzbina> porudzbine, Long iD) {
		super(korisnickoIme, lozinka, ime, prezime, pol, datumRodjenja, uloga);
		this.porudzbine = porudzbine;
		ID = iD;
	}

	public Set<Porudzbina> getPorudzbine() {
		return porudzbine;
	}

	public void setPorudzbine(Set<Porudzbina> porudzbine) {
		this.porudzbine = porudzbine;
	}
	
	
}
