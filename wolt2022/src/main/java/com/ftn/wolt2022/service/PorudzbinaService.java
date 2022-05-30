package com.ftn.wolt2022.service;

import com.ftn.wolt2022.entity.Porudzbina;
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
        List<Porudzbina> porudzbine = porudzbinaRepository.findAll();

        return porudzbine;
    }

   public List<Porudzbina> findByKupacID(Long kupacID)
   {
       List<Porudzbina> porudzbine = porudzbinaRepository.findAll();

       List<Porudzbina> pom = new ArrayList<Porudzbina>();

       for(Porudzbina p : porudzbine)
       {
           if(p.getKupacID() == kupacID)
               pom.add(p);
       }
       return pom;
   }

    public List<Porudzbina> findByDostavljac(Long dostavljacID)
    {
        List<Porudzbina> porudzbine = porudzbinaRepository.findAll();

        List<Porudzbina> pom = new ArrayList<Porudzbina>();

        for(Porudzbina p : porudzbine)
        {
            if(p.getKupacID() == dostavljacID)
                pom.add(p);
        }
        return pom;
    }

    public List<Porudzbina> findByMenadzer(Long menadzer_id, Long restoran_id) {
        List<Porudzbina> porudzbine = porudzbinaRepository.findAll();

        List<Porudzbina> pom = new ArrayList<Porudzbina>();

        for(Porudzbina p : porudzbine)
        {
            if(p.getRestoran().getID() == restoran_id)
                if (p.getRestoran().getMenadzer().getID() == restoran_id)
                    pom.add(p);

        }
        return pom;
    }


}
