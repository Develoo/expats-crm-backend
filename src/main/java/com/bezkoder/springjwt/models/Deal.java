package com.bezkoder.springjwt.models;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Deal {

	

	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	
	private String nom;
	
	  @Lob
	private String description;
	
	private String img;

	private LocalDate  date_debut;

	private LocalDate  date_expir;
	
	private String etat;


	 /*  @ManyToOne
	    @JoinColumn(name = "proRole_id")
	   @JsonManagedReference
	    private ProRole proRole;*/
	
	@ManyToOne
    @JoinColumn(name = "proRole_id")
    private ProRole proRole;  // Retirer l'annotation @JsonManagedReference

	   

	public LocalDate getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(LocalDate date_debut) {
		this.date_debut = date_debut;
	}

	public void setDate_expir(LocalDate date_expir) {
		this.date_expir = date_expir;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}


	public ProRole getProRole() {
		return proRole;
	}

	public void setProRole(ProRole proRole) {
		this.proRole = proRole;
	}
	
	public Deal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public LocalDate getDate_expir() {
		return date_expir;
	}

	public Deal(long id, String nom, String description, String img, LocalDate date_debut, LocalDate date_expir,
			String etat, ProRole proRole) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.img = img;
		this.date_debut = date_debut;
		this.date_expir = date_expir;
		this.etat = etat;
		this.proRole = proRole;
	}



	   
	   
	
}
