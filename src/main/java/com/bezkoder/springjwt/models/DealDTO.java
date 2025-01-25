package com.bezkoder.springjwt.models;

import java.time.LocalDate;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DealDTO {

	
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private long id;
	
	private String nom;
	private String description;
	private String img;
	private LocalDate  date_debut;
	private LocalDate  date_expir;
	private String etat;
    private Long proRoleId;
    
    
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

	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Long getProRoleId() {
		return proRoleId;
	}
	public void setProRoleId(Long proRoleId) {
		this.proRoleId = proRoleId;
	}
	public LocalDate getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(LocalDate date_debut) {
		this.date_debut = date_debut;
	}
	public LocalDate getDate_expir() {
		return date_expir;
	}
	public void setDate_expir(LocalDate date_expir) {
		this.date_expir = date_expir;
	}
	
    
}

