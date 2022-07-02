package com.ftn.wolt2022.repository;

import com.ftn.wolt2022.entity.Kupac;
import com.ftn.wolt2022.entity.Porudzbina;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoruzbinaRepository extends JpaRepository<Porudzbina, Long> {
    List<Porudzbina> findAlByRestoranID();
    List<Porudzbina> findAll();
    Kupac findByKupacID(Long kupacID);

    List<Porudzbina> findByDostavljac(Long dostavljacID);
    List<Porudzbina> findByMenadzer(Long menadzer_id, Long restoran_id);


    List<Porudzbina> findByDostavljac(Long dostavljacID, Sort dostavljacID1);

}
