package com.bezkoder.springjwt.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalTime;

@Entity
public class OpeningHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dayOfWeek;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private String ferme;

    @ManyToOne
    @JoinColumn(name = "pro_role_id")
    @JsonBackReference
    private ProRole proRole;

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public String getFerme() {
        return ferme;
    }

    public void setFerme(String ferme) {
        this.ferme = ferme;
    }

    public ProRole getProRole() {
        return proRole;
    }

    public void setProRole(ProRole proRole) {
        this.proRole = proRole;
    }
}
