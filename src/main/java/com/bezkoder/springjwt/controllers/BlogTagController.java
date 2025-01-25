package com.bezkoder.springjwt.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bezkoder.springjwt.models.Blog;
import com.bezkoder.springjwt.models.BlogTag;
import com.bezkoder.springjwt.models.BlogTagDTO;
import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.BlogRepository;
import com.bezkoder.springjwt.repository.BlogTagRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/Tag")

public class BlogTagController {
	
	@Autowired
    private BlogTagRepository tagRepository;

    @Autowired
    private BlogRepository blogRepository;

    @PostMapping("/add")
    public ResponseEntity<BlogTag> createTag(@RequestBody BlogTagDTO tagDTO) {
        // Récupérer le Blog associé
        Blog blog = blogRepository.findById(tagDTO.getBlogId())
                .orElseThrow(() -> new RuntimeException("Blog non trouvé"));

        // Créer un nouveau Tag et l'associer au Blog
        BlogTag tag = new BlogTag();
        tag.setNom(tagDTO.getNom());
        tag.setBlog(blog);

        // Sauvegarder le Tag
        BlogTag savedTag = tagRepository.save(tag);

        return ResponseEntity.ok(savedTag);
    }
    
    
    
 // Endpoint pour obtenir tous les tags liés à un blog par son ID
   /* @GetMapping("/blog/{blogId}")
    public List<Tag> getTagsByBlogId(@PathVariable Long blogId) {
        return tagRepository.findByBlogId(blogId);
    }*/
    
 // Endpoint pour obtenir les tags liés à un blog par son ID
    @GetMapping("/tags/{blogId}")
    public List<BlogTag> getTagsByBlogId(@PathVariable Long blogId) {
        Blog blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new RuntimeException("Blog non trouvé avec l'ID : " + blogId));

        // Extraire et retourner uniquement les tags
        return new ArrayList<>(blog.getTag());
    }
    
    @GetMapping("/tags")
    public List<BlogTag> getTags() {
        return tagRepository.findAll();
    }
}
