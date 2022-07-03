package com.ftn.wolt2022.DTO;

import com.ftn.wolt2022.DTO.BasicDTO.BasicPorudzbinaDTO;
import com.ftn.wolt2022.entity.Dostavljac;
import com.ftn.wolt2022.entity.Korisnik;
import com.ftn.wolt2022.entity.Porudzbina;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class DostavljacDTO {
    private Long ID;
    private String KorisnickoIme;
    private String Lozinka;
    private String Ime;
    private String Prezime;
    private String Pol;
    private LocalDate DatumRodjenja;
    private Korisnik.Uloga Uloga = Korisnik.Uloga.DOSTAVLJAC;
    private List<BasicPorudzbinaDTO> basicPorudzbinaDTOList = new ArrayList<>(0);
    public static Dostavljac convert(DostavljacDTO dostavljacDTO){
        if(dostavljacDTO != null){
            Dostavljac dostavljac = new Dostavljac();
            dostavljac.setId(dostavljacDTO.getID());
            dostavljac.setKorisnickoIme(dostavljacDTO.getKorisnickoIme());
            dostavljac.setLozinka(dostavljacDTO.getLozinka());
            dostavljac.setIme(dostavljacDTO.getIme());
            dostavljac.setPrezime(dostavljacDTO.getPrezime());
            dostavljac.setPol(dostavljacDTO.getPol());
            dostavljac.setDatumRodjenja(dostavljacDTO.getDatumRodjenja());

            if(dostavljacDTO.getBasicPorudzbinaDTOList().size() > 0){
                List<Porudzbina> porudzbinaList = dostavljacDTO.getBasicPorudzbinaDTOList().stream().map(BasicPorudzbinaDTO::convert).collect(Collectors.toList());
                dostavljac.setPorudzbine(porudzbinaList);
            }
            return dostavljac;
        }
        return null;
    }

    public static DostavljacDTO convert(Dostavljac dostavljac){
        if(dostavljac != null){
            DostavljacDTO dostavljacDTO = new DostavljacDTO();
            dostavljacDTO.setID(dostavljac.getId());
            dostavljacDTO.setKorisnickoIme(dostavljac.getKorisnickoIme());
            dostavljacDTO.setLozinka(dostavljac.getLozinka());
            dostavljacDTO.setIme(dostavljac.getIme());
            dostavljacDTO.setPrezime(dostavljac.getPrezime());
            dostavljacDTO.setPol(dostavljac.getPol());
            dostavljacDTO.setDatumRodjenja(dostavljac.getDatumRodjenja());

            if(dostavljac.getPorudzbine().size() > 0){
                List<BasicPorudzbinaDTO> porudzbinaList = dostavljac.getPorudzbine().stream().map(BasicPorudzbinaDTO::convert).collect(Collectors.toList());
                dostavljacDTO.setBasicPorudzbinaDTOList(porudzbinaList);
            }
            return dostavljacDTO;
        }
        return null;
    }
}
