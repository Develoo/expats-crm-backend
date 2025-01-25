package com.bezkoder.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.MoyenPayement;
import com.bezkoder.springjwt.models.UserCompagnSouhait;
import com.bezkoder.springjwt.repository.MoyenPayementRepository;
import com.bezkoder.springjwt.repository.UserCompagnSouhaitRepository;

@RestController
@RequestMapping("/api/auth/compagnsouhait")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserCompagnSouhaitController {
	
	@Autowired
    private UserCompagnSouhaitRepository userCompagnSouhaitRepository;
	
	  @GetMapping
	  public List<UserCompagnSouhait> getAll() {
	 
		return  userCompagnSouhaitRepository.findAll();
	  }

}
