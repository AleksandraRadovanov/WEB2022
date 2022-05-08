package main.java.Wolt.entity;

public class Lokacija {
	private double GeografskaDuzina;
	private double GeografskaSirina;
	private String Adresa;
	public Lokacija(double geografskaDuzina, double geografskaSirina, String adresa) {
		super();
		GeografskaDuzina = geografskaDuzina;
		GeografskaSirina = geografskaSirina;
		Adresa = adresa;
	}
	public double getGeografskaDuzina() {
		return GeografskaDuzina;
	}
	public void setGeografskaDuzina(double geografskaDuzina) {
		GeografskaDuzina = geografskaDuzina;
	}
	public double getGeografskaSirina() {
		return GeografskaSirina;
	}
	public void setGeografskaSirina(double geografskaSirina) {
		GeografskaSirina = geografskaSirina;
	}
	public String getAdresa() {
		return Adresa;
	}
	public void setAdresa(String adresa) {
		Adresa = adresa;
	}
	@Override
	public String toString() {
		return "Lokacija [GeografskaDuzina=" + GeografskaDuzina + ", GeografskaSirina=" + GeografskaSirina + ", Adresa="
				+ Adresa + "]";
	}
	
	
}
