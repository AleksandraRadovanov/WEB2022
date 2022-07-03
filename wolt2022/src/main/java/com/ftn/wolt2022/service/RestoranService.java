package com.ftn.wolt2022.service;

import antlr.ASTNULLType;
import com.ftn.wolt2022.entity.Lokacija;
import com.ftn.wolt2022.entity.Menadzer;
import com.ftn.wolt2022.entity.Restoran;
import com.ftn.wolt2022.entity.TipRestorana;
import com.ftn.wolt2022.repository.RestoranRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ftn.wolt2022.service.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestoranService {
    public final RestoranRepository restoranRepository;
    public List<Restoran> findAll() {
        return restoranRepository.findAll();
    }

    public Restoran getRestoranById(Long ID)
    {
        Optional<Restoran>restoran = restoranRepository.findById(ID);
        return restoran.orElse(null);
    }

    public Restoran findByNaziv(String naziv) {
        Restoran restoran = restoranRepository.findByNaziv(naziv);
        return restoran;
    }
    public Restoran findByTip(TipRestorana tip) {
        Restoran restoran = restoranRepository.findByTipRestorana(tip);
        return restoran;
    }
    public Restoran findByLokacija(Lokacija lokacija) {
        Restoran restoran = restoranRepository.findByLokacija(lokacija);
        return restoran;
    }
    public Restoran  findByMenadzerID(Long menadzer_id) {
        return restoranRepository.findByMenadzerId(menadzer_id);
    }
    public Restoran create(Restoran res) {
        Restoran restoran1 = new Restoran();

        restoran1.setNaziv(res.getNaziv());
        restoran1.setTipRestorana(res.getTipRestorana());
        restoran1.setLokacija(res.getLokacija());
        restoran1.setOtvoren(res.isOtvoren());
        restoran1.setArtikli(res.getArtikli());
        restoran1.setKomentari(res.getKomentari());
        restoran1.setMenadzer(res.getMenadzer());

        restoranRepository.save(restoran1);

        return restoran1;
    }
}
