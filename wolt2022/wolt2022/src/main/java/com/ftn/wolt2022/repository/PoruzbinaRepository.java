package com.ftn.wolt2022.repository;

import com.ftn.wolt2022.entity.Porudzbina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoruzbinaRepository extends JpaRepository<Porudzbina, Long> {

}
