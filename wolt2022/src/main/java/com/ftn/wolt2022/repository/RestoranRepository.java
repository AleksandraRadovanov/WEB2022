package com.ftn.wolt2022.repository;

import com.ftn.wolt2022.entity.Lokacija;
import com.ftn.wolt2022.entity.Restoran;
import com.ftn.wolt2022.entity.TipRestorana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestoranRepository extends JpaRepository<Restoran, Long> {
    List<Restoran> findAll();
    Restoran getRestoranById(Long ID);
    void save(Restoran restoranp);
    List<Restoran> findByNaziv(String naziv);
    List<Restoran> findByTip(TipRestorana tip);
    List<Restoran> findByLokacija(Lokacija lokacija);
    Restoran  findByMenadzerID(Long menadzer_id);
    Restoran create(Restoran res);

}
