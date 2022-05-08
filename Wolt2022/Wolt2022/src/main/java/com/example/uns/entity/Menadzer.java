package main.java.Wolt.entity;

public class Menadzer extends Korisnik {
	private Long RestoranID;
	private Long ID;


	public Long getRestoranID() {
		return RestoranID;
	}
	public void setRestoranID(Long restoranID) {
		RestoranID = restoranID;
	}
	public Menadzer(String korisnickoIme, String lozinka, String ime, String prezime, String pol, String datumRodjenja,
			main.java.Wolt.entity.Korisnik.Uloga uloga, Long restoranID, Long iD) {
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
