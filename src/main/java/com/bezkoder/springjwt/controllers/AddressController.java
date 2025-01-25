package com.bezkoder.springjwt.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AddressController {
	
	 @PostMapping("/api/location")
	    public void receiveLocation(@RequestBody Location location) {
	        System.out.println("Received location: " + location);
	        // Logique pour traiter la localisation reçue
	    }
	}

	class Location {
	    private double latitude;
	    private double longitude;

	    // Getters et Setters

	    @Override
	    public String toString() {
	        return "Location{" +
	                "latitude=" + latitude +
	                ", longitude=" + longitude +
	                '}';
	    }
	}