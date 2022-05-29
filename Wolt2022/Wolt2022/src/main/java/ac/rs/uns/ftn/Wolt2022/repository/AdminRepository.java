package com.ftn.wolt2022.repository;

import com.ftn.wolt2022.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByKorisnickoImeILozinka(String korisnickoime, String lozinka);
}
