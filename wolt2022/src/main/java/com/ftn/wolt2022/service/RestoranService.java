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
        List<Restoran> restorani = new ArrayList<Restoran>();

        return restorani;
    }

    public static Restoran getRestoranById(Long ID)
    {
        Restoran restoran = new Restoran();

        return restoran;
    }
    public void save(Restoran restoranp) {
    }
    public List<Restoran> findByNaziv(String naziv) {
        List<Restoran> restorani = findAll();
        List<Restoran> pom = new ArrayList<Restoran>();
        for(Restoran r : restorani)
        {
            if(r.getNaziv().equals(naziv))
            {
                pom.add(r);
            }
        }
        return pom;
    }
    public List<Restoran> findByTip(TipRestorana tip) {
        List<Restoran> restorani = findAll();
        List<Restoran> pom = new ArrayList<Restoran>();
        for(Restoran r : restorani)
        {
            if(r.getTipRestorana() == tip)
            {
                pom.add(r);
            }
        }
        return pom;
    }
    public List<Restoran> findByLokacija(Lokacija lokacija) {
        List<Restoran> restorani = findAll();
        List<Restoran> pom = new ArrayList<Restoran>();
        for(Restoran r : restorani)
        {
            if(r.getLokacija() == lokacija)
            {
                pom.add(r);
            }
        }
        return pom;
    }
    public Restoran  findByMenadzerID(Long menadzer_id) {
        List<Restoran> restorani = findAll();
        Restoran pom = new Restoran();
        for(Restoran r : restorani)
        {
            if(r.getMenadzer().getId() == menadzer_id)
            {
                pom.setID(r.getID());
                pom.setOtvoren(r.isOtvoren());
                pom.setMenadzer(r.getMenadzer());
                pom.setLokacija(r.getLokacija());
                pom.setArtikli(r.getArtikli());
                pom.setTipRestorana(r.getTipRestorana());
                pom.setNaziv(r.getNaziv());
            }
        }
        return pom;
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
        return restoranRepository.save(restoran1);
    }
}
