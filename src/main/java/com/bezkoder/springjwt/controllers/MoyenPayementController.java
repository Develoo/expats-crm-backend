package com.bezkoder.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bezkoder.springjwt.models.MoyenPayement;
import com.bezkoder.springjwt.repository.MoyenPayementRepository;

@RestController
@RequestMapping("/api/auth/moyenPay")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MoyenPayementController {

	
	@Autowired
    private MoyenPayementRepository moyenPayementRepository;
	
	  @GetMapping
	  public List<MoyenPayement> getAll() {
	 
		return  moyenPayementRepository.findAll();
	  }
	  
	  
}
