package com.bezkoder.springjwt.controllers;

import java.util.Arrays;
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
import com.bezkoder.springjwt.models.Deal;
import com.bezkoder.springjwt.models.DealDTO;
import com.bezkoder.springjwt.models.ProRole;
import com.bezkoder.springjwt.repository.DealRepository;
import com.bezkoder.springjwt.repository.ProRoleRepository;

@RestController
@RequestMapping("/api/auth/deal")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DealController {

	@Autowired
    private DealRepository dealRepository;
	
	private final ProRoleRepository proRoleRepository;
	
	   @Autowired
	    private DealService dealService; 
	
	  @GetMapping
	  public List<Deal> getAll() {
	 
		return  dealRepository.findAll();
	  }
	  @GetMapping("/pro/villes/{nomVilles}")
	  public List<Deal> getDealByVillesProRol(@PathVariable String nomVilles) {
	      // Diviser la chaîne de villes par la virgule pour obtenir un tableau ou une liste
	      String[] villesArray = nomVilles.split(",");

	      // Utiliser la méthode de recherche avec plusieurs villes (vous pouvez adapter cette partie en fonction de votre repository)
	      return dealRepository.findByProRole_VilleIn(Arrays.asList(villesArray));
	  }

	// Recherche des ProRoles en fonction des catégories (et non les Categorie directement)
	    @GetMapping("/pro/categories/{nomCategories}")
	    public List<Deal> getProRolesByCategories(@PathVariable String nomCategories) {
	        // Diviser la chaîne de catégories par la virgule pour obtenir un tableau ou une liste
	        String[] categorieArray = nomCategories.split(",");

	        // Utiliser la méthode de recherche avec plusieurs catégories (à adapter à votre repository)
	        return dealRepository.findByProRole_CategorieIn(Arrays.asList(categorieArray));
	    }
	    
	    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
	  		public Optional<Deal> getDealById(@PathVariable Long id){
	  			return dealRepository.findById(id);
	  		}


	    @GetMapping("/pro/{proId}")
	    public ResponseEntity<List<Deal>> getDealByProRoleId(@PathVariable Long proId) {
	        List<Deal> deals = dealService.getDealsByProRoleId(proId);
	        return ResponseEntity.ok(deals);
	    }
	    
	    @PostMapping("/{proRoleId}")
	    public ResponseEntity<Deal> createDeal(@RequestBody DealDTO dealDTO, @PathVariable Long proRoleId) {
	    	Deal createdDeal = dealService.addDeal(dealDTO, proRoleId);
	        return ResponseEntity.ok(createdDeal);
	    }
	    
	    
	   /* @PutMapping("/{dealId}")
	    public ResponseEntity<Deal> updateDeal(@PathVariable Long dealId, @RequestBody DealDTO dealDTO) {
	        Deal updatedDeal = dealService.updateDeal(dealId, dealDTO);
	        return ResponseEntity.ok(updatedDeal);
	    }*/
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deletedeal(@PathVariable Long id) {
	
	        dealRepository.deleteById(id);
	        return ResponseEntity.status(HttpStatus.OK).body("Deal supprimé avec succès");
	    }

	 // Endpoint pour obtenir les deals actifs
	    @GetMapping("/deals/Actif")
	    public List<Deal> getDealsActif() {
	        return dealRepository.findByEtat("Actif");
	    }
	 // Endpoint pour obtenir les deals actifs
	    @GetMapping("/deals/En attente")
	    public List<Deal> getDealsEnattente() {
	        return dealRepository.findByEtat("En attente");
	    }
	 // Endpoint pour obtenir les deals actifs
	    @GetMapping("/deals/Refuse")
	    public List<Deal> getDealsRefusé() {
	        return dealRepository.findByEtat("Refusé");
	    }

	   /* @PutMapping("/etatdeals/{id}")
	    public Deal updateDealEtat(@PathVariable Long id, @RequestBody Deal deal) {
	        Optional<Deal> optionalDeal = dealRepository.findById(id);
	        if (optionalDeal.isPresent()) {
	            Deal existingUser = optionalDeal.get();
	            existingUser.setEtat(deal.getEtat());
	            return dealRepository.save(existingUser);
	        }
	        return null;
	    }*/
	    
	    public DealController(DealRepository dealRepository, ProRoleRepository proRoleRepository) {
	        this.dealRepository = dealRepository;
	        this.proRoleRepository = proRoleRepository;
	    }
	    
	    @PutMapping("/update/{id}")
	    public ResponseEntity<Deal> updateDeal(@PathVariable Long id, @RequestBody DealDTO dealDTO) {
	        Optional<Deal> optionalDeal = dealRepository.findById(id);
	        if (optionalDeal.isPresent()) {
	            Deal deal = optionalDeal.get();
	            
	            // Mettre à jour les champs de Deal avec les valeurs de DealDTO
	           /* deal.setNom(dealDTO.getNom());
	            deal.setDescription(dealDTO.getDescription());
	            deal.setImg(dealDTO.getImg());
	            deal.setDate_debut(dealDTO.getDate_debut());
	            deal.setDate_expir(dealDTO.getDate_expir());*/
	            deal.setEtat(dealDTO.getEtat());
	            
	            // Associez ProRole si `proRoleId` est fourni
	            if (dealDTO.getProRoleId() != null) {
	                Optional<ProRole> optionalProRole = proRoleRepository.findById(dealDTO.getProRoleId());
	                optionalProRole.ifPresent(deal::setProRole);
	            }
	            
	            // Sauvegardez les changements
	            Deal updatedDeal = dealRepository.save(deal);
	            return ResponseEntity.ok(updatedDeal);
	        }
	        return ResponseEntity.notFound().build();
	    }
	    
	   
	    
}
