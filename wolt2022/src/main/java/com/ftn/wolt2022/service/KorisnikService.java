package com.ftn.wolt2022.service;

import com.ftn.wolt2022.entity.Korisnik;
import com.ftn.wolt2022.repository.KorisnikRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class KorisnikService {

    private final KorisnikRepository korisnikRepository;

    public KorisnikService(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    public List<Korisnik> findAll() {
        return korisnikRepository.findAll();
    }
    public Korisnik findOne(Long korisnik_id) {
        return korisnikRepository.findOne(korisnik_id);
    }

    public List<Korisnik> findByIme(String ime) {
        return korisnikRepository.findByIme(ime);
    }
    public List<Korisnik> findByPrezime(String prezime) {
        return korisnikRepository.findByPrezime(prezime);
    }
    public List<Korisnik> findByKorisnickoIme(String korisnickoIme) {
        return korisnikRepository.findByKorisnickoIme(korisnickoIme);
    }

}
