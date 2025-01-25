package com.bezkoder.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Favorite;
import com.bezkoder.springjwt.models.ProRole;
import com.bezkoder.springjwt.models.UserRole;
import com.bezkoder.springjwt.repository.FavoriteRepository;
import com.bezkoder.springjwt.repository.ProRoleRepository;
import com.bezkoder.springjwt.repository.UserRoleRepository;
import com.bezkoder.springjwt.security.ResourceNotFoundException;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private ProRoleRepository proRoleRepository;

    public Favorite addFavorite(Long userId, Long proRoleId) {
        UserRole userRole = userRoleRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("UserRole not found"));

        ProRole proRole = proRoleRepository.findById(proRoleId)
            .orElseThrow(() -> new ResourceNotFoundException("ProRole not found"));

        Favorite favorite = new Favorite();
        favorite.setUserRole(userRole);
        favorite.setProRole(proRole);

        return favoriteRepository.save(favorite);
    }

    public void removeFavorite(Long userId, Long proRoleId) {
        UserRole userRole = userRoleRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("UserRole not found"));

        ProRole proRole = proRoleRepository.findById(proRoleId)
            .orElseThrow(() -> new ResourceNotFoundException("ProRole not found"));

        Favorite favorite = favoriteRepository.findByUserRoleAndProRole(userRole, proRole)
            .orElseThrow(() -> new ResourceNotFoundException("Favorite not found"));

        favoriteRepository.delete(favorite);
    }

    public List<Favorite> getFavoritesByUser(Long userId) {
        UserRole userRole = userRoleRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("UserRole not found"));

        return favoriteRepository.findByUserRole(userRole);
    }
}
