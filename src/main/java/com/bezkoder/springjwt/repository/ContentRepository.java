package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Content;

public interface ContentRepository extends JpaRepository<Content, Long> {
}
