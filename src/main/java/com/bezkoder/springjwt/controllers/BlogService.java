package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Blog;
import com.bezkoder.springjwt.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository repository;

    public List<Blog> getAllBlog() {
        return repository.findAll();
    }

    public Blog saveBlog(Blog inputField) {
        return repository.save(inputField);
    }

    public void deleteBlog(Long id) {
        repository.deleteById(id);
    }
}
