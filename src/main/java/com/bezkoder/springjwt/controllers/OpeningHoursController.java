package com.bezkoder.springjwt.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.OpeningHours;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.OpeningHoursRepository;
import java.util.List;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class OpeningHoursController {
	
	@Autowired
    private OpeningHoursRepository openingHoursRepository;

    @GetMapping("/by-pro-role/{proRoleId}")
    public List<OpeningHours> getOpeningHoursByProRole(@PathVariable Long proRoleId) {
        return openingHoursRepository.findByProRoleId(proRoleId);
    }

}
