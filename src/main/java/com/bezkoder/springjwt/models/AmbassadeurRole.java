package com.bezkoder.springjwt.models;

import javax.persistence.Entity;

@Entity
public class AmbassadeurRole extends User {
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
