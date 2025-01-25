package com.bezkoder.springjwt.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bezkoder.springjwt.models.ProRole;
import com.bezkoder.springjwt.models.Produit;
import com.bezkoder.springjwt.models.ProduitDTO;
import com.bezkoder.springjwt.repository.ProRoleRepository;
import com.bezkoder.springjwt.repository.ProduitRepository;
import com.bezkoder.springjwt.security.ResourceNotFoundException;

@Service
public class ProduitService {

	   @Autowired
	    private ProduitRepository produitRepository;
	
	    
	    @Autowired
	    private ProRoleRepository proRoleRepository;
	    
	    
	    @Transactional
	    public Produit addProduit1(Produit produit, Long proRoleId) {
	        ProRole proRole = proRoleRepository.findById(proRoleId)
	                .orElseThrow(() -> new RuntimeException("ProRole not found"));

	        // Associer le ProRole au produit
	        produit.setProRole(proRole);

	        // Sauvegarder le produit
	        return produitRepository.save(produit);
	    }
	    
	    @Transactional
	    public Produit addProduit(ProduitDTO produitDTO, Long proRoleId) {
	        ProRole proRole = proRoleRepository.findById(proRoleId)
	                .orElseThrow(() -> new ResourceNotFoundException("ProRole not found"));


	        Produit produit = new Produit();
	        produit.setNom(produitDTO.getNom());
	        produit.setImage(produitDTO.getImage());
	        produit.setDescription(produitDTO.getDescription());
	        produit.setPrix(produitDTO.getPrix());
	        produit.setProRole(proRole);

	    
	        return produitRepository.save(produit);
	    }
	    @Transactional
	    public Produit updateProduit(Long produitId, ProduitDTO produitDTO) {
	        Produit produit = produitRepository.findById(produitId)
	                .orElseThrow(() -> new ResourceNotFoundException("Produit not found"));

	        // Mettez à jour les champs nécessaires
	        produit.setNom(produitDTO.getNom());
	        produit.setImage(produitDTO.getImage());
	        produit.setDescription(produitDTO.getDescription());
	        produit.setPrix(produitDTO.getPrix());

	        // Enregistrez le produit mis à jour
	        return produitRepository.save(produit);
	    }
	    
	    public List<Produit> getsByProRoleId(Long proId) {
	        return produitRepository.findByProRoleId(proId);
	    }
	    
	    public List<Produit> getProduitsByProRoleId(Long proId) {
	        return produitRepository.findByProRoleId(proId); // Appel à la méthode du repository
	    }
}
