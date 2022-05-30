package com.ftn.wolt2022.service;

import com.ftn.wolt2022.entity.Menadzer;
import org.springframework.stereotype.Service;

@Service
public class MenadzerService {

    public MenadzerService menadzerRepository;
    public Menadzer getMenadzerByID(Long menadzer_id) {
        Menadzer menadzer = new Menadzer();
        return menadzer;
    }

    public void save(Menadzer menadzer) {
    }


    public Menadzer findOne() {

        Menadzer menadzer = menadzerRepository.findOne();
        return menadzer;
    }

    public Menadzer create(Menadzer men) {
        return null;

    }
}
