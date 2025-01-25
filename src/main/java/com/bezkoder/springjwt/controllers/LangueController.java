package com.bezkoder.springjwt.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bezkoder.springjwt.models.Langue;
import com.bezkoder.springjwt.repository.LangueRepository;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LangueController {
	
	@Autowired
    private LangueRepository langueRepository;
	
	

	  @GetMapping("/langue")
	  public List<Langue> getAll() {
	 
		return  langueRepository.findAll();
	  }
	  
	 
}
