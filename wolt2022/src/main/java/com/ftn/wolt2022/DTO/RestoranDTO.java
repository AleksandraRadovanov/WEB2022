package com.ftn.wolt2022.DTO;

import com.ftn.wolt2022.entity.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class RestoranDTO {

    private Long ID;
    private String Naziv;
    private com.ftn.wolt2022.entity.TipRestorana TipRestorana;
    private List<Artikal> artikli = new ArrayList<>();

    private List<Komentar> komentari = new ArrayList<>(0);

    private com.ftn.wolt2022.entity.Lokacija Lokacija;
    private boolean Otvoren;
    private Menadzer menadzer;

    public RestoranDTO(Long ID, String naziv, com.ftn.wolt2022.entity.TipRestorana tipRestorana,
                       List<Artikal> artikli, List<Komentar> komentari,
                       com.ftn.wolt2022.entity.Lokacija lokacija, boolean otvoren,
                       Menadzer menadzer) {
        this.ID = ID;
        Naziv = naziv;
        TipRestorana = tipRestorana;
        this.artikli = artikli;
        this.komentari = komentari;
        Lokacija = lokacija;
        Otvoren = otvoren;
        this.menadzer = menadzer;
    }
}
