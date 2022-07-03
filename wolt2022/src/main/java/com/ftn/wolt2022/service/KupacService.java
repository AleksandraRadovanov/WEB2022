package com.ftn.wolt2022.service;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.ftn.wolt2022.entity.Kupac;
import com.ftn.wolt2022.repository.KupacRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KupacService {
    private final KupacRepository kupacRepository;
    public Kupac findOne(Long id) {
        Optional<Kupac>kupac = kupacRepository.findById(id);
        return kupac.orElse(null);
    }
}
