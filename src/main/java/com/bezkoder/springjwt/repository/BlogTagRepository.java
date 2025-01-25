package com.bezkoder.springjwt.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bezkoder.springjwt.models.BlogTag;


public interface BlogTagRepository extends JpaRepository<BlogTag, Long>{
	
	// Requête pour récupérer tous les tags liés à un blog spécifique par son ID
    List<BlogTag> findByBlogId(Long blogId);

}
