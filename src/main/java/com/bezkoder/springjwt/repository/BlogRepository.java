package com.bezkoder.springjwt.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bezkoder.springjwt.models.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {
	
    List<Blog> findByBlogCategorieNom(String nom);
    
    @Query("SELECT b FROM Blog b JOIN b.blogScategories sc WHERE sc.id = :scategorieId")
    List<Blog> findByBlogScategorieId(@Param("scategorieId") Long scategorieId);
    
	   // List<Blog> findByBlogScategories_BlogCategorie_Nom( String categorieNom);
	/* @Query("SELECT DISTINCT b FROM Blog b JOIN b.blogScategories sc WHERE sc.blogCategorie.nom = :categorieNom")
	  List<Blog> findDistinctByBlogScategories_BlogCategorie_Nom(@Param("categorieNom") String categorieNom);
*/
	
	


}
