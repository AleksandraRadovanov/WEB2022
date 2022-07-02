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
        return restoranRepository.getRestoranById(ID);
    }
    public void save(Restoran restoranp) {
    }
    public List<Restoran> findByNaziv(String naziv) {
        return restoranRepository.findByNaziv(naziv);
    }
    public List<Restoran> findByTip(TipRestorana tip) {
        return restoranRepository.findByTip(tip);
    }
    public List<Restoran> findByLokacija(Lokacija lokacija) {
        return restoranRepository.findByLokacija(lokacija);
    }
    public Restoran  findByMenadzerID(Long menadzer_id) {
        return restoranRepository.findByMenadzerID(menadzer_id);
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
