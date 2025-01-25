package com.bezkoder.springjwt.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bezkoder.springjwt.models.MarquesPreferees;
import com.bezkoder.springjwt.repository.MarquesPrefereesRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MarquesPrefereesController {

	
	@Autowired
    private MarquesPrefereesRepository marquesPrefereesRepository;
	
	

	  @GetMapping("/marquesPrefere")
	  public List<MarquesPreferees> getAll() {
	 
		return  marquesPrefereesRepository.findAll();
	  }
	  
}
