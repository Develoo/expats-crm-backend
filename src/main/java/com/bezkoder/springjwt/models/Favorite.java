package com.bezkoder.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;

    @ManyToOne
    @JoinColumn(name = "pro_role_id")
    private ProRole proRole;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public ProRole getProRole() {
		return proRole;
	}

	public void setProRole(ProRole proRole) {
		this.proRole = proRole;
	}

	public Favorite(Long id, UserRole userRole, ProRole proRole) {
		super();
		this.id = id;
		this.userRole = userRole;
		this.proRole = proRole;
	}

	public Favorite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
