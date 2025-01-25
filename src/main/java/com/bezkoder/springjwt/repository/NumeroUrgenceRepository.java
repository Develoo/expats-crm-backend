package com.bezkoder.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bezkoder.springjwt.models.NumeroUrgence;

public interface NumeroUrgenceRepository extends JpaRepository<NumeroUrgence, Long>{


	List<NumeroUrgence> findByCategorie(String categorie);

	 
}
