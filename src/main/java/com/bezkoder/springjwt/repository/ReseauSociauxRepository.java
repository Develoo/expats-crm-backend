package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.ReseauSociaux;

public interface ReseauSociauxRepository extends JpaRepository<ReseauSociaux, Long>{
	ReseauSociaux findByNom(String nom);
}
