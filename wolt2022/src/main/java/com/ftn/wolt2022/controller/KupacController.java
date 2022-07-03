package com.ftn.wolt2022.controller;

import com.ftn.wolt2022.DTO.PorudzbinaDTO;
import com.ftn.wolt2022.DTO.RestoranDTO;
import com.ftn.wolt2022.entity.*;
import com.ftn.wolt2022.service.KomentarService;
import com.ftn.wolt2022.service.KupacService;
import com.ftn.wolt2022.service.PorudzbinaService;
import com.ftn.wolt2022.service.RestoranService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/kupac")
@RequiredArgsConstructor
public class KupacController {

    private final KupacService kupacService;
    private final RestoranService restoranService;
    private PorudzbinaService porudzbinaService;
    private final KomentarService komentarService;

    //pregled svih restorana
    @GetMapping(path = "/prikazi/restorani", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RestoranDTO>> sviRestorani() {
        List<Restoran> restorani = restoranService.findAll();
        List<RestoranDTO> restoraniDTO = new ArrayList<>();

        for(Restoran r:restorani)
        {
            RestoranDTO restoranDTO = new RestoranDTO(r.getId(),
                    r.getNaziv(), r.getTipRestorana(), r.getArtikli(), r.getKomentari(),
                    r.getLokacija(), r.isOtvoren(), r.getMenadzer());
            restoraniDTO.add(restoranDTO);

        }
        return new ResponseEntity<>(restoraniDTO, HttpStatus.OK);
    }
    //pregled svih porudzbina
    @GetMapping(path = "/prikazi/porudzbine", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PorudzbinaDTO>> svePorudzbine(Kupac kupac) {
        List<Porudzbina> porudzbine = porudzbinaService.findAll();
        List<PorudzbinaDTO> porudzbineDTO = new ArrayList<>();

        for(Porudzbina p:porudzbine)
        {
            if(p.getKupac().getId().equals(kupac.getId()))
            {
                PorudzbinaDTO porudzbinaDTO = new PorudzbinaDTO(p.getId(), p.getPoruceniArtikli(),
                        p.getRestorani(), p.getDatumIVreme(), p.getCena(), p.getStatus(),
                        p.getDostavljac(), p.getKupac());
                porudzbineDTO.add(porudzbinaDTO);
            }
        }
        return new ResponseEntity<>(porudzbineDTO, HttpStatus.OK);
    }

    //kreirati porudzbinu
    @PostMapping(path = "/napravi/porudzbina", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Porudzbina> napraviPorudzbinu(@RequestBody Porudzbina porudzbina, Kupac kupac) throws Exception {
        Porudzbina newPorudzbina = porudzbinaService.create(porudzbina);
        int dodajBrBodova = (int) ((newPorudzbina.getCena()/1000) * 133);
        kupac.setSakulpljeniBodovi(kupac.getSakulpljeniBodovi() + dodajBrBodova);
        return new ResponseEntity<>(newPorudzbina, HttpStatus.CREATED);
    }

    //ostavlja komentar i ocenu
    @PostMapping(path = "/napravi/komentar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Komentar> napraviKomentar(@RequestBody Komentar komentar) throws Exception {
        Komentar newKomentar = komentarService.create(komentar);

        return new ResponseEntity<>(newKomentar, HttpStatus.CREATED);
    }

}
