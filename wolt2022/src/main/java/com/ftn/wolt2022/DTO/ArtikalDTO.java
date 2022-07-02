package com.ftn.wolt2022.DTO;

import com.ftn.wolt2022.entity.Artikal;
import com.ftn.wolt2022.entity.Restoran;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
public class ArtikalDTO {
    public ArtikalDTO(Long id, String naziv, double cena, Artikal.Tip tip, int kolicina, String opis) {
    this.id = id;
    this.naziv = naziv;
    this.cena = cena;
    this.tip = tip;
    this.kolicina = kolicina;
    this.restoran = restoran;
    }

    enum Tip {
        HRANA,
        PICE
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String naziv;
    @Column
    private double cena;
    @Column
    private Artikal.Tip tip;
    @Column
    private int kolicina;
    @Column
    private String opis;
    @Column
    private Restoran restoran;

}
