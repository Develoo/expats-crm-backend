package com.bezkoder.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class UserPreferCommuni {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String prefercommuni;
	
	
	private String nom;
	
	
	@ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference(value = "user-userPreferCommuni")
    private UserRole user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrefercommuni() {
		return prefercommuni;
	}

	public void setPrefercommuni(String prefercommuni) {
		this.prefercommuni = prefercommuni;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public UserRole getUser() {
		return user;
	}

	public void setUser(UserRole user) {
		this.user = user;
	}

	public UserPreferCommuni(Long id, String prefercommuni, String nom, UserRole user) {
		super();
		this.id = id;
		this.prefercommuni = prefercommuni;
		this.nom = nom;
		this.user = user;
	}

	public UserPreferCommuni() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
	

}
