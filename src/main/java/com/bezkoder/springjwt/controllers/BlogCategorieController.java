package com.bezkoder.springjwt.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bezkoder.springjwt.models.BlogCategorie;
import com.bezkoder.springjwt.repository.BlogCategorieRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/blogCategorie")
public class BlogCategorieController {

	@Autowired
    private BlogCategorieRepository repository;

    @GetMapping
    public List<BlogCategorie> getAllBlogCategorie() {
        return repository.findAll();
    }

    @PostMapping
    public BlogCategorie createBlogCategorie(@RequestBody BlogCategorie blogCategorie) {
        return repository.save(blogCategorie);
    }

    @DeleteMapping("/{id}")
    public void deleteBlogCategorie(@PathVariable Long id) {
    	repository.deleteById(id);
    }
}
