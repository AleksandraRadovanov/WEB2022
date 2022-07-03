package com.ftn.wolt2022.controller;

import com.ftn.wolt2022.DTO.AdminLogInDTO;
import com.ftn.wolt2022.entity.Admin;
import com.ftn.wolt2022.service.AdminLogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/adminlogin")
public class AdminLogInController {
    private final AdminLogInService adminLogInService;

    @Autowired
    public AdminLogInController(AdminLogInService adminLogInService) {
        this.adminLogInService = adminLogInService;
    }

    //logovanje admina
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdminLogInDTO> login(@RequestBody AdminLogInDTO adminLogInDTO)
    {
        AdminLogInDTO adminLogInDTO1 = new AdminLogInDTO(adminLogInDTO.getID(), adminLogInDTO.getKorisnickoIme(), adminLogInDTO.getLozinka());
        List<Admin> administratori = adminLogInService.findAll();
        for(Admin a : administratori)
        {
            if(a.getKorisnickoIme().equals(adminLogInDTO1.getKorisnickoIme()))
            {
                if(a.getLozinka().equals(adminLogInDTO1.getLozinka()))
                {
                    adminLogInDTO1.setID(a.getId());
                    return new ResponseEntity<>(adminLogInDTO1, HttpStatus.OK);
                }
                else
                {
                    return new ResponseEntity<>(adminLogInDTO1, HttpStatus.BAD_REQUEST);
                }
            }
        }
        return new ResponseEntity<>(adminLogInDTO1, HttpStatus.NOT_FOUND);
    }
}
