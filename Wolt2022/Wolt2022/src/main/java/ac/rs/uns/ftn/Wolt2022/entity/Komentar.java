package ac.rs.uns.ftn.Wolt2022.entity;

public class Komentar {
	private String KorisnikoImeKupca;
	private Long IDRestorana;
	private String Tekst;
	private int Ocena;
	public Komentar(String korisnikoImeKupca, Long iDRestorana, String tekst, int ocena) {
		super();
		KorisnikoImeKupca = korisnikoImeKupca;
		IDRestorana = iDRestorana;
		Tekst = tekst;
		Ocena = ocena;
	}
	public String getKorisnikoImeKupca() {
		return KorisnikoImeKupca;
	}
	public void setKorisnikoImeKupca(String korisnikoImeKupca) {
		KorisnikoImeKupca = korisnikoImeKupca;
	}
	public Long getIDRestorana() {
		return IDRestorana;
	}
	public void setIDRestorana(Long iDRestorana) {
		IDRestorana = iDRestorana;
	}
	public String getTekst() {
		return Tekst;
	}
	public void setTekst(String tekst) {
		Tekst = tekst;
	}
	public int getOcena() {
		return Ocena;
	}
	public void setOcena(int ocena) {
		Ocena = ocena;
	}
	@Override
	public String toString() {
		return "Komentar [KorisnikoImeKupca=" + KorisnikoImeKupca + ", IDRestorana=" + IDRestorana + ", Tekst=" + Tekst
				+ ", Ocena=" + Ocena + "]";
	}

}
