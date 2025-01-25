package com.bezkoder.springjwt.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bezkoder.springjwt.models.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
	
	 // Méthode pour supprimer les notifications plus vieilles que 30 jours
    void deleteByCreatedAtBefore(LocalDateTime dateTime);

    List<Notification> findByCategorie(String categorie);
    
}
