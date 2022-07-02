package com.ftn.wolt2022.service;

import com.ftn.wolt2022.entity.Kupac;
import com.ftn.wolt2022.repository.KupacRepository;
import org.springframework.stereotype.Service;

@Service
public class KupacService {
    public final KupacRepository kupacRepository;

    public KupacService(KupacRepository kupacRepository) {
        this.kupacRepository = kupacRepository;
    }
    public void save(Kupac kupac) {

    }
    public Kupac findOne(Long id) {
        return kupacRepository.findOne(id);
    }


}
