package com.ftn.wolt2022.repository;

import com.ftn.wolt2022.entity.Lokacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LokacijaRepository extends JpaRepository<Lokacija, Long> {

}
