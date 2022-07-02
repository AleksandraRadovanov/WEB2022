package com.ftn.wolt2022.service;

import com.ftn.wolt2022.DTO.ArtikalDTO;
import com.ftn.wolt2022.entity.Artikal;
import com.ftn.wolt2022.entity.Menadzer;
import com.ftn.wolt2022.repository.ArtikalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ArtikalService {
    public final ArtikalRepository artikalRepository;

    public ArtikalService(ArtikalRepository artikalRepository) {
        this.artikalRepository = artikalRepository;
    }

    public Artikal findById(Long id) {
        return artikalRepository.findById(id);
    }

    public static Artikal updateArtikala(Artikal artikal, Menadzer menadzer) {
        return null;
    }
}
