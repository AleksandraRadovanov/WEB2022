package com.ftn.wolt2022.service;

import com.ftn.wolt2022.entity.Korisnik;
import com.ftn.wolt2022.repository.KorisnikRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KorisnikService {
    private final KorisnikRepository korisnikRepository;
    public List<Korisnik> findAll() {
        return korisnikRepository.findAll();
    }
    public Korisnik findOne(Long korisnik_id) {
        Optional<Korisnik> korisnik = korisnikRepository.findById(korisnik_id);
        return korisnik.orElse(null);
    }

    public Korisnik findByIme(String ime) {
        Korisnik korisnik = korisnikRepository.findByIme(ime);
        return korisnik;
    }
    public Korisnik findByPrezime(String prezime) {
        Korisnik korisnik = korisnikRepository.findByPrezime(prezime);
        return korisnik;
    }
    public Korisnik findByKorisnickoIme(String korisnickoIme) {
       Korisnik korisnik = korisnikRepository.findByKorisnickoIme(korisnickoIme);
        return korisnik;
    }
}
