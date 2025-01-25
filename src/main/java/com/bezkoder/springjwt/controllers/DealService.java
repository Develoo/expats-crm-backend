package com.bezkoder.springjwt.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bezkoder.springjwt.models.Deal;
import com.bezkoder.springjwt.models.DealDTO;
import com.bezkoder.springjwt.models.ProRole;
import com.bezkoder.springjwt.models.Produit;
import com.bezkoder.springjwt.models.ProduitDTO;
import com.bezkoder.springjwt.repository.DealRepository;
import com.bezkoder.springjwt.repository.ProRoleRepository;
import com.bezkoder.springjwt.security.ResourceNotFoundException;

@Service
public class DealService {

	   @Autowired
	    private DealRepository dealRepository;
	
	    
	    @Autowired
	    private ProRoleRepository proRoleRepository;
	
    public List<Deal> getDealsByProRoleId(Long proId) {
        return dealRepository.findByProRoleId(proId); // Appel à la méthode du repository
    }
    
    @Transactional
    public Deal addDeal(DealDTO dealDTO, Long proRoleId) {
        ProRole proRole = proRoleRepository.findById(proRoleId)
                .orElseThrow(() -> new ResourceNotFoundException("ProRole not found"));


        Deal deal = new Deal();
        deal.setNom(dealDTO.getNom());
        deal.setImg(dealDTO.getImg());
        deal.setDescription(dealDTO.getDescription());
        deal.setDate_debut(dealDTO.getDate_debut());
        deal.setDate_expir(dealDTO.getDate_expir());
        deal.setEtat("En attente");
        deal.setProRole(proRole);

    
        return dealRepository.save(deal);
    }
    
    public Deal updateDeal(Long dealId, DealDTO dealDTO) {
        Deal deal = dealRepository.findById(dealId)
                .orElseThrow(() -> new ResourceNotFoundException("deal not found"));

        // Mettez à jour les champs nécessaires
        deal.setNom(dealDTO.getNom());
        deal.setImg(dealDTO.getImg());
        deal.setDescription(dealDTO.getDescription());
        deal.setDate_debut(dealDTO.getDate_debut());
        deal.setDate_expir(dealDTO.getDate_expir());


        // Enregistrez le produit mis à jour
        return dealRepository.save(deal);
    }
    
    
}
