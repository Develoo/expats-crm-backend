package com.bezkoder.springjwt.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Produit {

	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	   
	  private String nom;
	  
	  private String image;
	  
	    @Lob
	  private String description;
	  
	  private String prix;

	  
	  @ManyToOne
	    @JoinColumn(name = "proRole_id")
	    @JsonBackReference
	    private ProRole proRole;
	  
	  
	    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public ProRole getProRole() {
		return proRole;
	}

	public void setProRole(ProRole proRole) {
		this.proRole = proRole;
	}


	public Produit(Long id, String nom, String image, String description, String prix, ProRole proRole) {
		super();
		this.id = id;
		this.nom = nom;
		this.image = image;
		this.description = description;
		this.prix = prix;
		this.proRole = proRole;
	}

	public Produit(Long id, String nom, String image, String description, String prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.image = image;
		this.description = description;
		this.prix = prix;
	}

	  
	  
}
