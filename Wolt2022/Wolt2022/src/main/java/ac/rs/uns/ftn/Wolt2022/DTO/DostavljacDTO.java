package com.ftn.wolt2022.DTO;

import com.ftn.wolt2022.entity.Korisnik;

import java.time.LocalDate;

public class DostavljacDTO {
    private Long ID;
    private String KorisnickoIme;
    private String Lozinka;
    private String Ime;
    private String Prezime;
    private String Pol;
    private LocalDate DatumRodjenja;
    private Korisnik.Uloga Uloga = Korisnik.Uloga.DOSTAVLJAC;


}
