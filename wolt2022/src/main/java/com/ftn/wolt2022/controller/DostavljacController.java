package com.ftn.wolt2022.controller;

import com.ftn.wolt2022.DTO.PorudzbinaDTO;
import com.ftn.wolt2022.entity.Dostavljac;
import com.ftn.wolt2022.entity.Kupac;
import com.ftn.wolt2022.entity.Porudzbina;
import com.ftn.wolt2022.entity.StatusPorudzbine;
import com.ftn.wolt2022.service.PorudzbinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/dostavljac")
@RequiredArgsConstructor
public class DostavljacController {

    private final PorudzbinaService porudzbinaService;

    //pregled svih porudzbina koje su u statusu ceka dostavljaca
    @GetMapping(path = "/prikazi/porudzbine/ceka", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PorudzbinaDTO>> svePorudzbineKojeCekaju(Dostavljac dostavljac) {
        List<Porudzbina> porudzbine = porudzbinaService.findAll();
        List<PorudzbinaDTO> porudzbineDTO = new ArrayList<>();

        for(Porudzbina p:porudzbine)
        {
            if(p.getDostavljac().getId().equals(dostavljac.getId()) && p.getStatus().equals(StatusPorudzbine.CEKA_DOSTAVLJACA))
            {
                PorudzbinaDTO porudzbinaDTO = new PorudzbinaDTO(p.getId(), p.getPoruceniArtikli(),
                        p.getRestorani(), p.getDatumIVreme(), p.getCena(), p.getStatus(),
                        p.getDostavljac(), p.getKupac());
                porudzbineDTO.add(porudzbinaDTO);
            }
        }
        return new ResponseEntity<>(porudzbineDTO, HttpStatus.OK);
    }

    //pregled svih njegovih porudzbina
    @GetMapping(path = "/prikazi/porudzbine", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PorudzbinaDTO>> svePorudzbine(Dostavljac dostavljac) {
        List<Porudzbina> porudzbine = porudzbinaService.findAll();
        List<PorudzbinaDTO> porudzbineDTO = new ArrayList<>();

        for(Porudzbina p:porudzbine)
        {
            if(p.getDostavljac().getId().equals(dostavljac.getId()))
            {
                PorudzbinaDTO porudzbinaDTO = new PorudzbinaDTO(p.getId(), p.getPoruceniArtikli(),
                        p.getRestorani(), p.getDatumIVreme(), p.getCena(), p.getStatus(),
                        p.getDostavljac(), p.getKupac());
                porudzbineDTO.add(porudzbinaDTO);
            }
        }
        return new ResponseEntity<>(porudzbineDTO, HttpStatus.OK);
    }
}
