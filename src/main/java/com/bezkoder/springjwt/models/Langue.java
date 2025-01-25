package com.bezkoder.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Langue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nom;
    
   /* @OneToMany(mappedBy = "langue", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserLangue> userLangues;
	public Set<UserLangue> getUserLangues() {
		return userLangues;
	}

	public void setUserLangues(Set<UserLangue> userLangues) {
		this.userLangues = userLangues;
	}
*/
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

	public Langue(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Langue() {
		super();
		// TODO Auto-generated constructor stub
	}
/*
	public Langue(Long id, String nom, Set<UserLangue> userLangues) {
		super();
		this.id = id;
		this.nom = nom;
		this.userLangues = userLangues;
	}*/

	public Langue(Long id) {
		super();
		this.id = id;
	}

	
    


}