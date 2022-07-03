package com.ftn.wolt2022.repository;

import com.ftn.wolt2022.entity.Dostavljac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DostavljacRepository extends JpaRepository<Dostavljac, Long> {
}
