package com.bezkoder.springjwt.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.bezkoder.springjwt.models.Blog;
import com.bezkoder.springjwt.models.BlogCategorie;
import com.bezkoder.springjwt.models.BlogDTO;
import com.bezkoder.springjwt.models.BlogSCategorie;
import com.bezkoder.springjwt.models.BlogTag;
import com.bezkoder.springjwt.models.BlogTagDTO;
import com.bezkoder.springjwt.repository.BlogCategorieRepository;
import com.bezkoder.springjwt.repository.BlogRepository;
import com.bezkoder.springjwt.repository.BlogSCategorieRepository;
import com.bezkoder.springjwt.repository.FilesStorageService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class BlogController {

	@Autowired
    private BlogService service;
	
	@Autowired
    private BlogRepository repository;
	
	@Autowired
	FilesStorageService storageService;

	@Autowired
	BlogCategorieRepository blogCategorieRepository;

	@Autowired
	BlogSCategorieRepository blogSCategorieRepository;

    @GetMapping("/blog")
    public List<Blog> getAllBlog() {
        return service.getAllBlog();
    }

    @GetMapping("/blog/categorie/{nomCat}")
    public List<Blog> getAllBlogByCategorie(@PathVariable String nomCat) {
        return repository.findByBlogCategorieNom(nomCat);
    }
    @PostMapping
    public Blog createBlog(@RequestBody Blog blog) {
        return service.saveBlog(blog);
    }

    @DeleteMapping("/blog/{id}")
    public void deleteBlog(@PathVariable Long id) {
        service.deleteBlog(id);
    }
    
    @RequestMapping(value = "/blog/{id}",method = RequestMethod.GET)
  		public Optional<Blog> getBlogById(@PathVariable Long id){
  			return repository.findById(id);
  		}
  /*  @PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			storageService.save(file);
			return file.getOriginalFilename();

		} catch (Exception e) {
			message = "Could not upload the file";
			return message;
		}
	}*/
    @PostMapping("/upload2")
    public ResponseEntity<String> uploadFile2(@RequestParam("file") MultipartFile file) {
        // Vérification si le fichier est trop volumineux
        if (file.getSize() > 10 * 1024 * 1024) { // 10MB
            return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body("File is too large");
        }

        try {
			storageService.save(file);
            String filename = file.getOriginalFilename();
            // Logique de traitement du fichier
            return ResponseEntity.ok("File uploaded successfully: " + filename);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed");
        }
    }


	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = storageService.load(filename);
		return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}
	
	
	@GetMapping("/blogs/categorie-lire")
    public List<Blog> getBlogsByCategorieLire() {
        return repository.findByBlogCategorieNom("lire");
    }
 
    
    @GetMapping("/blogs/categorie-Ecouter")
    public List<Blog> getBlogsByCategorieEcouter() {
        return repository.findByBlogCategorieNom("Ecouter");
    }
    @GetMapping("/blogs/categorie-Regarder")
    public List<Blog> getBlogsByCategorieRegarder() {
        return repository.findByBlogCategorieNom("Regarder");
    }

    @GetMapping("/by-sous-categorie/{scategorieId}")
    public List<Blog> getBlogsByBlogScategorie(@PathVariable Long scategorieId) {
        return repository.findByBlogScategorieId(scategorieId);
        }

   /* @PostMapping("/ajoutblog")
    public Blog createBlog(@RequestBody Blog blog) {
        return service.saveBlog(blog);
    }*/

    @PostMapping("/ajoutblog")
    public Blog createBlog(@RequestBody BlogDTO blogDTO) {
        BlogCategorie blogCategorie = blogCategorieRepository.findById(blogDTO.getBlogCategorieId()).orElseThrow(() -> new RuntimeException("Categorie non trouvée"));
        Blog blog = new Blog();
        blog.setTitle(blogDTO.getTitle());
        blog.setContent(blogDTO.getContent());
        blog.setBlogCategorie(blogCategorie);
        blog.setPays(blogDTO.getPays());
        blog.setImage(blogDTO.getImage());

     // Récupérer les BlogSCategorie correspondants à partir des IDs
        Set<BlogSCategorie> blogScategories = new HashSet<>();
        for (Long scategorieId : blogDTO.getBlogScategorieIds()) {
            BlogSCategorie scategorie = blogSCategorieRepository.findById(scategorieId)
                    .orElseThrow(() -> new RuntimeException("Sous-catégorie non trouvée"));
            blogScategories.add(scategorie);
        }
        blog.setBlogScategories(blogScategories);
     // Ajouter les tags
        Set<BlogTag> tags = new HashSet<>();
        for (BlogTagDTO tagDTO : blogDTO.getTags()) {
            BlogTag tag = new BlogTag();
            tag.setNom(tagDTO.getNom());
            tag.setBlog(blog); // Lier le tag au blog
            tags.add(tag);
        }
        blog.setTag(tags); // Associer les tags au blog
 
 
        
        return repository.save(blog);
    }
    @PutMapping("/updateblog/{id}")
    public Blog updateBlog(@PathVariable Long id, @RequestBody BlogDTO blogDTO) {
        // Vérifier que l'ID du blog est bien présent
        if (id == null) {
            throw new IllegalArgumentException("L'ID du blog ne doit pas être nul !");
        }
 
        // Récupérer le blog existant
        Blog existingBlog = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog non trouvé avec l'ID: " + id));
 
        // Récupérer la catégorie, vérifier que l'ID n'est pas null
        if (blogDTO.getBlogCategorieId() == null) {
            throw new IllegalArgumentException("L'ID de la catégorie ne doit pas être nul !");
        }
        BlogCategorie blogCategorie = blogCategorieRepository.findById(blogDTO.getBlogCategorieId())
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée avec l'ID: " + blogDTO.getBlogCategorieId()));
 
        // Mettre à jour les champs du blog
        existingBlog.setTitle(blogDTO.getTitle());
        existingBlog.setContent(blogDTO.getContent());
        existingBlog.setBlogCategorie(blogCategorie);
        existingBlog.setPays(blogDTO.getPays());
        existingBlog.setImage(blogDTO.getImage());
 
        // Vérifier et mettre à jour les sous-catégories
        Set<BlogSCategorie> blogScategories = new HashSet<>();
        for (Long scategorieId : blogDTO.getBlogScategorieIds()) {
            if (scategorieId == null) {
                throw new IllegalArgumentException("L'ID de la sous-catégorie ne doit pas être nul !");
            }
            BlogSCategorie scategorie = blogSCategorieRepository.findById(scategorieId)
                    .orElseThrow(() -> new RuntimeException("Sous-catégorie non trouvée avec l'ID: " + scategorieId));
            blogScategories.add(scategorie);
        }
        existingBlog.setBlogScategories(blogScategories);
 
     // Suppression des anciens tags avant mise à jour
        existingBlog.getTag().clear();
 
        // Vérifier et mettre à jour les tags
        Set<BlogTag> tags = new HashSet<>();
        for (BlogTagDTO tagDTO : blogDTO.getTags()) {
            if (tagDTO.getNom() == null) {
                throw new IllegalArgumentException("Le nom du tag ne doit pas être nul !");
            }
            BlogTag tag = new BlogTag();
            tag.setNom(tagDTO.getNom());
            tag.setBlog(existingBlog); // Lier le tag au blog
            tags.add(tag);
        }
        existingBlog.setTag(tags);

 
        // Sauvegarder les modifications
        return repository.save(existingBlog);
    }


}
