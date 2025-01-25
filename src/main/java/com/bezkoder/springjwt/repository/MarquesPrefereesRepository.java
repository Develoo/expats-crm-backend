package com.bezkoder.springjwt.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bezkoder.springjwt.models.MarquesPreferees;

public interface MarquesPrefereesRepository extends JpaRepository<MarquesPreferees, Long>{
    Optional<MarquesPreferees> findByNom(String nom);
}


