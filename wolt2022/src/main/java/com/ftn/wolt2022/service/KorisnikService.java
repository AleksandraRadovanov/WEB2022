package com.ftn.wolt2022.service;

import com.ftn.wolt2022.entity.Korisnik;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class KorisnikService {

    public static List<Korisnik> findAll() {
        List<Korisnik> korisnici = new ArrayList<Korisnik>();
        return korisnici;
    }

    public Korisnik findOne(Long korisnik_id) {
        Korisnik korisnik = new Korisnik();
        return korisnik;
    }
}