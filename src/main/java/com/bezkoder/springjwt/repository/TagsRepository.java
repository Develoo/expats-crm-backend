package com.bezkoder.springjwt.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bezkoder.springjwt.models.Tags;

public interface TagsRepository extends JpaRepository<Tags, Long> {
	
}