package com.ftn.wolt2022.repository;

import com.ftn.wolt2022.entity.Lokacija;
import com.ftn.wolt2022.entity.Restoran;
import com.ftn.wolt2022.entity.TipRestorana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestoranRepository extends JpaRepository<Restoran, Long> {
    Restoran findByNaziv(String naziv);
    Restoran findByTipRestorana(TipRestorana tip);
    Restoran findByLokacija(Lokacija lokacija);
    Restoran findByMenadzerId(Long menadzer_id);
}
