package com.ftn.wolt2022.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Menadzer {
	@OneToOne(mappedBy = "menadzer", cascade = CascadeType.ALL)
    private Restoran restoran;
    public enum Uloga {
        ADMIN,
        MENADZER,
        DOSTAVLJAC,
        KUPAC
    }
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column
    private String korisnickoIme;
    @Column
    private String lozinka;
    @Column
    private String ime;
    @Column
    private String prezime;
    @Column
    private String pol;
    @Column
    private LocalDate datumRodjenja;
    @Column
    private Korisnik.Uloga uloga;

}
