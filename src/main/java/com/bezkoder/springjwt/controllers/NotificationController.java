package com.bezkoder.springjwt.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bezkoder.springjwt.models.Notification;
import com.bezkoder.springjwt.repository.NotificationRepository;

@RestController
@RequestMapping("/api/auth/notifications")
@CrossOrigin(origins = "*", maxAge = 3600)
public class NotificationController {

	
	@Autowired
    private NotificationRepository notificationRepository;
	
	
	@GetMapping
	  public List<Notification> getAll() {
		return  notificationRepository.findAll();
	  }
	
    @PostMapping
    public Notification saveNotification(@RequestBody Notification notification) {
        return notificationRepository.save(notification);
    }
	
    @PutMapping("/notif/{id}")
    public ResponseEntity<Notification> updateNotification(
            @PathVariable Long id, @RequestBody Notification updatedNotification) {
        return notificationRepository.findById(id)
                .map(notification -> {
                    // Mettre à jour les champs nécessaires
                	notification.setTitre(updatedNotification.getTitre());
                	notification.setCategorie(updatedNotification.getCategorie());
                	notification.setPays(updatedNotification.getPays());
                	notification.setDescription(updatedNotification.getDescription());
                	notification.setPhoto(updatedNotification.getPhoto());
                    // Ajoutez d'autres champs à mettre à jour selon vos besoins
 
                    // Sauvegarder les modifications
                    Notification savedNotification = notificationRepository.save(notification);
                    return ResponseEntity.ok(savedNotification);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/notifs/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
        Optional<Notification> notification = notificationRepository.findById(id);
 
        if (notification.isPresent()) {
            return ResponseEntity.ok(notification.get());
        } else {
            return ResponseEntity.notFound().build();  // Retourner 404 si l'ID n'existe pas
        }
    }
    @DeleteMapping("/notifica/{id}")
    public Map<String, Boolean> deleteNotification(@PathVariable(value = "id") Long notificationId) {
        Optional<Notification> notificationOptional = notificationRepository.findById(notificationId);
        if (notificationOptional.isPresent()) {
        	notificationRepository.delete(notificationOptional.get());
 
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
        } else {
            // Gérer le cas où le numéro d'urgence n'est pas trouvé
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.FALSE);
            return response; // Vous pouvez aussi renvoyer une réponse différente ou lever une exception
        }
    }
    @GetMapping("/notificationss")
    public List<Notification> getNotificationsByCategorie(@RequestParam String categorie) {
        return notificationRepository.findByCategorie(categorie);
    }
}
