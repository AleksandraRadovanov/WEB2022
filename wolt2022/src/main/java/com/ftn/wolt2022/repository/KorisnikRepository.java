package com.ftn.wolt2022.repository;

import com.ftn.wolt2022.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    List<Korisnik> findAll();
    Korisnik findOne(Long korisnik_id);
    List<Korisnik> findByIme(String ime);
    List<Korisnik> findByPrezime(String prezime);
    List<Korisnik> findByKorisnickoIme(String korisnickoIme);

}
