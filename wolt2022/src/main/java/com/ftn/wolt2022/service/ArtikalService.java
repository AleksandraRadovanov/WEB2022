package com.ftn.wolt2022.service;

import com.ftn.wolt2022.entity.Artikal;
import com.ftn.wolt2022.entity.Menadzer;
import com.ftn.wolt2022.repository.ArtikalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArtikalService {
    private final ArtikalRepository artikalRepository;
    public Artikal findById(Long id) {
        Optional<Artikal>artikal = artikalRepository.findById(id);
        return artikal.orElse(null);
    }
    public Artikal updateArtikala(Artikal artikal, Menadzer menadzer) {
        return null;
    }
}
