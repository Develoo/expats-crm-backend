package com.bezkoder.springjwt.models;

import java.util.List;

public class ProduitDTO {

	
	 private String nom;
	    private String image;
	    private String description;
	    private String prix;
	    private Long proRoleId;
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getPrix() {
			return prix;
		}
		public void setPrix(String prix) {
			this.prix = prix;
		}
		public Long getProRoleId() {
			return proRoleId;
		}
		public void setProRoleId(Long proRoleId) {
			this.proRoleId = proRoleId;
		}

	    
}
