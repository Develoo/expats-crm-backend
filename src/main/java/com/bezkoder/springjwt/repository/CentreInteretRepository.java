package com.bezkoder.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bezkoder.springjwt.models.CentreInteret;

public interface CentreInteretRepository extends JpaRepository<CentreInteret, Long>{
    Optional<CentreInteret> findByNom(String nom);

}
