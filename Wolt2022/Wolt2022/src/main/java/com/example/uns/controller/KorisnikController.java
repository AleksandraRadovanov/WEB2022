package main.java.Wolt.controller;

public class KorisnikController {
	
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
	public Long administratorID;
	
	//-----------------------------pocetna strana------------------------------------
	
	@GetMapping("/")
	public String home() {
		return "home.html"
	}
	
	//---------------------------------PRIJAVA---------------------------------------
	
	@GetMapping("/signup")
	public String pre_signup(Model model) {
		 Korisnik korisnik = new Korisnik();//pravimo novog korisnika
	        model.addAttribute("user", user);//dodajemo novog korisnika kao atribut modela
	        return "signup.html";
	}
	
	@PostMapping("/signup")
    public String post_signup(@ModelAttribute Korisnik korisnik)
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
        	korisnikp.setTipKupca(korisnik.getTipKupca);
        	korisnikp.setSakupljeniBodovi(korisnik.getSakupljeniBodovi);
            
            this.kupacService.save(korisnikp);
     }
	
	//---------------------------------LOGOVANJE---------------------------------------

	@GetMapping("/login")//pre logovanja
    public String pre_login(Model model)
    {
        Korisnik korisnik = new User();//pravi se novi korisnik
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
                        	Kupac kupac = this.kupacService.findOne(myKorisnik.getId());
                            if (!kupac.getAllowed())
                                return "redirect:/login";
                            else
                                return "redirect:/kupac/" + myKorisnik.getId();
                        } else if (myKorisnik.getUloga().equals("DOSTAVLJAC"))
                        {
                            Dostavljac dostavljac = this.dostavljacService.findOne(myKorisnik.getId());
                            if (!dostavljac.getAllowed())
                                return "redirect:/login";
                            else
                                return "redirect:/dostavljac/" + myKorisnik.getId();
                        } else
                        {
                            return "redirect:/admin/" + myKorisnik.getId();
                        }
                    
                }
            }
        }
        return  "redirect:/login";
    }
	
	//---------------------------------ADMIN---------------------------------------

	//ubacuje korisnike u listu korisnika kod admina
	@RequestMapping("/admin/{admin_id}")
    public String getTrainers(@PathVariable("admin_id") Long admin_id, Model model)
    {
        List<Korisnik> korisnici = korisnikService.findAll();
        model.addAttribute("list", korisnici);
        model.addAttribute("id", admin_id);
        
        return "admin.html";
    }
	
	//ubacuje restorane u listu restorana kod admina
	@RequestMapping("/admin/{admin_id}")
    public String getTrainers(@PathVariable("admin_id") Long admin_id, Model model)
    {
        List<Restoran> restorani = RestoranService.findAll();
        model.addAttribute("list", restorani);
        model.addAttribute("id", admin_id);
        
        return "admin.html";
    }
	
	//---------------------------------MENADZER---------------------------------------

	//ubacuje restorane u listu restorana kod admina
		@RequestMapping("/menadzer/{menadzer_id}")
	    public String getTrainers(@PathVariable("menadzer_id") Long menadzer_id, Model model)
	    {
	        Menadzer menadzer = menadzerService.getMenadzerByID(menadzer_id);
	        Restoran restoran = restoranService.getRestoranByID(menadzer_id.getRestoranId());
	        model.addAttribute("restoran", restoran);
	        model.addAttribute("id", menadzer_id);
	        List<Porudzbina> porudzbine = porudzbinaSrvice.findAlByRestoranID();
	        model.addAtribute("porudzbine", porudzbine);
	        
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
	        trainer.setRole("MENADZER");
	        trainer.setAllowed(true);
	        trainer.setActive(true);
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
	        trainer.setRole("DOSTAVLJAC");
	        trainer.setAllowed(true);
	        trainer.setActive(true);
	        this.dostavljacService.save(dostavljac);
	        return "redirect:/admin/" + adminID;
	    }
	    
	    @GetMapping("/create_restoran")
		public String pre_signup(Model model) {
	    	Restoran restoran = new Restoran();//pravimo novog korisnika
		        model.addAttribute("restoran", restoran);//dodajemo novog korisnika kao atribut modela
		        return "admin_restoran.html";
		}
	    
	    @PostMapping("/create_restoran")
	    public String create_restoran(@ModelAttribute Restoran restoran)
	    {
	        	Restoran restoranp = new Restoran();
	        	restoranp.setID(restoran.getID());
	        	restoranp.setNaziv(restoran.getNaziv());
	        	restoranp.setTipRestorana(restoran.getTipRestorana());
	        	restoranp.setLokacija(restoran.getLokacija());
	        	restoranp.setOtvoren(restoran.getOtvoren());
	        	restoranp.setPol(restoran.getPol());
	            
	            this.kupacService.save(korisnikp);
	     }
	    
	    
	    
	  //---------------------------------DOSTAVJAC---------------------------------------	    
	 
}
	
	
