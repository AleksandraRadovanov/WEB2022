package com.ftn.wolt2022.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KupacLogInDTO {
    private Long ID;
    private String korisnickoIme;
    private String lozinka;

    public KupacLogInDTO(){}
    public KupacLogInDTO(Long id, String ki, String l)
    {
        this.ID = id;
        this.korisnickoIme = ki;
        this.lozinka = l;
    }
}
