package com.bezkoder.springjwt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.bezkoder.springjwt.models.Categorie;



public interface CategorieRepository extends JpaRepository<Categorie, Long> {
	
	
	//public Optional<ProRole> findByCode(String code);
	
	/*List<Categorie> findByProRole(ProRole proRole);*/
	
	/*List<Categorie> findByProRole(ProRole prorole);*/

}
