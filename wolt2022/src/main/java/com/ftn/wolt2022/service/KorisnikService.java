package com.ftn.wolt2022.service;

import com.ftn.wolt2022.entity.Korisnik;
import com.ftn.wolt2022.entity.Lokacija;
import com.ftn.wolt2022.entity.Restoran;
import com.ftn.wolt2022.entity.TipRestorana;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class KorisnikService {

    private KorisnikService korisnikService;

    public static List<Korisnik> findAll() {
        List<Korisnik> korisnici = new ArrayList<Korisnik>();

        return korisnici;
    }
    public Korisnik findOne(Long korisnik_id) {
        Korisnik korisnik = new Korisnik();

        return korisnik;
    }

    public List<Korisnik> findByIme(String ime) {
        List<Korisnik> korisnici = korisnikService.findAll();
        List<Korisnik> pom = new ArrayList<Korisnik>();
        for(Korisnik k : korisnici)
        {
            if(k.getIme().equals(ime))
            {
                pom.add(k);
            }
        }
        return pom;
    }
    public List<Korisnik> findByPrezime(String prezime) {
        List<Korisnik> korisnici = korisnikService.findAll();
        List<Korisnik> pom = new ArrayList<Korisnik>();
        for(Korisnik k : korisnici)
        {
            if(k.getPrezime().equals(prezime))
            {
                pom.add(k);
            }
        }
        return pom;
    }
    public List<Korisnik> findByKorisnickoIme(String korisnickoIme) {
        List<Korisnik> korisnici = korisnikService.findAll();
        List<Korisnik> pom = new ArrayList<Korisnik>();
        for(Korisnik k : korisnici)
        {
            if(k.getKorisnickoIme().equals(korisnickoIme))
            {
                pom.add(k);
            }
        }
        return pom;
    }

}
