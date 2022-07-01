package com.ftn.wolt2022.repository;

import com.ftn.wolt2022.entity.Artikal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtikalRepository extends JpaRepository<Artikal, Long> {

}
