package com.bezkoder.springjwt.email;

import com.bezkoder.springjwt.models.User;

public class UserRegisteredEvent {
    private final User user;

    public UserRegisteredEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}