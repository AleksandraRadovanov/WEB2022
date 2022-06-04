package com.ftn.wolt2022.DTO.BasicDTO;

import com.ftn.wolt2022.DTO.DostavljacDTO;
import com.ftn.wolt2022.entity.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BasicPorudzbinaDTO {

    private Long Id;
    private LocalDateTime DatumIVreme;
    private double Cena;
    private StatusPorudzbine Status;

    public static BasicPorudzbinaDTO convert(Porudzbina porudzbina){
        if(porudzbina != null){
            BasicPorudzbinaDTO basicPorudzbinaDTO = new BasicPorudzbinaDTO();
            basicPorudzbinaDTO.setId(porudzbina.getId());
            basicPorudzbinaDTO.setDatumIVreme(porudzbina.getDatumIVreme());
            basicPorudzbinaDTO.setCena(porudzbina.getCena());
            basicPorudzbinaDTO.setStatus(porudzbina.getStatus());

            return basicPorudzbinaDTO;
        }
        return null;
    }

    public static Porudzbina convert(BasicPorudzbinaDTO basicPorudzbinaDTO){
        if(basicPorudzbinaDTO != null){
            Porudzbina porudzbina = new Porudzbina();
            porudzbina.setId(porudzbina.getId());
            porudzbina.setDatumIVreme(porudzbina.getDatumIVreme());
            porudzbina.setCena(porudzbina.getCena());
            porudzbina.setStatus(porudzbina.getStatus());

            return porudzbina;
        }
        return null;
    }
}
