package com.bezkoder.springjwt.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Langue;

public interface LangueRepository extends JpaRepository<Langue, Long>{
    Langue findByNom(String nom);

}
