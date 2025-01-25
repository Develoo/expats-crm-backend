package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bezkoder.springjwt.models.Pays;

public interface PaysRepository extends JpaRepository<Pays, Long> {

}
