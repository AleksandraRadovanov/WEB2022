package com.ftn.wolt2022.repository;

import com.ftn.wolt2022.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka);
}
