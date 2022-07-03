package com.ftn.wolt2022.service;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.ftn.wolt2022.entity.Korisnik;
import com.ftn.wolt2022.entity.Kupac;
import com.ftn.wolt2022.repository.KupacRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.spec.OAEPParameterSpec;
import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KupacService {
    private final KupacRepository kupacRepository;
    public Kupac findOne(Long id) {
        Optional<Kupac>kupac = kupacRepository.findById(id);
        return kupac.orElse(null);
    }

    /*public Kupac registracija(String korisnickoIme, String lozinka, String ime,
                              String prezime, String pol, LocalDate datumRodjenja)
    {
        if(korisnickoIme != null && lozinka != null)
        {
            Kupac kupac = new Kupac();
            kupac.setKorisnickoIme(korisnickoIme);
            kupac.setLozinka(lozinka);
            kupac.setIme(ime);
            kupac.setPrezime(prezime);
            kupac.setPol(pol);
            kupac.setDatumRodjenja(datumRodjenja);
            kupac.setUloga(Korisnik.Uloga.KUPAC);

            return kupacRepository.save(kupac);
        }
        else
        {
            return null;
        }
    }

    public Kupac autentikacija(String korisnickoIme, String lozinka)
    {
        return kupacRepository.findByKorisnickoILozinka(korisnickoIme, lozinka);
    }*/
}
