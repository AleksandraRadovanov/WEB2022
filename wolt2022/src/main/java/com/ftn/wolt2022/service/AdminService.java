package com.ftn.wolt2022.service;

import com.ftn.wolt2022.entity.Admin;
import com.ftn.wolt2022.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminService {
    private final AdminRepository adminRepository;
    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin findOne(Long admin_id) {
        Admin admin = null;
        return admin;
    }

    public Admin findByKorisnickoImeILozinka(String korisnickoime, String lozinka)
    {
        return adminRepository.findByKorisnickoImeILozinka(korisnickoime, lozinka);
    }
}
