package com.ftn.wolt2022.controller;

import com.ftn.wolt2022.DTO.AdminDTO;
import com.ftn.wolt2022.DTO.KorisnikDTO;
import com.ftn.wolt2022.DTO.RestoranDTO;
import com.ftn.wolt2022.entity.*;
import com.ftn.wolt2022.service.*;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
    @GetMapping(value = "/korisnickoime/lozinka", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdminDTO> findByKorisnickoImeILozinka(@PathVariable String korisnickoIme, String lozinka) {
        Admin admin = adminService.findByKorisnickoImeILozinka(korisnickoIme, lozinka);
        AdminDTO adminDTO = new AdminDTO(admin.getId(), admin.getKorisnickoIme(), admin.getLozinka(), admin.getIme(), admin.getPrezime(), admin.getDatumRodjenja(), admin.getUloga(), admin.getPol());
        return new ResponseEntity<>(adminDTO, HttpStatus.OK);

    }

    //prikaz svih korisnika
    @GetMapping(path = "/prikazi/korisnike", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KorisnikDTO>> findAll() {
        List<Korisnik> korisnici = korisnikService.findAll();
        List<KorisnikDTO> korisniciDTO = new ArrayList<>();

        for(Korisnik k:korisnici)
        {
            KorisnikDTO korisnikDTO = new KorisnikDTO(k.getId(),
                   k.getKorisnickoIme(), k.getLozinka(),
                    k.getIme(), k.getPrezime(), k.getPol(),
                    k.getDatumRodjenja(),
                    k.getUloga());
            korisniciDTO.add(korisnikDTO);

        }
        return new ResponseEntity<>(korisniciDTO, HttpStatus.OK);
    }

    //kreiranje menadzera*uradjeno*
    @PostMapping(path = "/napravi/menadzer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Menadzer> napraviMenadzera(@RequestBody Menadzer menadzer) throws Exception {
        Menadzer newMenadzer = menadzerService.create(menadzer);

        return new ResponseEntity<>(newMenadzer, HttpStatus.CREATED);
    }

    @GetMapping(path = "/prikazi/menadzeri", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Menadzer>> sviMenadzeri() {
        List<Menadzer> menadzerList = menadzerService.findAll();

        return new ResponseEntity<>(menadzerList, HttpStatus.OK);
    }

    //kreiranje dostavljaca*uradjeno*
    @PostMapping(path = "/napravi/dostavljac", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dostavljac> napraviDostavljaca(@RequestBody Dostavljac dostavljac) throws Exception {
        Dostavljac newDostavljac = dostavljacService.create(dostavljac);

        return new ResponseEntity<>(newDostavljac, HttpStatus.CREATED);

    }

    //kreiraj restoran*uradjeno*
    @PostMapping(path = "/napravi/restoran", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restoran> napraviRestoran(@RequestBody Restoran restoran) throws Exception {
        Restoran newRestoran = restoranService.create(restoran);

        return new ResponseEntity<>(newRestoran, HttpStatus.CREATED);
    }

    //prikaz svih restorana
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

    //brisanje restorana*uradjeno*
    @PostMapping("/obrisi/restoran")
    public String removeRestoran(@PathVariable("restoranID") Long restoranID, @PathVariable("id") Long id) {
        Restoran restoran = restoranService.getRestoranById(id);

        List<Restoran> restorani = restoranService.findAll();
        restoranService.removeRestoran(restoran, restorani);
        return "/restorani";
    }

    //pretrazivanje korisnika po imenu
    @PostMapping("/pretrazi_korisnike/ime")
    public String pretraziPoImenu(@ModelAttribute Korisnik formData, Model model)
    {
        Korisnik korisnik = korisnikService.findByIme(formData.getIme());
        model.addAttribute("korisnik", korisnik);
        return "index";
    }

    //pretrazivanje korisnika po prezimenu
    @PostMapping("/pretrazi_korisnike/prezime")
    public String pretraziPoPrezimenu(@ModelAttribute Korisnik formData, Model model)
    {
        Korisnik korisnik = korisnikService.findByPrezime(formData.getPrezime());
        model.addAttribute("korisnik", korisnik);
        return "index";
    }

    //pretrazivanje korisnika po korisnickom imenu
    @PostMapping("/pretrazi_korisnike/korisnickoIme")
    public String pretraziPoKorisnickomImenu(@ModelAttribute Korisnik formData, Model model)
    {
        Korisnik korisnik = korisnikService.findByKorisnickoIme(formData.getKorisnickoIme());
        model.addAttribute("korisnik", korisnik);
        return "index";
    }
}
