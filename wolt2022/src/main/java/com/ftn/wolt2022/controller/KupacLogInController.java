package com.ftn.wolt2022.controller;

import com.ftn.wolt2022.DTO.KupacLogInDTO;
import com.ftn.wolt2022.entity.Kupac;
import com.ftn.wolt2022.service.KupacLogInService;
import com.ftn.wolt2022.service.KupacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/kupaclogin")
public class KupacLogInController {

    private final KupacLogInService kupacLogInService;
    private KupacService kupacService;

    @Autowired
    public KupacLogInController(KupacLogInService kupacLogInService) {
        this.kupacLogInService = kupacLogInService;
    }

    //logovanje kupca
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KupacLogInDTO> login(@RequestBody KupacLogInDTO kupacLogInDTO){
        KupacLogInDTO kupacLogInDTO1 = new KupacLogInDTO(kupacLogInDTO.getID(), kupacLogInDTO.getKorisnickoIme(), kupacLogInDTO.getLozinka());
        List<Kupac> kupci = kupacLogInService.findAll();
        for(Kupac k:kupci){
            if(k.getKorisnickoIme().equals(kupacLogInDTO1.getKorisnickoIme())){
                if(k.getLozinka().equals(kupacLogInDTO1.getLozinka())){
                    kupacLogInDTO1.setID(k.getId());
                    return new ResponseEntity<>(kupacLogInDTO1, HttpStatus.OK);
                }
                else {
                    return new ResponseEntity<>(kupacLogInDTO1, HttpStatus.BAD_REQUEST);
                }
            }
        }
        return new ResponseEntity<>(kupacLogInDTO1, HttpStatus.NOT_FOUND);
    }

    /*@GetMapping("/register")
    public String getRegisterPage(Model model)
    {
        model.addAttribute("registerRequest", new Kupac());
        return "register_page";
    }

    @GetMapping("/login")
    public String getLogInPage(Model model)
    {
        model.addAttribute("loginRequest", new Kupac());
        return "login_page";
    }

    @GetMapping("/register")
    public String register(@ModelAttribute Kupac kupac)
    {
        System.out.println("register request -> " + kupac);
        Kupac registrovanKupac = kupacService.registracija(kupac.getKorisnickoIme(), kupac.getLozinka(),
                kupac.getIme(), kupac.getPrezime(), kupac.getPol(), kupac.getDatumRodjenja());
        return registrovanKupac == null ? "error_page" : "redirect/login";

    }

    @GetMapping("/login")
    public String login(@ModelAttribute Kupac kupac, Model model)
    {
        System.out.println("login request -> " + kupac);
        Kupac logovanKupac = kupacService.autentikacija(kupac.getKorisnickoIme(), kupac.getLozinka());
        if(logovanKupac != null)
        {
            model.addAttribute("userLogin", logovanKupac.getKorisnickoIme());
            return "personal_page";
        }
        else
            return "error_page";
    }*/
}
