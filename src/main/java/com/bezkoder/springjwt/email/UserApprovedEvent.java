package com.bezkoder.springjwt.email;

import com.bezkoder.springjwt.models.User;

public class UserApprovedEvent {
    private final User user;

    public UserApprovedEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}