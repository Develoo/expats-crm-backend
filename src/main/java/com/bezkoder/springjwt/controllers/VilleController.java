package com.bezkoder.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bezkoder.springjwt.models.Ville;
import com.bezkoder.springjwt.repository.VilleRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VilleController {
	
	@Autowired
    private VilleRepository villeRepository;
	
	

	  @GetMapping("/ville")
	  public List<Ville> getAll() {
	 
		return  villeRepository.findAll();
	  }
	  
	  @GetMapping("/villeByPays")
	  public List<Ville> getAllByPays(@RequestParam String pays) {
	 
		return  villeRepository.findByPays(pays);
	  }
	  @GetMapping("/villeByPays/{nomPays}")
	  public List<Ville> getVilleByPays(@PathVariable String nomPays) {
	 
		return  villeRepository.findByPays(nomPays);
	  }

}
