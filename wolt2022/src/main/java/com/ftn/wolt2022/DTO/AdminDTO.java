package com.ftn.wolt2022.DTO;

import com.ftn.wolt2022.entity.Korisnik;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AdminDTO {
    private Long id;
    private String korisnickoime;
    private String lozinka;
    private String ime;
    private String prezime;
    private LocalDate datrodjenja;
    private Korisnik.Uloga uloga = Korisnik.Uloga.ADMIN;
    private String pol;

    public AdminDTO(){}

    public AdminDTO(Long id, String korisnickoime, String lozinka, String ime, String prezime, LocalDate datrodjenja, Korisnik.Uloga uloga, String pol) {
        this.id = id;
        this.korisnickoime = korisnickoime;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.datrodjenja = datrodjenja;
        this.uloga = uloga;
        this.pol = pol;
    }

}
