package com.ftn.wolt2022.repository;

import com.ftn.wolt2022.entity.Menadzer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenadzerRepository extends JpaRepository<Menadzer, Long> {
    void save(Menadzer menadzer);
    Menadzer findOne(Long menadzerId);
    Menadzer findById(Long menadzerId);
}
