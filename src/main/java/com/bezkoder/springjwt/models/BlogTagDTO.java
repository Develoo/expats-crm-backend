package com.bezkoder.springjwt.models;

public class BlogTagDTO {

	private String nom;
    private Long blogId;

    
    

    public Long getBlogId() {
        return blogId;
    }

    public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

}

