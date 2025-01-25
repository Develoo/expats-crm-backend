package com.bezkoder.springjwt.controllers;

import org.springframework.web.bind.annotation.*;
import com.bezkoder.springjwt.models.Content;
import com.bezkoder.springjwt.repository.ContentRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/api/auth/content")
@CrossOrigin(origins = "*", maxAge = 3600)

/*@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/content")*/

public class ContentController {

    @Autowired
    private ContentRepository contentRepository;

    @PostMapping
    public Content saveContent(@RequestBody Content content) {
        return contentRepository.save(content);
    }
    
    @GetMapping("/{id}")
    public Optional<Content> getContentById(@PathVariable Long id) {
        return contentRepository.findById(id);
        //return contentRepository.escapeHtml(findById(id));
    }
    
}
