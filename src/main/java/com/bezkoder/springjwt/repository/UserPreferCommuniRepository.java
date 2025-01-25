package com.bezkoder.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.UserPreferCommuni;

public interface UserPreferCommuniRepository extends JpaRepository<UserPreferCommuni, Long>{
	
	Optional<UserPreferCommuni> findByNom(String nom);

}
