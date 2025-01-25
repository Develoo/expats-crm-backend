package com.bezkoder.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReseauSociaux {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private String nom;

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

		public ReseauSociaux(Long id, String nom) {
			super();
			this.id = id;
			this.nom = nom;
		}

		public ReseauSociaux() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
	    
	    

}
