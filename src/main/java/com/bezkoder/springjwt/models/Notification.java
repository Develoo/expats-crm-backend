package com.bezkoder.springjwt.models;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class Notification {

	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	   
	  private String titre;
	  
	  private String photo;
	  
	  private String description;
	  
	  private String categorie;
	  
	  private String pays;

	  
	    private LocalDateTime createdAt;

	    @PrePersist
	    protected void onCreate() {
	        this.createdAt = LocalDateTime.now();
	    }
	  
	   /* @ManyToMany(fetch = FetchType.EAGER)  
	    @JoinTable(name = "notification_paye",
	               joinColumns = @JoinColumn(name = "notification_id"),
	               inverseJoinColumns = @JoinColumn(name = "paye_id"))
	    private Set<Pays> Payes = new HashSet<>();*/

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
	
	

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
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

	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notification(Long id, String titre, String photo, String description, String categorie, String pays,
			LocalDateTime createdAt) {
		super();
		this.id = id;
		this.titre = titre;
		this.photo = photo;
		this.description = description;
		this.categorie = categorie;
		this.pays = pays;
		this.createdAt = createdAt;
	}


	  
}
