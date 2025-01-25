package com.bezkoder.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pays {
	
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	
	private String nom;
	
	
	public Pays() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pays(long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	

}
