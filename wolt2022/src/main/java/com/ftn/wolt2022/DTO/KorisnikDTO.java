package com.ftn.wolt2022.DTO;

import com.ftn.wolt2022.entity.Korisnik;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class KorisnikDTO {
    public enum Uloga {
        ADMIN,
        MENADZER,
        DOSTAVLJAC,
        KUPAC
    }
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long ID;
    @Column
    private String korisnickoIme;
    @Column
    private String lozinka;
    @Column
    private String Ime;
    @Column
    private String Prezime;
    @Column
    private String Pol;
    @Column
    private LocalDate DatumRodjenja;
    @Column
    private Korisnik.Uloga Uloga;

    public KorisnikDTO(Long ID, String korisnickoIme,
                       String lozinka, String ime,
                       String prezime, String pol,
                       LocalDate datumRodjenja,
                       Korisnik.Uloga uloga) {
        this.ID = ID;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        Ime = ime;
        Prezime = prezime;
        Pol = pol;
        DatumRodjenja = datumRodjenja;
        Uloga = uloga;
    }
}
