package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Transactional
    @Scheduled(cron = "0 0 0 * * ?")  // 00:00 tous les jours
    public void deleteOldNotifications() {
        LocalDateTime thirtyDaysAgo = LocalDateTime.now().minusDays(30);
        notificationRepository.deleteByCreatedAtBefore(thirtyDaysAgo);
        System.out.println("Suppression des notifications plus vieilles que 30 jours...");
    }

/*
    // Marquer cette méthode comme transactionnelle
    @Transactional
    @Scheduled(cron = "0 * * * * ?")  // Toutes les minutes
    public void deleteOldNotifications() {
        LocalDateTime oneMinuteAgo = LocalDateTime.now().minusMinutes(1);
        notificationRepository.deleteByCreatedAtBefore(oneMinuteAgo);
        System.out.println("Suppression des notifications plus vieilles que 1 minute...");
    }*/
}