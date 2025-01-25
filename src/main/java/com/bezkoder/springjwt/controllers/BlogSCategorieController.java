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
import com.bezkoder.springjwt.models.BlogSCategorie;
import com.bezkoder.springjwt.repository.BlogSCategorieRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/blogSCategorie")
public class BlogSCategorieController {

	@Autowired
    private BlogSCategorieRepository repository;

    @GetMapping
    public List<BlogSCategorie> getAllBlogSCategorie() {
        return repository.findAll();
    }

    @PostMapping
    public BlogSCategorie createBlogSCategorie(@RequestBody BlogSCategorie blogSCategorie) {
        return repository.save(blogSCategorie);
    }

    @DeleteMapping("/{id}")
    public void deleteBlogSCategorie(@PathVariable Long id) {
    	repository.deleteById(id);
    }
}
