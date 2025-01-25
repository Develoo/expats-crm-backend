package com.bezkoder.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bezkoder.springjwt.models.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	
	   List<Produit> findByProRoleId(Long userId);

}