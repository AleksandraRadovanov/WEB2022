package com.ftn.wolt2022.controller;

import com.ftn.wolt2022.DTO.ArtikalDTO;
import com.ftn.wolt2022.entity.Artikal;
import com.ftn.wolt2022.entity.Menadzer;
import com.ftn.wolt2022.repository.ArtikalRepository;
import com.ftn.wolt2022.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/menadzer")
@RequiredArgsConstructor
public class MenadzerController
{
    private final AdminService adminService;

    private final KorisnikService korisnikService;

    private final MenadzerService menadzerService;

    private final RestoranService restoranService;

    private final DostavljacService dostavljacService;
    private final ArtikalService artikalService;

    //dodavanje artikla
    @PutMapping(value = "/dodakArtikal/{id}/{menadzerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArtikalDTO> dodajArtikal (@PathVariable Long id, @PathVariable Long menadzerId) throws Exception
    {
        Menadzer menadzer = MenadzerService.findOne(menadzerId);
        Artikal artikal = artikalService.findById(id);
        Artikal updateArtikal = artikalService.updateArtikala(artikal, menadzer);

        ArtikalDTO artikalDTO = new ArtikalDTO(artikal.getID(),
                artikal.getNaziv(), artikal.getCena(), artikal.getTip(),
                artikal.getKolicina(), artikal.getOpis());

        return new ResponseEntity<>(artikalDTO, HttpStatus.OK);
    }


}
