package com.ftn.wolt2022.service;

import com.ftn.wolt2022.entity.Admin;
import com.ftn.wolt2022.entity.Dostavljac;
import com.ftn.wolt2022.repository.AdminRepository;
import com.ftn.wolt2022.repository.DostavljacRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DostavljacLogInService {
    private final DostavljacRepository dostavljacRepository;


    public DostavljacLogInService(DostavljacRepository dostavljacRepository) {
        this.dostavljacRepository = dostavljacRepository;
    }

    public List<Dostavljac> findAll() {
        return dostavljacRepository.findAll();
    }
}
