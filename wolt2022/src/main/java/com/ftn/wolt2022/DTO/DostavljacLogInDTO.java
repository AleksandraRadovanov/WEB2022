package com.ftn.wolt2022.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DostavljacLogInDTO {
    private Long id;
    private String korisnickoime;
    private String lozinka;
    public DostavljacLogInDTO(){}
    public DostavljacLogInDTO(Long i, String ki, String l)
    {
        this.id = i;
        this.korisnickoime = ki;
        this.lozinka = l;
    }
}
