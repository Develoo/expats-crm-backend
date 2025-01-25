package com.bezkoder.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ville {

	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	
	private String nom;
	
	private String pays;

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

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Ville(long id, String nom, String pays) {
		super();
		this.id = id;
		this.nom = nom;
		this.pays = pays;
	}

	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
