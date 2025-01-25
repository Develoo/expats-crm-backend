package com.bezkoder.springjwt.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int stars;
    
    @Lob
    private String content;
    
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;

    @ManyToOne
    @JoinColumn(name = "proRole_id")
    @JsonBackReference
    private ProRole proRole;
    
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Rating() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }


    public String getContent() {
        return content;
    }


	public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

	public Rating(Long id, int stars, String content, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.stars = stars;
		this.content = content;
		this.createdAt = createdAt;
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

	public Rating(Long id, int stars, String content, LocalDateTime createdAt, UserRole userRole, ProRole proRole) {
		super();
		this.id = id;
		this.stars = stars;
		this.content = content;
		this.createdAt = createdAt;
		this.userRole = userRole;
		this.proRole = proRole;
	}






}

