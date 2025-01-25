package com.bezkoder.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class UserReseauSociaux {

	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @ManyToOne
	    @JoinColumn(name = "user_id", referencedColumnName = "id")
	    @JsonBackReference
	    private User user;
	    
	    @ManyToOne
	    @JoinColumn(name = "reseauSocieau_id", referencedColumnName = "id")
	    @JsonBackReference
	    private ReseauSociaux reseauSociaux;
	    
	    private String lien;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}


		public ReseauSociaux getReseauSociaux() {
			return reseauSociaux;
		}

		public void setReseauSociaux(ReseauSociaux reseauSociaux) {
			this.reseauSociaux = reseauSociaux;
		}

		public String getLien() {
			return lien;
		}

		public void setLien(String lien) {
			this.lien = lien;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public UserReseauSociaux() {
			super();
			// TODO Auto-generated constructor stub
		}

		public UserReseauSociaux(Long id, User user, ReseauSociaux reseauSociaux, String lien) {
			super();
			this.id = id;
			this.user = user;
			this.reseauSociaux = reseauSociaux;
			this.lien = lien;
		}



	
	    
}
