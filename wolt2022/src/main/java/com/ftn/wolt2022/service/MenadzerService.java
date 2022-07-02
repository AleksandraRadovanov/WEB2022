package com.ftn.wolt2022.service;

import com.ftn.wolt2022.entity.Menadzer;
import com.ftn.wolt2022.repository.MenadzerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenadzerService {
    public final MenadzerRepository menadzerRepository;

    public Menadzer findById(Long menadzerId) {
        return menadzerRepository.findById(menadzerId);
    }
    public void save(Menadzer menadzer) {

    }
    public static Menadzer findOne(Long menadzerId) {

        //Menadzer menadzer = menadzerRepository.findOne();
        return null;
    }
    public Menadzer create(Menadzer men) {
        Menadzer menadzer1 = new Menadzer();
        menadzer1.setIme(men.getIme());
        menadzer1.setLozinka(men.getLozinka());
        menadzer1.setPrezime(men.getPrezime());
        menadzer1.setKorisnickoIme(men.getKorisnickoIme());
        menadzer1.setPol(men.getPol());
        menadzer1.setDatumRodjenja(men.getDatumRodjenja());
        menadzerRepository.save(menadzer1);
        return menadzer1;
    }
}

