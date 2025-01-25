package com.bezkoder.springjwt.models;

import javax.persistence.Entity;

@Entity
public class AdminRole extends User {
    private String nom;
    private String prenom;
    
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public AdminRole(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	public AdminRole() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    
    

}
