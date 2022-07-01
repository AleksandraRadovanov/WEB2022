package com.ftn.wolt2022.service;

import com.ftn.wolt2022.entity.Admin;
import com.ftn.wolt2022.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin findOne(Long admin_id) {
        Admin admin = null;

        return admin;
    }

    public Admin findByKorisnickoImeILozinka(String korisnickoime, String lozinka)
    {
        return adminRepository.findByKorisnickoImeAndLozinka(korisnickoime, lozinka);
    }
}
