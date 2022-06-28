package com.ftn.wolt2022.controller;

import com.ftn.wolt2022.DTO.DostavljacLogInDTO;
import com.ftn.wolt2022.entity.Dostavljac;
import com.ftn.wolt2022.entity.Korisnik;
import com.ftn.wolt2022.service.DostavljacLogInService;
import com.ftn.wolt2022.service.KorisnikService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/dostavljaclogin")
public class DostavljacLogInController {
    private final DostavljacLogInService dostavljacLogInService;

    public DostavljacLogInController(DostavljacLogInService dostavljacLogInService, KorisnikService korisnikService) {
        this.dostavljacLogInService = dostavljacLogInService;
    }

    //logovanje dostavljaca
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dostavljac> login(@RequestBody DostavljacLogInDTO dostavljacLogInDTO)
    {
        DostavljacLogInDTO dostavljacLogInDTO1 = new DostavljacLogInDTO(dostavljacLogInDTO.getId(), dostavljacLogInDTO.getKorisnickoime(), dostavljacLogInDTO.getLozinka());
        List<Dostavljac> dostavljaci = dostavljacLogInService.findAll();
        for(Dostavljac d:dostavljaci)
        {
            if(d.getKorisnickoIme().equals(dostavljacLogInDTO1.getKorisnickoime()))
            {
                if(d.getLozinka().equals(dostavljacLogInDTO1.getLozinka()))
                {
                    dostavljacLogInDTO1.setId(d.getID());
                    return new ResponseEntity<Dostavljac>((MultiValueMap<String, String>) dostavljacLogInDTO1, HttpStatus.OK);
                }
                else
                {
                    return new ResponseEntity<Dostavljac>((MultiValueMap<String, String>) dostavljacLogInDTO1, HttpStatus.BAD_REQUEST);
                }
            }
        }
        return new ResponseEntity<Dostavljac>((MultiValueMap<String, String>) dostavljacLogInDTO1, HttpStatus.NOT_FOUND);
    }


}
