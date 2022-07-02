package com.ftn.wolt2022.service;

import com.ftn.wolt2022.entity.Menadzer;
import com.ftn.wolt2022.repository.MenadzerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenadzerService {
    public final MenadzerRepository menadzerRepository;
    public Menadzer getMenadzerByID(Long menadzer_id) {
        Menadzer menadzer = new Menadzer();

        return menadzer;
    }
    public void save(Menadzer menadzer) {

    }
    public Menadzer findOne() {

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

        return menadzerRepository.save(menadzer1);
    }
}

