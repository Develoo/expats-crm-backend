package com.bezkoder.springjwt.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserCompagnSouhait {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	private String nom;
	
	
	/*@ManyToOne
    @JoinColumn(name = "proRole_id", referencedColumnName = "id")
    @JsonBackReference
    private ProRole proRole;*/
	
	@ManyToMany(mappedBy = "userCompagnSouhait")
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


	


	public Set<ProRole> getProRoles() {
		return proRoles;
	}


	public void setProRoles(Set<ProRole> proRoles) {
		this.proRoles = proRoles;
	}


	
	

	public UserCompagnSouhait(Long id, String nom, Set<ProRole> proRoles) {
		super();
		this.id = id;
		this.nom = nom;
		this.proRoles = proRoles;
	}


	public UserCompagnSouhait() {
		super();
		// TODO Auto-generated constructor stub
	}




}
