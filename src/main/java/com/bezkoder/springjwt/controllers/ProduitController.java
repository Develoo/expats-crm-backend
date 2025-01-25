package com.bezkoder.springjwt.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.Blog;
import com.bezkoder.springjwt.models.Produit;
import com.bezkoder.springjwt.models.ProduitDTO;
import com.bezkoder.springjwt.repository.ProduitRepository;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/produit")
public class ProduitController {

		
	   @Autowired
	    private ProduitService produitService; 

	   @Autowired
	    private ProduitRepository produitRepository; 
	   
	    @PostMapping("/{proRoleId}")
	    public ResponseEntity<Produit> createProduit(@RequestBody ProduitDTO produitDTO, @PathVariable Long proRoleId) {
	        Produit createdProduit = produitService.addProduit(produitDTO, proRoleId);
	        return ResponseEntity.ok(createdProduit);
	    }
	    
	    @PostMapping("/add/{proRoleId}")
	    public ResponseEntity<Produit> createProduit(@RequestBody Produit produit, @PathVariable Long proRoleId) {
	        Produit savedProduit = produitService.addProduit1(produit, proRoleId);
	        return ResponseEntity.ok(savedProduit);
	    }

	    @GetMapping("/pro/{proId}")
	    public ResponseEntity<List<Produit>> getProduitByProRoleId(@PathVariable Long proId) {
	        List<Produit> produits = produitService.getProduitsByProRoleId(proId);
	        return ResponseEntity.ok(produits);
	    }

	    
	    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
	  		public Optional<Produit> getProduitById(@PathVariable Long id){
	  			return produitRepository.findById(id);
	  		}
	    
	    @PutMapping("/{produitId}")
	    public ResponseEntity<Produit> updateProduit(@PathVariable Long produitId, @RequestBody ProduitDTO produitDTO) {
	        Produit updatedProduit = produitService.updateProduit(produitId, produitDTO);
	        return ResponseEntity.ok(updatedProduit);
	    }
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteProduit(@PathVariable Long id) {
	
	        produitRepository.deleteById(id);
	        return ResponseEntity.status(HttpStatus.OK).body("Produit supprimé avec succès");
	    }


}
