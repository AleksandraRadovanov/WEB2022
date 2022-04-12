package ac.rs.uns.ftn.Wolt2022.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Kupac extends Korisnik {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Column(name = "tip_kupca")
	private TipKupca TipKupca;
	
	@Column(name = "sakupljeni_bodovi")
	private int SakulpljeniBodovi;
	
	@ManyToMany
	private Set<Porudzbina> porudzbine = new HashSet<>();
	
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}
	
	public Kupac(String korisnickoIme, String lozinka, String ime, String prezime, String pol, String datumRodjenja,
			ac.rs.uns.ftn.Wolt2022.entity.Korisnik.Uloga uloga, Long iD,
			ac.rs.uns.ftn.Wolt2022.entity.TipKupca tipKupca, int sakulpljeniBodovi, Set<Porudzbina> porudzbine) {
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
