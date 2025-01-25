package com.bezkoder.springjwt.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.UserLangue;
import com.bezkoder.springjwt.models.UserLangueDTO;
import com.bezkoder.springjwt.models.UserLangueResponseDTO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/userlangue")
public class UserLangueController {

    @Autowired
    private UserLangueService userLangueService;

    @PutMapping("/{id}")
    public ResponseEntity<UserLangue> editUserLangue(@PathVariable Long id, @RequestBody UserLangueDTO userLangueDTO) {
        UserLangue updatedUserLangue = userLangueService.editUserLangue(id, userLangueDTO);
        return ResponseEntity.ok(updatedUserLangue);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserLangue> getUserLangue(@PathVariable Long id) {
        UserLangue userLangue = userLangueService.getUserLangueById(id);
        return ResponseEntity.ok(userLangue);
    }
    
    @GetMapping("/byUserRole/{userRoleId}")
    public ResponseEntity<List<UserLangueResponseDTO>> getUserLanguesByUserRole(@PathVariable Long userRoleId) {
        List<UserLangue> userLangues = userLangueService.getUserLanguesByUserRoleId(userRoleId);
        List<UserLangueResponseDTO> responseDTOs = userLangues.stream()
                .map(userLangue -> {
                    UserLangueResponseDTO dto = new UserLangueResponseDTO();
                    dto.setLangueNom(userLangue.getLangue().getNom());
                    dto.setUser_id(userLangue.getUser().getId());
                    dto.setNv_comp(userLangue.getNv_comp());
                    return dto;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOs);
    }
    @PutMapping("/byUserRole/{userRoleId}")
    public ResponseEntity<List<UserLangue>> editOrAddUserLanguesByUserRole(@PathVariable Long userRoleId, @RequestBody List<UserLangueDTO> userLangueDTOs) {
        List<UserLangue> updatedUserLangues = userLangueService.editOrAddUserLangueByUserRole(userRoleId, userLangueDTOs);
        return ResponseEntity.ok(updatedUserLangues);
    }



}
