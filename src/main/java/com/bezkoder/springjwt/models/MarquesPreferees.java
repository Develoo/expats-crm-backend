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
public class MarquesPreferees {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	  
	    private String nom;

	    @ManyToMany(mappedBy = "marquesPreferees")
	    @JsonIgnore
	    private Set<UserRole> users = new HashSet<>();


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

		public Set<UserRole> getUsers() {
			return users;
		}

		public void setUsers(Set<UserRole> users) {
			this.users = users;
		}

		public MarquesPreferees() {
			super();
			// TODO Auto-generated constructor stub
		}

		public MarquesPreferees(Long id, String nom, Set<UserRole> users) {
			super();
			this.id = id;
			this.nom = nom;
			this.users = users;
		}
		
		
		
		
}
