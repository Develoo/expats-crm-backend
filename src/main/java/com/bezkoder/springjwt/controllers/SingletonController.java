package com.bezkoder.springjwt.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.security.services.SingletonService;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class SingletonController {

    private final SingletonService singletonService;

    public SingletonController(SingletonService singletonService) {
        this.singletonService = singletonService;
    }

    @GetMapping("/increment")
    public String increment() {
        singletonService.incrementCount();
        return "Count incremented! Current count: " + singletonService.getCount();
    }

    @GetMapping("/count")
    public String getCount() {
        return "Current count: " + singletonService.getCount();
    }
}
