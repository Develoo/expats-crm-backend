package com.bezkoder.springjwt.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bezkoder.springjwt.models.RecherchePlatform;

public interface RecherchePlatformRepository extends JpaRepository<RecherchePlatform, Long>{
    Optional<RecherchePlatform> findByNom(String nom);
}
