package com.bezkoder.springjwt.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class BlogCategorie {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private String nom;
	    
	    
	/*    @OneToMany(mappedBy = "blogCategorie", fetch = FetchType.EAGER)
	    private Set<Blog> blogs = new HashSet<>();*/
	    
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


		public BlogCategorie() {
			super();
			// TODO Auto-generated constructor stub
		}


	public BlogCategorie(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	    
	    
}
