package main.java.Wolt.entity;

public class TipKupca {
	enum Ime {
		ZLATNI,
		SREBRNI,
		BRONZANI
	}
	private Ime Ime;
	private float Popust;
	private int TrazeniBrojBodova;
	public TipKupca(main.java.Wolt.entity.TipKupca.Ime ime, float popust, int trazeniBrojBodova) {
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
