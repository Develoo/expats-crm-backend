package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {}


