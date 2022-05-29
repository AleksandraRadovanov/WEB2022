package com.ftn.wolt2022.service;

import com.ftn.wolt2022.entity.Admin;
import com.ftn.wolt2022.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminLogInService {
    private final AdminRepository adminRepository;

    public AdminLogInService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }
}
