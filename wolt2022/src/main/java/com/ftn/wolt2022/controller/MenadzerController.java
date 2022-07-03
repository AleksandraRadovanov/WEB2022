package com.ftn.wolt2022.controller;

import com.ftn.wolt2022.DTO.ArtikalDTO;
import com.ftn.wolt2022.DTO.PorudzbinaDTO;
import com.ftn.wolt2022.DTO.RestoranDTO;
import com.ftn.wolt2022.entity.*;
import com.ftn.wolt2022.repository.ArtikalRepository;
import com.ftn.wolt2022.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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
    private final PorudzbinaService porudzbinaService;

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

    //pregled restorana
    @GetMapping(path = "/prikazi/restorani", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restoran> sviRestorani(Menadzer menadzer) {
        Restoran restoran =  restoranService.findByMenadzerID(menadzer.getId());

        return new ResponseEntity<>(restoran, HttpStatus.OK);
    }

    //pregled svih porudzbina
    @GetMapping(path = "/prikazi/porudzbine", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PorudzbinaDTO>> svePorudzbine(Menadzer menadzer) {
        List<Porudzbina> porudzbine = porudzbinaService.findAll();
        List<PorudzbinaDTO> porudzbineDTO = new ArrayList<>();
        Restoran restoran = restoranService.findByMenadzerID(menadzer.getId());
        List<Restoran> restorani = restoranService.findAll();
        int i = 0;

        for(Porudzbina p:porudzbine)
        {
                if(p.getRestorani().get(i).getId() == restoran.getId())
                {
                    PorudzbinaDTO porudzbinaDTO = new PorudzbinaDTO(p.getId(), p.getPoruceniArtikli(),
                            p.getRestorani(), p.getDatumIVreme(), p.getCena(), p.getStatus(),
                            p.getDostavljac(), p.getKupac());
                    porudzbineDTO.add(porudzbinaDTO);
                }
                i++;
        }
        return new ResponseEntity<>(porudzbineDTO, HttpStatus.OK);
    }
}
