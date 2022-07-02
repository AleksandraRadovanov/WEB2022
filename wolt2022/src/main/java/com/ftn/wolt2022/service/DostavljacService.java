package com.ftn.wolt2022.service;

import com.ftn.wolt2022.entity.Dostavljac;
import com.ftn.wolt2022.entity.Korisnik;
import com.ftn.wolt2022.entity.Menadzer;
import com.ftn.wolt2022.entity.Porudzbina;
import com.ftn.wolt2022.repository.DostavljacRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DostavljacService {
    public final DostavljacRepository dostavljacRepository;

    public List<Dostavljac> findAll() {
       return dostavljacRepository.findAll();
    }
    public void save(Dostavljac dostavljac) {

    }
    public Dostavljac findOne(Long id) {
       return dostavljacRepository.findOne(id);
    }
    public Dostavljac create(Dostavljac dos) {
        Dostavljac dostavljac1 = new Dostavljac();
        dostavljac1.setIme(dos.getIme());
        dostavljac1.setLozinka(dos.getLozinka());
        dostavljac1.setPrezime(dos.getPrezime());
        dostavljac1.setKorisnickoIme(dos.getKorisnickoIme());
        dostavljac1.setPol(dos.getPol());
        dostavljac1.setDatumRodjenja(dos.getDatumRodjenja());

        dostavljacRepository.save(dostavljac1);
        return dostavljac1;

    }
}





