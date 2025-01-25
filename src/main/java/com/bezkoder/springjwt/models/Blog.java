package com.bezkoder.springjwt.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    
    private String image;

    private LocalDateTime date;

    @Lob
    private String content;
    
   /* @ManyToOne
    @JoinColumn(name = "blogCategorie_id")
    @JsonBackReference
    private BlogCategorie blogCategorie;
    */
    private String categorie;
	private String pays;
    
    @ManyToMany(fetch = FetchType.EAGER)  
    @JoinTable(name = "blog_blogScategorie",
               joinColumns = @JoinColumn(name = "blog_id"),
               inverseJoinColumns = @JoinColumn(name = "blogScategorie_id"))
    private Set<BlogSCategorie> blogScategories = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "blogCategorie_id")
    private BlogCategorie blogCategorie;
    
    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<BlogTag> tag = new HashSet<>();
 
    
    @PrePersist
    protected void onCreate() {
        this.date = LocalDateTime.now();
    }
    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public Set<BlogSCategorie> getBlogScategories() {
		return blogScategories;
	}
	public void setBlogScategories(Set<BlogSCategorie> blogScategories) {
		this.blogScategories = blogScategories;
	}
	
	
	
	public BlogCategorie getBlogCategorie() {
		return blogCategorie;
	}
	public void setBlogCategorie(BlogCategorie blogCategorie) {
		this.blogCategorie = blogCategorie;
	}
	public Blog(Long id, String title, String image, LocalDateTime date, String content,
			Set<BlogSCategorie> blogScategories) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.date = date;
		this.content = content;
		this.blogScategories = blogScategories;
	}
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Blog(Long id, String title, String image, LocalDateTime date, String content,
			Set<BlogSCategorie> blogScategories, BlogCategorie blogCategorie) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.date = date;
		this.content = content;
		this.blogScategories = blogScategories;
		this.blogCategorie = blogCategorie;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public Set<BlogTag> getTag() {
		return tag;
	}
	public void setTag(Set<BlogTag> tag) {
		this.tag = tag;
	}
	public Blog(Long id, String title, String image, LocalDateTime date, String content, String categorie, String pays,
			Set<BlogSCategorie> blogScategories, BlogCategorie blogCategorie, Set<BlogTag> tag) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.date = date;
		this.content = content;
		this.categorie = categorie;
		this.pays = pays;
		this.blogScategories = blogScategories;
		this.blogCategorie = blogCategorie;
		this.tag = tag;
	}



    
    
}
