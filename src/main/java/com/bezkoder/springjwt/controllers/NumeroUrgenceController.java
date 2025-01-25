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
import com.bezkoder.springjwt.models.NumeroUrgence;
import com.bezkoder.springjwt.repository.NumeroUrgenceRepository;

@RestController
@RequestMapping("/api/auth/numUrgence")
@CrossOrigin(origins = "*", maxAge = 3600)
public class NumeroUrgenceController {

	@Autowired
    private NumeroUrgenceRepository numeroUrgenceRepository;
	
	  @GetMapping
	  public List<NumeroUrgence> getAll() {
		return  numeroUrgenceRepository.findAll();
	  }
	
	    @PostMapping
	    public NumeroUrgence saveNumeroUrgence(@RequestBody NumeroUrgence numeroUrgence) {
	        return numeroUrgenceRepository.save(numeroUrgence);
	    }
	    
	    @PutMapping("/numur/{id}")
	    public ResponseEntity<NumeroUrgence> updateNumUrgence(
	            @PathVariable Long id, @RequestBody NumeroUrgence updatedUrgence) {
	        return numeroUrgenceRepository.findById(id)
	                .map(urgence -> {
	                    // Mettre à jour les champs nécessaires
	                    urgence.setTitre(updatedUrgence.getTitre());
	                    urgence.setNum(updatedUrgence.getNum());
	                    urgence.setPays(updatedUrgence.getPays());
	                    urgence.setDescription(updatedUrgence.getDescription());
	                    urgence.setPhoto(updatedUrgence.getPhoto());
	                    // Ajoutez d'autres champs à mettre à jour selon vos besoins
 
	                    // Sauvegarder les modifications
	                    NumeroUrgence savedUrgence = numeroUrgenceRepository.save(urgence);
	                    return ResponseEntity.ok(savedUrgence);
	                })
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	   /* @GetMapping("/{id}")
	    public User getUserById(@PathVariable Long id) {
	        Optional<User> user = numeroUrgenceRepository.getUserById(id);
	        return user.orElse(null);
	    }*/

	    @GetMapping("/numurs/{id}")
	    public ResponseEntity<NumeroUrgence> getNumUrgenceById(@PathVariable Long id) {
	        Optional<NumeroUrgence> numUrgence = numeroUrgenceRepository.findById(id);
 
	        if (numUrgence.isPresent()) {
	            return ResponseEntity.ok(numUrgence.get());
	        } else {
	            return ResponseEntity.notFound().build();  // Retourner 404 si l'ID n'existe pas
	        }
	    }

	    @DeleteMapping("/numurge/{id}")
	    public Map<String, Boolean> deleteNumUrgence(@PathVariable(value = "id") Long numurgenceId) {
	        Optional<NumeroUrgence> numeroUrgenceOptional = numeroUrgenceRepository.findById(numurgenceId);
	        if (numeroUrgenceOptional.isPresent()) {
	            numeroUrgenceRepository.delete(numeroUrgenceOptional.get());
 
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
 
	    @GetMapping("/numurgenc")
	    public List<NumeroUrgence> getNumeroUrgenceByCategorie(@RequestParam String categorie) {
	        return numeroUrgenceRepository.findByCategorie(categorie);
	    }

}
