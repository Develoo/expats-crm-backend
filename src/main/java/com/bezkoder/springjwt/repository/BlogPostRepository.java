package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Blog;

public interface BlogPostRepository extends JpaRepository<Blog, Long> {
}
