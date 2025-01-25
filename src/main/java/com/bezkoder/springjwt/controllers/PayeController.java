package com.bezkoder.springjwt.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bezkoder.springjwt.models.Pays;
import com.bezkoder.springjwt.repository.PaysRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PayeController {

	@Autowired
    private PaysRepository paysRepository;
	
	

	  @GetMapping("/pays")
	  public List<Pays> getAll() {
	 
		return  paysRepository.findAll();
	 
	   
	  }
}
