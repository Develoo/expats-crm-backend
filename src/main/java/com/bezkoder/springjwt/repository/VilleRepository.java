package com.bezkoder.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bezkoder.springjwt.models.Ville;

public interface VilleRepository extends JpaRepository<Ville, Long> {

    List<Ville> findByPays(String pays);

}
