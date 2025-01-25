package com.bezkoder.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bezkoder.springjwt.models.CentreInteret;
import com.bezkoder.springjwt.repository.CentreInteretRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class Centres_interetController {
	
	@Autowired
    private CentreInteretRepository centreInteretRepository;

	  @GetMapping("/centreInteret")
	  public List<CentreInteret> getAll() {
	 
		return  centreInteretRepository.findAll();
	  }
	  
	 
}
