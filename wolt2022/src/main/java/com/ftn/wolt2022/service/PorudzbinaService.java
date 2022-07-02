package com.ftn.wolt2022.service;

import com.ftn.wolt2022.entity.Dostavljac;
import com.ftn.wolt2022.entity.Kupac;
import com.ftn.wolt2022.entity.Porudzbina;
import com.ftn.wolt2022.repository.PoruzbinaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PorudzbinaService {
    public PorudzbinaService porudzbinaRepository;
    public List<Porudzbina> findAlByRestoranID() {
        List<Porudzbina> porudzbine = new ArrayList<Porudzbina>();
        return porudzbine;
    }

    public List<Porudzbina> findAll() {
        return porudzbinaRepository.findAll();
    }

   public Kupac findByKupacID(Long kupacID)
   {
        return porudzbinaRepository.findByKupacID(kupacID);
   }

    public List<Porudzbina> findByDostavljac(Long dostavljacID)
    {
        return porudzbinaRepository.findByDostavljac(dostavljacID);
    }

    public List<Porudzbina> findByMenadzer(Long menadzer_id, Long restoran_id) {
        return porudzbinaRepository.findByMenadzer(menadzer_id, restoran_id);
    }
}
