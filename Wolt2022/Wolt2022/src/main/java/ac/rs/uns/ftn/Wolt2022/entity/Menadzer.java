package ac.rs.uns.ftn.Wolt2022.entity;

import javax.persistence.*;

@Entity
public class Menadzer extends Korisnik{
	@Column(name = "restoran_id")
	private Long RestoranID;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	public Long getRestoranID() {
		return RestoranID;
	}
	public void setRestoranID(Long restoranID) {
		RestoranID = restoranID;
	}
	public Menadzer(String korisnickoIme, String lozinka, String ime, String prezime, String pol, String datumRodjenja,
			ac.rs.uns.ftn.Wolt2022.entity.Korisnik.Uloga uloga, Long restoranID, Long iD) {
		super(korisnickoIme, lozinka, ime, prezime, pol, datumRodjenja, uloga);
		RestoranID = restoranID;
		ID = iD;
	}
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
}
