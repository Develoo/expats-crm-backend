package com.bezkoder.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NumeroUrgence {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	   
	  private String titre;
	  
	  private String photo;
	  
	  private String description;
	  
	  private String num;

	  private String lien;
	  
	  private String pays;
	  
	  private String categorie;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	
	
	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}


	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public NumeroUrgence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public NumeroUrgence(Long id, String titre, String photo, String description, String num, String lien, String pays,
			String categorie) {
		super();
		this.id = id;
		this.titre = titre;
		this.photo = photo;
		this.description = description;
		this.num = num;
		this.lien = lien;
		this.pays = pays;
		this.categorie = categorie;
	}





	  
}
