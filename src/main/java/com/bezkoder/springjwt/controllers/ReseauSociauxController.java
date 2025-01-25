package com.bezkoder.springjwt.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bezkoder.springjwt.models.ReseauSociaux;
import com.bezkoder.springjwt.repository.ReseauSociauxRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ReseauSociauxController {

	@Autowired
    private ReseauSociauxRepository reseauSociauxRepository;
	
	

	  @GetMapping("/rs")
	  public List<ReseauSociaux> getAll() {
	 
		return  reseauSociauxRepository.findAll();
	  }
	  
	 
}

