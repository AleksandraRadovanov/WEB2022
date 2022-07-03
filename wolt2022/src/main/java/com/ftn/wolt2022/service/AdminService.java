package com.ftn.wolt2022.service;

import com.ftn.wolt2022.entity.Admin;
import com.ftn.wolt2022.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.OptionalInt;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    public Admin findOne(Long admin_id) {
        Optional<Admin> admin = adminRepository.findById(admin_id);
        return admin.orElse(null);
    }

    public Admin findByKorisnickoImeILozinka(String korisnickoime, String lozinka)
    {
        return adminRepository.findByKorisnickoImeAndLozinka(korisnickoime, lozinka);
    }
}
