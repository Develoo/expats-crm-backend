package com.bezkoder.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.bezkoder.springjwt.models.CentreInteret;
import com.bezkoder.springjwt.models.MoyenPayement;

public interface MoyenPayementRepository extends JpaRepository<MoyenPayement, Long>{
	
	Optional<MoyenPayement> findByNom(String nom);

}
