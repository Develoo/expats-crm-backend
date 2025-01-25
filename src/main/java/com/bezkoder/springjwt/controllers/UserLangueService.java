package com.bezkoder.springjwt.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.Langue;
import com.bezkoder.springjwt.models.UserLangue;
import com.bezkoder.springjwt.models.UserLangueDTO;
import com.bezkoder.springjwt.models.UserRole;
import com.bezkoder.springjwt.repository.LangueRepository;
import com.bezkoder.springjwt.repository.UserLangueRepository;
import com.bezkoder.springjwt.repository.UserRoleRepository;

@Service
public class UserLangueService {

    @Autowired
    private UserLangueRepository userLangueRepository;

    @Autowired
    private LangueRepository langueRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public UserLangue editUserLangue(Long id, UserLangueDTO userLangueDTO) {
        // Find existing UserLangue by ID
        UserLangue userLangue = userLangueRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("UserLangue not found"));

        // Update fields
        if (userLangueDTO.getLangueNom() != null) {
            Langue langue = langueRepository.findByNom(userLangueDTO.getLangueNom());
            if (langue != null) {
                userLangue.setLangue(langue);
            }
        }
        
        if (userLangueDTO.getUser_id() > 0) {
            UserRole user = userRoleRepository.findById(userLangueDTO.getUser_id())
                    .orElseThrow(() -> new EntityNotFoundException("User not found"));
            userLangue.setUser(user);
        }

        if (userLangueDTO.getNv_comp() != null) {
            userLangue.setNv_comp(userLangueDTO.getNv_comp());
        }

        // Save updated UserLangue
        return userLangueRepository.save(userLangue);
    }
    
    public UserLangue getUserLangueById(Long id) {
        return userLangueRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("UserLangue not found"));
    }
    
    public List<UserLangue> getUserLanguesByUserRoleId(Long userRoleId) {
        return userLangueRepository.findByUserId(userRoleId);
    }

    public List<UserLangue> editOrAddUserLangueByUserRole(Long userRoleId, List<UserLangueDTO> userLangueDTOs) {
        List<UserLangue> updatedUserLangues = new ArrayList<>();

        // Récupérer toutes les langues existantes pour cet utilisateur
        List<UserLangue> existingUserLangues = userLangueRepository.findByUserId(userRoleId);

        for (UserLangueDTO userLangueDTO : userLangueDTOs) {
            // Vérifiez si une UserLangue avec le nom de langue existe déjà
            UserLangue existingUserLangue = existingUserLangues.stream()
                    .filter(ul -> ul.getLangue().getNom().equals(userLangueDTO.getLangueNom()))
                    .findFirst()
                    .orElse(null);

            if (existingUserLangue != null) {
                // Mise à jour de l'entrée existante
                existingUserLangue.setNv_comp(userLangueDTO.getNv_comp());
                updatedUserLangues.add(userLangueRepository.save(existingUserLangue));
            } else {
                // Si aucune entrée n'existe, créer une nouvelle UserLangue
                UserLangue newUserLangue = new UserLangue();
                newUserLangue.setUser(userRoleRepository.findById(userRoleId)
                    .orElseThrow(() -> new EntityNotFoundException("UserRole non trouvé")));
                
                Langue nouvelleLangue = langueRepository.findByNom(userLangueDTO.getLangueNom());
                if (nouvelleLangue == null) {
                    throw new EntityNotFoundException("Langue non trouvée pour le nom: " + userLangueDTO.getLangueNom());
                }
                newUserLangue.setLangue(nouvelleLangue);
                newUserLangue.setNv_comp(userLangueDTO.getNv_comp());
                updatedUserLangues.add(userLangueRepository.save(newUserLangue));
            }
        }

        // Vérifiez et supprimez les anciennes UserLangue qui ne sont plus dans la liste
        for (UserLangue existingUserLangue : existingUserLangues) {
            boolean found = userLangueDTOs.stream()
                    .anyMatch(dto -> dto.getLangueNom().equals(existingUserLangue.getLangue().getNom()));
            
            if (!found) {
                userLangueRepository.delete(existingUserLangue);
            }
        }

        return updatedUserLangues;
    }






}
