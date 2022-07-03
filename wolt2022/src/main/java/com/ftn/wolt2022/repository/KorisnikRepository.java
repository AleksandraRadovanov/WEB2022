package com.ftn.wolt2022.repository;

import com.ftn.wolt2022.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    Korisnik findByIme(String ime);
    Korisnik findByPrezime(String prezime);
    Korisnik findByKorisnickoIme(String korisnickoIme);

}
