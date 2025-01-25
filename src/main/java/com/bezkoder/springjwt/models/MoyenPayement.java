package com.bezkoder.springjwt.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MoyenPayement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant unique

    private String nom; // Nom du moyen de paiement


	 @ManyToMany(mappedBy = "moyenPayement")
	    @JsonIgnore
	    private Set<ProRole> proRoles = new HashSet<>();
    
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


	public MoyenPayement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<ProRole> getProRoles() {
		return proRoles;
	}

	public void setProRoles(Set<ProRole> proRoles) {
		this.proRoles = proRoles;
	}

	public MoyenPayement(Long id, String nom, Set<ProRole> proRoles) {
		super();
		this.id = id;
		this.nom = nom;
		this.proRoles = proRoles;
	}

	@Override
	public String toString() {
		return "MoyenPayement [id=" + id + ", nom=" + nom + ", proRoles=" + proRoles + "]";
	}

    
    
}