package com.ftn.wolt2022.controller;

import com.ftn.wolt2022.DTO.AdminDTO;
import com.ftn.wolt2022.entity.*;
import com.ftn.wolt2022.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;
    private final KorisnikService korisnikService;
    private final MenadzerService menadzerService;

    private final RestoranService restoranService;
    private final DostavljacService dostavljacService;

    @Autowired
    public AdminController(AdminService adminService, KorisnikService korisnikService, MenadzerService menadzerService, RestoranService restoranService, DostavljacService dostavljacService) {
        this.adminService = adminService;
        this.korisnikService = korisnikService;
        this.menadzerService = menadzerService;
        this.restoranService = restoranService;
        this.dostavljacService = dostavljacService;
    }

    //nadji admina preko korisnickog imena i lozinke
    @GetMapping(value = "/{korsnickoime}/{lozinka}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Admin> findByKorisnickoImeILozinka(@PathVariable String korisnickoIme, String lozinka)
    {
        Admin admin = adminService.findByKorisnickoImeILozinka(korisnickoIme, lozinka);
        AdminDTO adminDTO = new AdminDTO(admin.getID(), admin.getKorisnickoIme(), admin.getLozinka(), admin.getIme(), admin.getPrezime(), admin.getDatumRodjenja(), admin.getUloga(), admin.getPol());
        return new ResponseEntity<Admin>((MultiValueMap<String, String>) adminDTO, HttpStatus.OK);

    }

    //prikaz svih korisnika
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Korisnik>> findAll()
    {
        List<Korisnik> korisnici = korisnikService.findAll();
        List<Korisnik> pom = new ArrayList<>();
        for(Korisnik k:korisnici)
        {
            Korisnik korisnik = new Korisnik(k.getID(), k.getKorisnickoIme(), k.getLozinka(), k.getIme(), k.getPrezime(), k.getPol(), k.getDatumRodjenja(), k.getUloga());
            pom.add(korisnik);
        }
        return new ResponseEntity<>(pom, HttpStatus.OK);
    }

    //kreiranje menadzera
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Menadzer> napraviMenadzera(@RequestBody Menadzer menadzer) throws Exception
    {
        Menadzer men = new Menadzer(menadzer.getID(), menadzer.getKorisnickoIme(), menadzer.getLozinka(), menadzer.getIme(), menadzer.getPrezime(), menadzer.getPol(), menadzer.getDatumRodjenja(), menadzer.getUloga(), menadzer.getRestoranID());
        Menadzer newMenadzer = menadzerService.create(men);

        return new ResponseEntity<>(newMenadzer, HttpStatus.CREATED);
    }

    //kreiranje dostavljaca
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dostavljac> napraviDostavljaca(@RequestBody Dostavljac dostavljac) throws Exception
    {
        Dostavljac dos = new Dostavljac(dostavljac.getID(), dostavljac.getKorisnickoIme(), dostavljac.getLozinka(), dostavljac.getIme(), dostavljac.getPrezime(),
                dostavljac.getPol(), dostavljac.getDatumRodjenja(), dostavljac.getUloga(), dostavljac.getPorudzbine());
        Dostavljac newDostavljac = dostavljacService.create(dos);

        return new ResponseEntity<>(newDostavljac, HttpStatus.CREATED);
    }

    //kreiraj restoran
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restoran> napraviRestoran(@RequestBody Restoran restoran) throws Exception
    {
        Restoran res = new Restoran(restoran.getID(), restoran.getNaziv(), restoran.getTipRestorana());

        Restoran newRestoran = restoranService.create(res);

        return new ResponseEntity<>(newRestoran, HttpStatus.CREATED);
    }

    //prikaz svih restorana
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Restoran>> sviRestorani()
    {
        List<Restoran> restorani = restoranService.findAll();
        List<Restoran> pom = new ArrayList<>();
        for(Restoran r:restorani)
        {
            Restoran rest = new Restoran(r.getID(), r.getNaziv(), r.getTipRestorana());
            pom.add(rest);
        }
        return new ResponseEntity<>(pom, HttpStatus.OK);
    }
}
