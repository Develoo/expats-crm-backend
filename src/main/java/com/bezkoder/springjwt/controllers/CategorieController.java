package com.bezkoder.springjwt.controllers;

import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bezkoder.springjwt.models.Categorie;
import com.bezkoder.springjwt.models.Deal;
import com.bezkoder.springjwt.repository.CategorieRepository;



@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)

public class CategorieController {
	
	@Autowired
    private CategorieRepository categorieRepository;
	
	
	@PostMapping("/categories")
	public Categorie createsCategorie(@Valid @RequestBody Categorie Categorie) {
		return categorieRepository.save(Categorie);
	}
	
	  @GetMapping("/categorie")
	  public List<Categorie> getAll() {
	 
		return  categorieRepository.findAll();
	 
	   
	  }

	  
}
