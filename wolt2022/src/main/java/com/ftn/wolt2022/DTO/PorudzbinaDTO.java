package com.ftn.wolt2022.DTO;

import com.ftn.wolt2022.entity.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PorudzbinaDTO {
    private Long id;
    private List<Artikal> PoruceniArtikli = new ArrayList<>();
    private List<Restoran> restorani = new ArrayList<>();
    private LocalDateTime DatumIVreme;
    private double Cena;
    private StatusPorudzbine Status;
    private Dostavljac dostavljac;
    private Kupac kupac;
    public PorudzbinaDTO(Long id, List<Artikal> poruceniArtikli, List<Restoran> restorani, LocalDateTime datumIVreme, double cena, StatusPorudzbine status, Dostavljac dostavljac, Kupac kupac) {
    }
}
