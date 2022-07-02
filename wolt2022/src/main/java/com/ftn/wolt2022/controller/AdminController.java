package com.ftn.wolt2022.controller;

import com.ftn.wolt2022.DTO.AdminDTO;
import com.ftn.wolt2022.entity.*;
import com.ftn.wolt2022.service.*;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final KorisnikService korisnikService;
    private final MenadzerService menadzerService;
    private final RestoranService restoranService;
    private final DostavljacService dostavljacService;

    //nadji admina preko korisnickog imena i lozinke
    @GetMapping(value = "/{korsnickoime}/{lozinka}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Admin> findByKorisnickoImeILozinka(@PathVariable String korisnickoIme, String lozinka) {
        Admin admin = adminService.findByKorisnickoImeILozinka(korisnickoIme, lozinka);
        AdminDTO adminDTO = new AdminDTO(admin.getID(), admin.getKorisnickoIme(), admin.getLozinka(), admin.getIme(), admin.getPrezime(), admin.getDatumRodjenja(), admin.getUloga(), admin.getPol());
        return new ResponseEntity<Admin>((MultiValueMap<String, String>) adminDTO, HttpStatus.OK);

    }

    //prikaz svih korisnika
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Korisnik>> findAll() {
        List<Korisnik> korisnici = korisnikService.findAll();

        return new ResponseEntity<>(korisnici, HttpStatus.OK);
    }

    //kreiranje menadzera
    @PostMapping(path = "/menadzer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Menadzer> napraviMenadzera(@RequestBody Menadzer menadzer) throws Exception {
        Menadzer newMenadzer = menadzerService.create(menadzer);

        return new ResponseEntity<>(newMenadzer, HttpStatus.CREATED);
    }

    //kreiranje dostavljaca
    @PostMapping(path = "dostavljac", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dostavljac> napraviDostavljaca(@RequestBody Dostavljac dostavljac) throws Exception {
        List<Dostavljac> dostavljaci = dostavljacService.findAll();


        Dostavljac newDostavljac = dostavljacService.create(new Dostavljac(dostavljac.getID(), dostavljac.getKorisnickoIme(),
                dostavljac.getLozinka(), dostavljac.getIme(), dostavljac.getPrezime(),
                dostavljac.getPol(), dostavljac.getDatumRodjenja(), dostavljac.getUloga(),
                dostavljac.getPorudzbine()));
        dostavljaci.add(newDostavljac);

        return new ResponseEntity<>(newDostavljac, HttpStatus.CREATED);

    }

    //kreiraj restoran
    @PostMapping(path = "restoran",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restoran> napraviRestoran(@RequestBody Restoran restoran) throws Exception {
        Restoran res = new Restoran();

        Restoran newRestoran = restoranService.create(res);
        //komentar
        return new ResponseEntity<>(newRestoran, HttpStatus.CREATED);
    }

    //prikaz svih restorana
    @GetMapping(path = "restorani",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Restoran>> sviRestorani() {
        List<Restoran> restorani = restoranService.findAll();
        return new ResponseEntity<>(restorani, HttpStatus.OK);
    }

    //brisanje restorana
    @GetMapping("/remove/{trainingId}/{id}")//ukloni trening
    public String removeRestoran(@PathVariable("restoranID") Long restoranID, @PathVariable("id") Long id) {
        Restoran restoran = this.restoranService.getRestoranById(id);
        List<Restoran> temp = restoranService.findAll();
        temp.remove(restoran);
        return "redirect:/admin/" + id + "/restorani";
    }
}
