package com.ftn.wolt2022.controller;

import com.ftn.wolt2022.entity.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.wolt2022.service.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class KorisnikController
{
        @Autowired
        private AdminService adminService;
        @Autowired
        private ArtikalService artikalService;
        @Autowired
        private DostavljacService dostavljacService;
        @Autowired
        private KomentarService komentarService;
        @Autowired
        private KorisnikService korisnikService;
        @Autowired
        private KupacService kupacService;
        @Autowired
        private LokacijaService lokacijaService;
        @Autowired
        private MenadzerService menadzerService;
        @Autowired
        private PorudzbinaService porudzbinaService;
        @Autowired
        private RestoranService restoranService;
        public Long administratorID;//?
        public Long adminID;
        Object user;//korisnik koji se loguje



        //-----------------------------POCETNA STRANA------------------------------------

        @GetMapping("/")
        public String home() {
            return "home.html";
        }

        //---------------------------------PRIJAVA---------------------------------------

        @GetMapping("/signup")
        public String pre_signup(Model model) {
            Korisnik korisnik = new Korisnik();//pravimo novog korisnika
            model.addAttribute("user", user);//dodajemo novog korisnika kao atribut modela
            return "signup.html";
        }

        @PostMapping("/signup")
        public String post_signup(@ModelAttribute Kupac korisnik)
        {
            Kupac korisnikp = new Kupac();
            korisnikp.setID(korisnik.getID());
            korisnikp.setKorisnickoIme(korisnik.getKorisnickoIme());
            korisnikp.setLozinka(korisnik.getLozinka());
            korisnikp.setIme(korisnik.getIme());
            korisnikp.setPrezime(korisnik.getPrezime());
            korisnikp.setPol(korisnik.getPol());
            korisnikp.setDatumRodjenja(korisnik.getDatumRodjenja());
            korisnikp.setUloga(korisnik.getUloga());
            korisnikp.setTipKupca(korisnik.getTipKupca());
            korisnikp.setSakulpljeniBodovi(korisnik.getSakulpljeniBodovi());

            this.kupacService.save(korisnikp);
            return "uspesno!";
        }

        //---------------------------------LOGOVANJE---------------------------------------

        @GetMapping("/login")//pre logovanja
        public String pre_login(Model model)
        {
            Korisnik korisnik = new Korisnik();//pravi se novi korisnik
            model.addAttribute("korisnik", korisnik);//dodaje se u model
            return "login.html";//vracamo se na login stranu
        }

        @GetMapping("/login-attempt")//pokusaj logovanja
        public String post_login(@ModelAttribute Korisnik korisnik)
        {
            List<Korisnik> korisnici = KorisnikService.findAll();
            for (Korisnik myKorisnik : korisnici)
            {
                if(korisnik.getKorisnickoIme().equals(myKorisnik.getKorisnickoIme()))
                {
                    if(korisnik.getLozinka().equals(myKorisnik.getLozinka()))
                    {
                        if (myKorisnik.getUloga().equals("KUPAC"))
                        {
                            Kupac kupac = this.kupacService.findOne(myKorisnik.getID());

                                return "redirect:/kupac/" + myKorisnik.getID();
                        } else if (myKorisnik.getUloga().equals("DOSTAVLJAC"))
                        {
                            Dostavljac dostavljac = this.dostavljacService.findOne(myKorisnik.getID());

                                return "redirect:/dostavljac/" + myKorisnik.getID();
                        } else
                        {
                            return "redirect:/admin/" + myKorisnik.getID();
                        }
                    }
                }
            }
            return  "redirect:/login";
        }

        //---------------------------------ADMIN---------------------------------------

        //ubacuje korisnike u listu korisnika kod admina
        @RequestMapping("/admin/{admin_id}")
        public String getKorisnik(@PathVariable("admin_id") Long admin_id, Model model) //?????
        {
            List<Korisnik> korisnici = korisnikService.findAll();
            model.addAttribute("list", korisnici);
            model.addAttribute("id", admin_id);

            return "admin.html";
        }

        //ubacuje restorane u listu restorana kod admina
        @RequestMapping("/admin/{admin_id}")
        public String getTrainers_admin(@PathVariable("admin_id") Long admin_id, Model model) //???
        {
            List<Restoran> restorani = restoranService.findAll();
            model.addAttribute("list", restorani);
            model.addAttribute("id", admin_id);

            return "admin.html";
        }

        //---------------------------------MENADZER---------------------------------------

        //ubacuje restorane u listu restorana kod admina
        @RequestMapping("/menadzer/{menadzer_id}")
        public String getTrainers_menager(@PathVariable("menadzer_id") Long menadzer_id, Model model) //?????
        {
            Menadzer menadzer = menadzerService.getMenadzerByID(menadzer_id);
            Restoran restoran = restoranService.getRestoranById(menadzerService.getMenadzerByID(menadzer_id).getRestoranID());
            model.addAttribute("restoran", restoran);
            model.addAttribute("id", menadzer_id);
            List<Porudzbina> porudzbine = porudzbinaService.findAlByRestoranID();
            model.addAttribute("porudzbine", porudzbine);

            return "menadzer.html";
        }

        //---------------------------------RESTORAN---------------------------------------
        //kreiranje menadzera
        @GetMapping("/admin/{admin_id}/register")//pre kreiranja menadzera
        public String pre_admin_create_menadzer(@PathVariable("admin_id") Long admin_id, Model model)
        {
            Menadzer menadzer = new Menadzer();
            Admin admin = this.adminService.findOne(admin_id);
            model.addAttribute("menadzer", menadzer);
            model.addAttribute("admin", admin);
            adminID = admin_id;
            return "administrator_signup_menadzer.html";
        }

        @PostMapping("/admin/create")//posle kreiranja menadzera
        public String post_admin_create_menadzer(@ModelAttribute Menadzer menadzer, Model model)
        {
            menadzer.setUloga(Korisnik.Uloga.valueOf("MENADZER"));
            this.menadzerService.save(menadzer);
            return "redirect:/admin/" + adminID;
        }

        //kreiranje dostavljaca
        @GetMapping("/admin/{admin_id}/register")//pre kreiranja dostavljaca
        public String pre_admin_create_dostavljac(@PathVariable("admin_id") Long admin_id, Model model)
        {
            Dostavljac dostavljac = new Dostavljac();
            Admin admin = this.adminService.findOne(admin_id);
            model.addAttribute("dostavljac", dostavljac);
            model.addAttribute("admin", admin);
            adminID = admin_id;
            return "administrator_signup_dostavljac.html";
        }

        @PostMapping("/admin/create")//posle kreiranja menadzera
        public String post_admin_create_dostavljac(@ModelAttribute Dostavljac dostavljac, Model model)
        {
            dostavljac.setUloga(Korisnik.Uloga.valueOf("DOSTAVLJAC"));
            this.dostavljacService.save(dostavljac);
            return "redirect:/admin/" + adminID;
        }


        @PostMapping("/create_restoran")
        public String create_restoran(@ModelAttribute Restoran restoran)
        {
            Restoran restoranp = new Restoran();
            restoranp.setID(restoran.getID());
            restoranp.setNaziv(restoran.getNaziv());
            restoranp.setTipRestorana(restoran.getTipRestorana());
            restoranp.setLokacija((Lokacija)restoran.getLokacija());
            restoranp.setOtvoren(restoran.isOtvoren());

            this.restoranService.save(restoranp);
            return null;
        }

    @PostMapping("/prikaz_svih_restorana_svima")
    public String viewAllRestorants(@PathVariable("korisnik_id") Long korisnik_id, Model model)
    {
        List<Restoran> list = restoranService.findAll();
        Korisnik korisnik = this.korisnikService.findOne(korisnik_id);
        model.addAttribute("list", list);
        model.addAttribute("administrator", korisnik);

        return "prikazSvihRestorana.html";
    }


    @PostMapping("/prikaz_restorana_po_nazivu")
    public String findRestoranByNaziv(@PathVariable("korisnik_id") String naziv, Model model)
    {
        List<Restoran> restorani = restoranService.findByNaziv(naziv);

        model.addAttribute("list", restorani);

        return "nadjiRestoranPoNazivu.html";
    }

    @PostMapping("/prikaz_restorana_po_tipu")
    public String findRestoranByTip(@PathVariable("korisnik_id") Restoran.Tip tip, Model model)
    {
        List<Restoran> restorani = restoranService.findByTip(tip);

        model.addAttribute("list", restorani);

        return "nadjiRestoranPoTipu.html";
    }

    @PostMapping("/prikaz_restorana_po_lokaciji")
    public String findRestoranByLokacija(@PathVariable("korisnik_id") Lokacija lokacija, Model model)
    {
        List<Restoran> restorani = restoranService.findByLokacija(lokacija);

        model.addAttribute("list", restorani);

        return "nadjiRestoranPoLokaciji.html";
    }

        //---------------------------------PORUDZBINE---------------------------------------
    @PostMapping("/prikaz_svih_porudzbina_kupcu")
    public String viewAllPorudzbina_kupac(@PathVariable("kupac_id") Long kupac_id, Model model)
    {
        List<Porudzbina> list = porudzbinaService.findAll();
        Kupac kupac = this.kupacService.findOne(kupac_id);
        model.addAttribute("list", list);
        model.addAttribute("kupac", kupac);

        return "prikazSvihPorudzbina.html";
    }

    @PostMapping("/prikaz_svih_porudzbina_dostavljac")
    public String viewAllPorudzbina_dostavljac(@PathVariable("dostavljac_id") Long dostavljac_id, Model model)
    {
        Dostavljac dostavljac = this.dostavljacService.findOne(dostavljac_id);

        List<Porudzbina> porudzbine = porudzbinaService.findByDostavljac(dostavljac_id);

        model.addAttribute("list", porudzbine);

        model.addAttribute("dostavljac", dostavljac);
        return "nadjiPorudzbineDostavljaca.html";
    }

    @PostMapping("/prikaz_svih_porudzbina_menadzer")
    public String viewAllPorudzbina_menadzer(@PathVariable("menadzer_id") Long menadzer_id,  Model model)
    {
        Menadzer menadzer = menadzerService.getMenadzerByID(menadzer_id);
        Restoran restoran = restoranService.findByMenadzerID(menadzer_id);

        List<Porudzbina> porudzbine = porudzbinaService.findByMenadzer(menadzer_id, restoran.getID());

        model.addAttribute("list", porudzbine);

        model.addAttribute("menadzer", menadzer);
        return "nadjiPorudzbineDostavljaca.html";
    }
}
