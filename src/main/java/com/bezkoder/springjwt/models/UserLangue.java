package com.bezkoder.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class UserLangue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference
    private UserRole user;
    
    @ManyToOne
    @JoinColumn(name = "langue_id", referencedColumnName = "id")
    @JsonBackReference
    private Langue langue;
    
    private String nv_comp; // Niveau de compétence pour cette langue

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Langue getLangue() {
		return langue;
	}

	public void setLangue(Langue langue) {
		this.langue = langue;
	}


	public UserLangue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNv_comp() {
		return nv_comp;
	}

	public void setNv_comp(String nv_comp) {
		this.nv_comp = nv_comp;
	}

	public UserRole getUser() {
		return user;
	}

	public void setUser(UserRole user) {
		this.user = user;
	}

	public UserLangue(Long id, UserRole user, Langue langue, String nv_comp) {
		super();
		this.id = id;
		this.user = user;
		this.langue = langue;
		this.nv_comp = nv_comp;
	}


	



}
