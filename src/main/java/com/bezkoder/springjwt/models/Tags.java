package com.bezkoder.springjwt.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tags {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String name;
	 
	 @ManyToMany(mappedBy = "tags")
	    @JsonIgnore
	    private Set<ProRole> proRoles = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Tags(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Tags() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
}
