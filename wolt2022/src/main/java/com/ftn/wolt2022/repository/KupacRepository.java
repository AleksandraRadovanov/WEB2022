package com.ftn.wolt2022.repository;

import com.ftn.wolt2022.entity.Kupac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KupacRepository extends JpaRepository<Kupac, Long> {
    Kupac findOne(Long id);
    void save(Kupac kupac);
    List<Kupac> findAll();


}
