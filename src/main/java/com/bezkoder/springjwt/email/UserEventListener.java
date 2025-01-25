package com.bezkoder.springjwt.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.bezkoder.springjwt.models.User;

@Component
public class UserEventListener {

    @Autowired
    private EmailService emailService;

    @EventListener
    public void handleUserRegisteredEvent(UserRegisteredEvent event) {
        User user = event.getUser();
        // Envoyer un e-mail à l'admin
        emailService.sendSimpleMessage(
            "admin@lesexpats.fr", 
            "Nouvelle inscription utilisateur",
            "Un nouvel utilisateur s'est inscrit : " + user.getEmail());
    }

    @EventListener
    public void handleUserApprovedEvent(UserApprovedEvent event) {
        User user = event.getUser();
        // Envoyer un e-mail de confirmation à l'utilisateur
        emailService.sendSimpleMessage(
            user.getEmail(),
            "Compte approuvé",
            "Votre compte a été approuvé !");
    }
}
