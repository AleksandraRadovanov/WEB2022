package com.ftn.wolt2022.service;

import com.ftn.wolt2022.entity.Kupac;
import com.ftn.wolt2022.repository.KupacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KupacLogInService {
    private final KupacRepository kupacRepository;
    @Autowired
    public KupacLogInService(KupacRepository kupacRepository) {
        this.kupacRepository = kupacRepository;
    }

    public List<Kupac> findAll()
    {
        return kupacRepository.findAll();
    }

}
