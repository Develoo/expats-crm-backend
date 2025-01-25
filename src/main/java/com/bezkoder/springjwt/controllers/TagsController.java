package com.bezkoder.springjwt.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bezkoder.springjwt.models.Tags;
import com.bezkoder.springjwt.repository.TagsRepository;

@RestController
@RequestMapping("/api/auth/tags")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TagsController {

	 @Autowired
	    private TagsRepository tagsRepository;

	    @GetMapping
	    public List<Tags> getAllTags() {
	        return tagsRepository.findAll();
	    }

	    @PostMapping
	    public Tags createTags(@RequestBody Tags tags) {
	        return tagsRepository.save(tags);
	    }

	    @GetMapping("/{id}")
	    public Optional<Tags> getTagsById(@PathVariable Long id) {
	        return tagsRepository.findById(id);
	    }
	    
	/*    @GetMapping("/{Iduser}")
	    public List<Tags> getTagsByUser(@PathVariable Long Iduser) {
	        return tagsRepository.findByUserId(Iduser);
	    }*/
}
