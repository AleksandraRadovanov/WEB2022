package com.ftn.wolt2022.service;

import com.ftn.wolt2022.entity.Dostavljac;
import com.ftn.wolt2022.entity.Korisnik;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DostavljacService {

    public static List<Dostavljac> findAll() {
        List<Dostavljac> dostavljaci = new ArrayList<Dostavljac>();

        return dostavljaci;
    }
    public void save(Dostavljac dostavljac) {

    }
    public Dostavljac findOne(Long id) {
        Dostavljac dostavljac = new Dostavljac();
        return dostavljac;
    }
    public Dostavljac create(Dostavljac dos) {

        return null;
    }
}
