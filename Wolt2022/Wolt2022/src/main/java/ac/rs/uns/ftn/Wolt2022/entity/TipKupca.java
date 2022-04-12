package ac.rs.uns.ftn.Wolt2022.entity;

import javax.persistence.*;

@Entity
public class TipKupca {
	enum Ime {
		ZLATNI,
		SREBRNI,
		BRONZANI
	}
	@Column(name = "ime")
	private Ime Ime;
	@Column(name = "popust")
	private float Popust;
	@Column(name = "trazeni_broj_bodova")
	private int TrazeniBrojBodova;
	
	public TipKupca(ac.rs.uns.ftn.Wolt2022.entity.TipKupca.Ime ime, float popust, int trazeniBrojBodova) {
		super();
		Ime = ime;
		Popust = popust;
		TrazeniBrojBodova = trazeniBrojBodova;
	}
	public Ime getIme() {
		return Ime;
	}
	public void setIme(Ime ime) {
		Ime = ime;
	}
	public float getPopust() {
		return Popust;
	}
	public void setPopust(float popust) {
		Popust = popust;
	}
	public int getTrazeniBrojBodova() {
		return TrazeniBrojBodova;
	}
	public void setTrazeniBrojBodova(int trazeniBrojBodova) {
		TrazeniBrojBodova = trazeniBrojBodova;
	}
	@Override
	public String toString() {
		return "TipKupca [Ime=" + Ime + ", Popust=" + Popust + ", TrazeniBrojBodova=" + TrazeniBrojBodova + "]";
	}

}
