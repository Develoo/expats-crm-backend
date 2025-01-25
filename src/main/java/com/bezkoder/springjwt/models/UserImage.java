package com.bezkoder.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class UserImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String imageUrl;  // URL où l'image est stockée
    private String fileName;  // Nom de l'image (facultatif)

    @ManyToOne
    @JoinColumn(name = "pro_role_id")
    @JsonBackReference
    private ProRole proRole;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ProRole getProRole() {
		return proRole;
	}

	public void setProRole(ProRole proRole) {
		this.proRole = proRole;
	}

	public UserImage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserImage(Long id, String imageUrl, String fileName, ProRole proRole) {
		super();
		this.id = id;
		this.imageUrl = imageUrl;
		this.fileName = fileName;
		this.proRole = proRole;
	}

    
}
