package com.bezkoder.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.Favorite;

@RestController
@RequestMapping("/api/auth/favorites")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/add")
    public ResponseEntity<Favorite> addFavorite(@RequestParam Long userId, @RequestParam Long proRoleId) {
        Favorite favorite = favoriteService.addFavorite(userId, proRoleId);
        return ResponseEntity.status(HttpStatus.CREATED).body(favorite);
    }
    @DeleteMapping("/remove")
    public ResponseEntity<Void> removeFavorite(@RequestParam Long userId, @RequestParam Long proRoleId) {
        favoriteService.removeFavorite(userId, proRoleId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Favorite>> getFavoritesByUser(@PathVariable Long userId) {
        List<Favorite> favorites = favoriteService.getFavoritesByUser(userId);
        return ResponseEntity.ok(favorites);
    }
}
