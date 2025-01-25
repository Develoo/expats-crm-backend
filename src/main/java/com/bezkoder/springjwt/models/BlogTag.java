package com.bezkoder.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class BlogTag {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nom;

	 @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "blog_id")
	    @JsonBackReference
	    private Blog blog;
 
	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}

 
	public Blog getBlog() {
		return blog;
	}
 
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
 
	public String getNom() {
		return nom;
	}
 
	public void setNom(String nom) {
		this.nom = nom;
	}
 
	public BlogTag(Long id, String nom, Blog blog) {
		super();
		this.id = id;
		this.nom = nom;
		this.blog = blog;
	}
 
	public BlogTag() {
		super();
		// TODO Auto-generated constructor stub
	}
}
