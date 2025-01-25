package com.bezkoder.springjwt.models;

import java.util.Set;

public class MoyenPayementDTO {

	
	  private Long id;
	  private String nom;
	  
	    private Set<Long> proRoleIds;  // Liste des IDs de ProRole associés

	public Set<Long> getProRoleIds() {
			return proRoleIds;
		}
		public void setProRoleIds(Set<Long> proRoleIds) {
			this.proRoleIds = proRoleIds;
		}
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
	

}
