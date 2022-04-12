package ac.rs.uns.ftn.Wolt2022.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Dostavljac extends Korisnik {
		@OneToMany(mappedBy = "dostavljac", cascade = CascadeType.ALL)
		private Set<Porudzbina> porudzbine = new HashSet<>();
		
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long ID;

		public Dostavljac(String korisnickoIme, String lozinka, String ime, String prezime, String pol,
				String datumRodjenja, ac.rs.uns.ftn.Wolt2022.entity.Korisnik.Uloga uloga, Set<Porudzbina> porudzbine,
				Long iD) {
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
