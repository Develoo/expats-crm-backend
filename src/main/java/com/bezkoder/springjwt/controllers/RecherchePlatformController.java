package com.bezkoder.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bezkoder.springjwt.models.RecherchePlatform;
import com.bezkoder.springjwt.repository.RecherchePlatformRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RecherchePlatformController {

	@Autowired
    private RecherchePlatformRepository servicesRechercheSurPlatformRepository;
	
	

	  @GetMapping("/RecherchePlatform")
	  public List<RecherchePlatform> getAll() {
	 
		return  servicesRechercheSurPlatformRepository.findAll();
	  }
	  
}
