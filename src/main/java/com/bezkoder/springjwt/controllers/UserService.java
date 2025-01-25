package com.bezkoder.springjwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.bezkoder.springjwt.models.CentreInteret;
import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.Langue;
import com.bezkoder.springjwt.models.MarquesPreferees;
import com.bezkoder.springjwt.models.MoyenPayement;
import com.bezkoder.springjwt.models.MoyenPayementDTO;
import com.bezkoder.springjwt.models.OpeningHours;
import com.bezkoder.springjwt.models.OpeningHoursDTO;
import com.bezkoder.springjwt.models.ProRole;
import com.bezkoder.springjwt.models.ProRoleDTO;
import com.bezkoder.springjwt.models.RecherchePlatform;
import com.bezkoder.springjwt.models.ReseauSociaux;
import com.bezkoder.springjwt.models.Role;
import com.bezkoder.springjwt.models.Tags;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.models.UserImage;
import com.bezkoder.springjwt.models.UserLangue;
import com.bezkoder.springjwt.models.UserLangueDTO;
import com.bezkoder.springjwt.models.UserPreferCommuni;
import com.bezkoder.springjwt.models.UserReseauSociaux;
import com.bezkoder.springjwt.models.UserReseauSociauxDTO;
import com.bezkoder.springjwt.models.UserRole;
import com.bezkoder.springjwt.models.UserRoleDTO;
import com.bezkoder.springjwt.models.UserCompagnSouhait;
import com.bezkoder.springjwt.models.UserCompagnSouhaitDTO;
import com.bezkoder.springjwt.repository.CentreInteretRepository;
import com.bezkoder.springjwt.repository.FilesStorageService;
import com.bezkoder.springjwt.repository.FilesStorageServiceImpl;
import com.bezkoder.springjwt.repository.LangueRepository;
import com.bezkoder.springjwt.repository.MarquesPrefereesRepository;
import com.bezkoder.springjwt.repository.MoyenPayementRepository;
import com.bezkoder.springjwt.repository.OpeningHoursRepository;
import com.bezkoder.springjwt.repository.ProRoleRepository;
import com.bezkoder.springjwt.repository.RecherchePlatformRepository;
import com.bezkoder.springjwt.repository.ReseauSociauxRepository;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.repository.UserRoleRepository;
import com.bezkoder.springjwt.repository.UserCompagnSouhaitRepository;
import com.bezkoder.springjwt.repository.UserPreferCommuniRepository;
import com.bezkoder.springjwt.security.ResourceNotFoundException;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

	   @Autowired
	    private UserRepository userRepository;

	   @Autowired
	    private UserRoleRepository userRoleRepository;
	   
	   @Autowired
	    private ProRoleRepository proRoleRepository;
	   
	    @Autowired
	    private RoleRepository roleRepository;

	    @Autowired
	    private PasswordEncoder encoder;

	    @Autowired
	    private LangueRepository langueRepository;
	    
	    @Autowired
	    private ReseauSociauxRepository reseauSociauxRepository;
	    
	    @Autowired
	    private CentreInteretRepository centreInteretRepository;
	    
	    
	    @Autowired
	    private MoyenPayementRepository moyenPayementRepository;
	    
	    
	    @Autowired
	    private OpeningHoursRepository openingHoursRepository;
	    
	    @Autowired
	    private UserCompagnSouhaitRepository userTypeCompagnSouhaitRepository;
	    
	    @Autowired
	    private FilesStorageServiceImpl fileStorageService;
	    
	    @Autowired
	    private MarquesPrefereesRepository marquesPrefereesRepository;
	    
	    @Autowired
	    private RecherchePlatformRepository recherchePlatformRepository;
	    
	    @Autowired
	    private UserPreferCommuniRepository userprefercommunicRepository;
	    
	    
	    @Transactional
	    public List<ProRole> getUsersByRoleProAndCategoryName(String categoryName) {
	        return userRepository.findByRolesNameAndCategorie(ERole.ROLE_PRO, categoryName);
	    }
	    @Transactional
	    public List<ProRole> getUsersByRoleProAndTagsName(String tagsName) {
	        return userRepository.findByRolesNameAndTagsName(ERole.ROLE_PRO, tagsName);
	    }
    @Transactional
    public ProRole createProUser(ProRole proRole) {
        proRole.setPassword(encoder.encode(proRole.getPassword()));

        Role userRoleEntity = roleRepository.findByName(ERole.ROLE_PRO)
                .orElseGet(() -> roleRepository.save(new Role(ERole.ROLE_PRO)));

        proRole.setRoles(Collections.singleton(userRoleEntity));
        proRole.setEtat("En attente");

        return userRepository.save(proRole);
    }
    
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    
   
	
    public Set<Tags> getTagsByProRoleId(Long id) {
        Optional<ProRole> proRoleOptional = proRoleRepository.findById(id);
        return proRoleOptional.map(ProRole::getTags).orElse(new HashSet<>());
    }
    
    
    
    @Transactional
    public User createuserPro(ProRoleDTO proRoleDTO) {
    	
    	ProRole proRole = new ProRole();
       
    	 proRole.setNomentreprise(proRoleDTO.getNomentreprise());
    	 proRole.setUsername(proRoleDTO.getUsername());
    	 proRole.setEmail(proRoleDTO.getEmail());
    	 proRole.setPassword(encoder.encode(proRoleDTO.getPassword()));
    	 proRole.setEtat("Actif");
    	 proRole.setVille(proRoleDTO.getVille());
    	 proRole.setPays(proRoleDTO.getPays());
    	 proRole.setNumtel(proRoleDTO.getNumtel());
    	 proRole.setNumwhats(proRoleDTO.getNumwhats());
    	 proRole.setSecteuractivite(proRoleDTO.getSecteuractivite());
    	 proRole.setDescriptionentre(proRoleDTO.getDescriptionentre());
    	 proRole.setNum_siret(proRoleDTO.getNum_siret());
    	 proRole.setNum_tva(proRoleDTO.getNum_tva());
    	 proRole.setCertif_accred(proRoleDTO.getCertif_accred());
    	 proRole.setSite_web(proRoleDTO.getSite_web());
    	// proRole.setMoy_payem(proRoleDTO.getMoy_payem());
    	 proRole.setLivrai_dispo(proRoleDTO.getLivrai_dispo());
    	 proRole.setFrai_livrais(proRoleDTO.getFrai_livrais());
    	 proRole.setCondit_livrai(proRoleDTO.getCondit_livrai());
    	 proRole.setInteret_compag_mark(proRoleDTO.getInteret_compag_mark());
    	 proRole.setBudg_pub_mensuel(proRoleDTO.getBudg_pub_mensuel());
    	 proRole.setServic_spec_expat(proRoleDTO.getServic_spec_expat());
    	 proRole.setAccept_platf(proRoleDTO.getAccept_platf());
    	 proRole.setRue(proRoleDTO.getRue());
    	 proRole.setVille(proRoleDTO.getVille());
    	 proRole.setCodepostal(proRoleDTO.getCodepostal());
    	 proRole.setLiengooglemap(proRoleDTO.getLiengooglemap());
    	 proRole.setPrenom_pers_cont(proRoleDTO.getPrenom_pers_cont());
    	 proRole.setNom_pers_cont(proRoleDTO.getNom_pers_cont());
    	 proRole.setFoncti_pers_cont(proRoleDTO.getFoncti_pers_cont());
    	 proRole.setEmail_pers_cont(proRoleDTO.getEmail_pers_cont());
    	 proRole.setNum_tel_pers_cont(proRoleDTO.getNum_tel_pers_cont());
    	 proRole.setNum_what_pers_cont(proRoleDTO.getNum_what_pers_cont());
    	 proRole.setPremierparrain(proRoleDTO.getPremierparrain());
    	 proRole.setSecondparrain(proRoleDTO.getSecondparrain());
    	 
    	 
    	 Role userRoleEntity = roleRepository.findByName(ERole.ROLE_PRO)
                 .orElseGet(() -> roleRepository.save(new Role(ERole.ROLE_PRO)));
    	 proRole.setRoles(Collections.singleton(userRoleEntity));
        
    	 
    	 Set<UserReseauSociaux> userReseauSociaux = new HashSet<>();
         for (UserReseauSociauxDTO userReseauSociauxDTO : proRoleDTO.getUserReseauSociaux()) {
             ReseauSociaux reseauSociaux = reseauSociauxRepository.findByNom(userReseauSociauxDTO.getReseauSociauNom());
             if (reseauSociaux == null) {
                 reseauSociaux = new ReseauSociaux();
                 reseauSociaux.setNom(userReseauSociauxDTO.getReseauSociauNom());
                 reseauSociauxRepository.save(reseauSociaux);
             }

             UserReseauSociaux userReseauSociau = new UserReseauSociaux();
             userReseauSociau.setReseauSociaux(reseauSociaux);
             userReseauSociau.setLien(userReseauSociauxDTO.getLien());
             userReseauSociau.setUser(proRole);
             userReseauSociaux.add(userReseauSociau);
         }
     
         proRole.setUserReseauSocieaux(userReseauSociaux);
         
         
       
         // 4. Traiter les types de compagnies souhaitées
       /*  Set<UserCompagnSouhait> userTypeCompagnSouhaits = new HashSet<>();
         for (UserCompagnSouhaitDTO typeCompagnSouhaitDTO : proRoleDTO.getUserTypeCompagnSouhait()) {
             UserCompagnSouhait userTypeCompagnSouhait = new UserCompagnSouhait();
             userTypeCompagnSouhait.setTypecompagnsouhait(typeCompagnSouhaitDTO.getTypecompagnsouhait());
             userTypeCompagnSouhait.setProRole(proRole); 
             userTypeCompagnSouhaits.add(userTypeCompagnSouhait);
         }

         
         userTypeCompagnSouhaitRepository.saveAll(userTypeCompagnSouhaits);
         proRole.getUserTypeCompagnSouhait().addAll(userTypeCompagnSouhaits); */
         
         
      // Ajout des moyens de paiement, si spécifiés dans le DTO
         if (proRoleDTO.getMoyenPayement() != null && !proRoleDTO.getMoyenPayement().isEmpty()) {
             for (MoyenPayementDTO moyenPayementDTO : proRoleDTO.getMoyenPayement()) {
                 MoyenPayement moyenPayement = new MoyenPayement();
                 moyenPayement.setId(moyenPayementDTO.getId());
                 moyenPayement.setNom(moyenPayementDTO.getNom());

                 // Ajout du moyen de paiement au ProRole
                 proRole.getMoyenPayement().add(moyenPayement);

                 // Mise à jour inverse pour la relation bidirectionnelle
                 moyenPayement.getProRoles().add(proRole);
             }
         }
         
      // Ajout des moyens de paiement, si spécifiés dans le DTO
        /* if (proRoleDTO.getUserCompagnSouhait() != null && !proRoleDTO.getUserCompagnSouhait().isEmpty()) {
             for (UserCompagnSouhaitDTO userCompagnSouhaitDTO : proRoleDTO.getUserCompagnSouhait()) {
            	 UserCompagnSouhait userCompagnSouhait = new UserCompagnSouhait();
            	 userCompagnSouhait.setId(userCompagnSouhaitDTO.getId());
            	 userCompagnSouhait.setNom(userCompagnSouhaitDTO.getNom());

                 // Ajout du moyen de paiement au ProRole
                 proRole.getUserCompagnSouhait().add(userCompagnSouhait);

                 // Mise à jour inverse pour la relation bidirectionnelle
                 userCompagnSouhait.getProRoles().add(proRole);
             }
         }*/
         
         
        /* Set<MoyenPayement> moyenPayements = new HashSet<>();
         for (MoyenPayementDTO moyenPayementNom : proRoleDTO.getMoyenPayement()) {
        	 MoyenPayement moyenPayement = moyenPayementRepository.findByNom(moyenPayementNom)
                     .orElseGet(() -> {
                    	 MoyenPayement newMoyenPayement = new MoyenPayement();
                    	 newMoyenPayement.setNom(moyenPayementNom);
                         return moyenPayementRepository.save(newMoyenPayement);
                     });
        	 moyenPayements.add(moyenPayement);
         }
         proRoleDTO.setMoyenPayement(moyenPayements);*/
         
        
        
       /*  Set<OpeningHours> oeningHourss = new HashSet<>();
         for (OpeningHoursDTO oeningHoursDTO : proRoleDTO.getOpeningHours()) {
             OpeningHours openingHours = new OpeningHours();
             openingHours.setDayOfWeek(oeningHoursDTO.getDayOfWeek());
             
             
             openingHours.setOpeningTime(oeningHoursDTO.getOpeningTime());  
             openingHours.setClosingTime(oeningHoursDTO.getClosingTime());  
             
             openingHours.setProRole(proRole); 
             oeningHourss.add(openingHours);
         }

         openingHoursRepository.saveAll(oeningHourss);

         proRole.setOpeningHours(oeningHourss);*/
        
        return proRoleRepository.save(proRole);
    }

    
    @Transactional
    public User createuserProWithPro(ProRoleDTO proRoleDTO) {
    	
    	ProRole proRole = new ProRole();
       
    	 proRole.setNomentreprise(proRoleDTO.getNomentreprise());
    	 proRole.setUsername(proRoleDTO.getUsername());
    	 proRole.setEmail(proRoleDTO.getEmail());
    	 proRole.setPassword(encoder.encode(proRoleDTO.getPassword()));
    	 proRole.setEtat("En attente");
    	 proRole.setTypeEntreprise(proRoleDTO.getTypeEntreprise());
    	 proRole.setSecteuractivite(proRoleDTO.getSecteuractivite());
    	 proRole.setDescriptionentre(proRoleDTO.getDescriptionentre());   
    	 proRole.setRue(proRoleDTO.getRue());    	 
    	 proRole.setVille(proRoleDTO.getVille());    	 
    	 proRole.setCodepostal(proRoleDTO.getCodepostal());   
    	 proRole.setPays(proRoleDTO.getPays());    	 
    	 proRole.setSite_web(proRoleDTO.getSite_web()); 	 
    	 proRole.setFacebook(proRoleDTO.getFacebook()); 
    	 proRole.setInstag(proRoleDTO.getInstag()); 
    	 proRole.setLinkedin(proRoleDTO.getLinkedin()); 	 
    	 proRole.setTwitter(proRoleDTO.getTwitter()); 
    	 proRole.setTiktok(proRoleDTO.getTiktok()); 
    	 proRole.setPrenom_pers_cont(proRoleDTO.getPrenom_pers_cont()); 
    	 proRole.setNom_pers_cont(proRoleDTO.getNom_pers_cont()); 
    	 proRole.setFoncti_pers_cont(proRoleDTO.getFoncti_pers_cont()); 
    	 proRole.setNumtel(proRoleDTO.getNumtel()); 
    	 proRole.setNumwhats(proRoleDTO.getNumwhats()); 
    	 proRole.setNum_tel_pers_cont(proRoleDTO.getNum_tel_pers_cont()); 
    	 proRole.setNum_what_pers_cont(proRoleDTO.getNum_what_pers_cont()); 
    	 
    	 Role userRoleEntity = roleRepository.findByName(ERole.ROLE_PRO)
                 .orElseGet(() -> roleRepository.save(new Role(ERole.ROLE_PRO)));
    	 proRole.setRoles(Collections.singleton(userRoleEntity));
  
        
        return proRoleRepository.save(proRole);
    }
    
   
    @Transactional
    public User updateUserProWithPro(Long userId, ProRoleDTO proRoleDTO) {
        // 1. Chercher l'utilisateur existant par ID
        ProRole existingProRole = proRoleRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé avec l'ID : " + userId));
        // 2. Mettre à jour les champs de l'utilisateur avec les données du DTO
        
        existingProRole.setUsername(proRoleDTO.getUsername());
        existingProRole.setEmail(proRoleDTO.getEmail());
        existingProRole.setEtat(proRoleDTO.getEtat());
        existingProRole.setNumtel(proRoleDTO.getNumtel());
        existingProRole.setNumwhats(proRoleDTO.getNumwhats());
        existingProRole.setSite_web(proRoleDTO.getSite_web());
        existingProRole.setLinkedin(proRoleDTO.getLinkedin());
        existingProRole.setFacebook(proRoleDTO.getFacebook());
        existingProRole.setTwitter(proRoleDTO.getTwitter());
        
        
        existingProRole.setRue(proRoleDTO.getRue());
        existingProRole.setVille(proRoleDTO.getVille());
        existingProRole.setPays(proRoleDTO.getPays());
        existingProRole.setCodepostal(proRoleDTO.getCodepostal());
        existingProRole.setLiengooglemap(proRoleDTO.getLiengooglemap());
        
        
        existingProRole.setNum_siret(proRoleDTO.getNum_siret());
        existingProRole.setNum_tva(proRoleDTO.getNum_tva());
        existingProRole.setCertif_accred(proRoleDTO.getCertif_accred());
        
        
        existingProRole.setNom_pers_cont(proRoleDTO.getNom_pers_cont());
        existingProRole.setPrenom_pers_cont(proRoleDTO.getPrenom_pers_cont());
        existingProRole.setFoncti_pers_cont(proRoleDTO.getFoncti_pers_cont());
        existingProRole.setNum_tel_pers_cont(proRoleDTO.getNum_tel_pers_cont());
        existingProRole.setNum_what_pers_cont(proRoleDTO.getNum_what_pers_cont());
        existingProRole.setEmail_pers_cont(proRoleDTO.getEmail_pers_cont());
        
        
        
        existingProRole.setServic_spec_expat(proRoleDTO.getServic_spec_expat());
        
        
        existingProRole.setPremierparrain(proRoleDTO.getPremierparrain());
        existingProRole.setSecondparrain(proRoleDTO.getSecondparrain());
        
        
     // 3. Mise à jour des moyens de paiement
        if (proRoleDTO.getMoyenPayement() != null && !proRoleDTO.getMoyenPayement().isEmpty()) {
            // Clear les anciens moyens de paiement
            existingProRole.getMoyenPayement().clear();
 
            // Ajout des nouveaux moyens de paiement
            for (MoyenPayementDTO moyenPayementDTO : proRoleDTO.getMoyenPayement()) {
                MoyenPayement moyenPayement = new MoyenPayement();
                moyenPayement.setId(moyenPayementDTO.getId());
                moyenPayement.setNom(moyenPayementDTO.getNom());
 
                // Ajout dans la collection de moyens de paiement du ProRole
                existingProRole.getMoyenPayement().add(moyenPayement);
 
                // Mise à jour inverse pour la relation bidirectionnelle
                moyenPayement.getProRoles().add(existingProRole);
            }
 
            // Déboguer les données après la mise à jour de la relation ManyToMany
            System.out.println("Après mise à jour de moyenPayement:");
            existingProRole.getMoyenPayement().forEach(moyenPayement -> System.out.println(moyenPayement));
        }
        
        
        if (proRoleDTO.getUserCompagnSouhait() != null && !proRoleDTO.getUserCompagnSouhait().isEmpty()) {
            // Clear les anciens types de compagnies souhaités
            existingProRole.getUserCompagnSouhait().clear();

            // Ajout des nouveaux types de compagnies souhaités
            for (UserCompagnSouhaitDTO userTypeCompagnSouhaitDTO : proRoleDTO.getUserCompagnSouhait()) {
            	UserCompagnSouhait userTypeCompagnSouhait = new UserCompagnSouhait();
                userTypeCompagnSouhait.setId(userTypeCompagnSouhaitDTO.getId());
                userTypeCompagnSouhait.setNom(userTypeCompagnSouhaitDTO.getNom());

                // Ajout dans la collection de types de compagnies souhaités du ProRole
                existingProRole.getUserCompagnSouhait().add(userTypeCompagnSouhait);

                // Mise à jour inverse pour la relation bidirectionnelle
                userTypeCompagnSouhait.getProRoles().add(existingProRole);
            }

            // Déboguer les données après la mise à jour de la relation ManyToMany
            System.out.println("Après mise à jour de userTypeCompagnSouhait:");
            existingProRole.getUserCompagnSouhait().forEach(userTypeCompagnSouhait -> System.out.println(userTypeCompagnSouhait));
        }

        
        
        
        
        existingProRole.setLivrai_dispo(proRoleDTO.getLivrai_dispo());
        existingProRole.setFrai_livrais(proRoleDTO.getFrai_livrais());
        existingProRole.setCondit_livrai(proRoleDTO.getCondit_livrai());
        
        
        existingProRole.setInteret_compag_mark(proRoleDTO.getInteret_compag_mark());
        
        
        
        existingProRole.setBudg_pub_mensuel(proRoleDTO.getBudg_pub_mensuel());
        
        
        
        existingProRole.setCommentperso(proRoleDTO.getCommentperso());
        
        
        existingProRole.setSecteuractivite(proRoleDTO.getSecteuractivite());
        existingProRole.setCategorie(proRoleDTO.getCategorie());
        
        /*
        existingProRole.setPhoto(proRoleDTO.getPhoto());
        
        
        
        
        
        

        
        existingProRole.setInstag(proRoleDTO.getInstag());
        
        
        existingProRole.setTiktok(proRoleDTO.getTiktok());

       

        
        
        
        existingProRole.setMoy_payem(proRoleDTO.getMoy_payem());

        existingProRole.setLivrai_dispo(proRoleDTO.getLivrai_dispo());
        existingProRole.setFrai_livrais(proRoleDTO.getFrai_livrais());
        
        
        existingProRole.setInteret_compag_mark(proRoleDTO.getInteret_compag_mark());
        
        
        existingProRole.setNomentreprise(proRoleDTO.getNomentreprise());
        existingProRole.setSecteuractivite(proRoleDTO.getSecteuractivite());
        existingProRole.setDescriptionentre(proRoleDTO.getDescriptionentre());

        

        
        existingProRole.setUsername(proRoleDTO.getUsername());
        
        existingProRole.setPassword(encoder.encode(proRoleDTO.getPassword()));
        
        if (proRoleDTO.getOpeningHours() != null && !proRoleDTO.getOpeningHours().isEmpty()) {
            existingProRole.getOpeningHours().clear();  

            
            for (OpeningHoursDTO openingHoursDTO : proRoleDTO.getOpeningHours()) {
                OpeningHours openingHours = new OpeningHours();
                openingHours.setDayOfWeek(openingHoursDTO.getDayOfWeek());

                
                openingHours.setOpeningTime(openingHoursDTO.getOpeningTime());
                openingHours.setClosingTime(openingHoursDTO.getClosingTime());

                openingHours.setFerme(openingHoursDTO.getFerme());
                openingHours.setProRole(existingProRole);  

                
                existingProRole.getOpeningHours().add(openingHours);  
            }
        }
        
    
        if (proRoleDTO.getUserTypeCompagnSouhait() != null && !proRoleDTO.getUserTypeCompagnSouhait().isEmpty()) {
     existingProRole.getUserTypeCompagnSouhait().clear(); 

     
     for (UserCompagnSouhaitDTO typeCompagnSouhaitDTO : proRoleDTO.getUserTypeCompagnSouhait()) {
         UserCompagnSouhait userTypeCompagnSouhait = new UserCompagnSouhait();
         
         userTypeCompagnSouhait.setTypecompagnsouhait(typeCompagnSouhaitDTO.getTypecompagnsouhait());
         userTypeCompagnSouhait.setProRole(existingProRole); 
         
         
         existingProRole.getUserTypeCompagnSouhait().add(userTypeCompagnSouhait);
     }
        }
        
        if (proRoleDTO.getMoyenPayement() != null && !proRoleDTO.getMoyenPayement().isEmpty()) {
            
            existingProRole.getMoyenPayement().clear();

            
            for (MoyenPayementDTO moyenPayementDTO : proRoleDTO.getMoyenPayement()) {
                MoyenPayement moyenPayement = new MoyenPayement();
                moyenPayement.setId(moyenPayementDTO.getId());
                moyenPayement.setNom(moyenPayementDTO.getNom());

                
                existingProRole.getMoyenPayement().add(moyenPayement);

                
                moyenPayement.getProRoles().add(existingProRole);
            }

            
            System.out.println("Après mise à jour de moyenPayement:");
            existingProRole.getMoyenPayement().forEach(moyenPayement -> System.out.println(moyenPayement));
        }*/
   

        // 5. Sauvegarder les changements
        return proRoleRepository.save(existingProRole);
    }
   
    @Transactional
    public User updateUserProWithPro1 (Long userId, ProRole proRole)  {
        // 1. Chercher l'utilisateur existant par ID
        ProRole existingProRole = proRoleRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé avec l'ID : " + userId));

        // 2. Mettre à jour les champs de l'utilisateur avec les données du ProRole reçu
        existingProRole.setPhoto(proRole.getPhoto());
        existingProRole.setNum_siret(proRole.getNum_siret());
        existingProRole.setNum_tva(proRole.getNum_tva());
        existingProRole.setCertif_accred(proRole.getCertif_accred());
        existingProRole.setServic_spec_expat(proRole.getServic_spec_expat());
        existingProRole.setMoy_payem(proRole.getMoy_payem());
        existingProRole.setLivrai_dispo(proRole.getLivrai_dispo());
        existingProRole.setFrai_livrais(proRole.getFrai_livrais());
        existingProRole.setCondit_livrai(proRole.getCondit_livrai());
        existingProRole.setInteret_compag_mark(proRole.getInteret_compag_mark());
        existingProRole.setBudg_pub_mensuel(proRole.getBudg_pub_mensuel());

        // 3. Traiter les horaires d'ouverture
        if (proRole.getOpeningHours() != null && !proRole.getOpeningHours().isEmpty()) {
            existingProRole.getOpeningHours().clear();  // Nettoyer les anciens horaires

            // Boucle pour ajouter les nouvelles heures d'ouverture
            for (OpeningHours openingHours : proRole.getOpeningHours()) {
                // Associer les horaires à ce ProRole
                openingHours.setProRole(existingProRole);
                existingProRole.getOpeningHours().add(openingHours);
            }
        }

        // 4. Traiter les UserTypeCompagnSouhait
       /* if (proRole.getUserTypeCompagnSouhait() != null && !proRole.getUserTypeCompagnSouhait().isEmpty()) {
            existingProRole.getUserTypeCompagnSouhait().clear();  

            
            for (UserCompagnSouhait userTypeCompagnSouhait : proRole.getUserTypeCompagnSouhait()) {
                userTypeCompagnSouhait.setProRole(existingProRole);  
                existingProRole.getUserTypeCompagnSouhait().add(userTypeCompagnSouhait);
            }
        }*/

      
        // 6. Sauvegarder les changements dans la base de données
        return proRoleRepository.save(existingProRole);
    }


    @Transactional
    public User updateUserProWithPro2(Long userId, ProRoleDTO proRoleDTO) {
        // 1. Chercher l'utilisateur existant par ID
        ProRole existingProRole = proRoleRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID : " + userId));

        // 2. Mettre à jour les champs de l'utilisateur avec les données du DTO
        existingProRole.setPhoto(proRoleDTO.getPhoto());
        existingProRole.setNum_siret(proRoleDTO.getNum_siret());
        existingProRole.setNum_tva(proRoleDTO.getNum_tva()); 
        existingProRole.setCertif_accred(proRoleDTO.getCertif_accred());         
        existingProRole.setServic_spec_expat(proRoleDTO.getServic_spec_expat());                
      /*  existingProRole.setMoy_payem(proRoleDTO.getMoy_payem());
        existingProRole.setLivrai_dispo(proRoleDTO.getLivrai_dispo());        
        existingProRole.setFrai_livrais(proRoleDTO.getFrai_livrais());        
        existingProRole.setCondit_livrai(proRoleDTO.getCondit_livrai());        
        existingProRole.setInteret_compag_mark(proRoleDTO.getInteret_compag_mark());
        existingProRole.setBudg_pub_mensuel(proRoleDTO.getBudg_pub_mensuel());
        */

        
     // 3. Traiter les horaires d'ouverture
        if (proRoleDTO.getOpeningHours() != null) {
            // Vider les anciennes heures d'ouverture
            existingProRole.getOpeningHours().clear();

            // Ajouter les nouvelles heures d'ouverture
            for (OpeningHoursDTO openingHoursDTO : proRoleDTO.getOpeningHours()) {
                // Créer un nouvel objet OpeningHours à partir de l'OpeningHoursDTO
                OpeningHours openingHours = new OpeningHours();
                openingHours.setDayOfWeek(openingHoursDTO.getDayOfWeek());
                openingHours.setOpeningTime(openingHoursDTO.getOpeningTime());
                openingHours.setClosingTime(openingHoursDTO.getClosingTime());
                openingHours.setFerme(openingHoursDTO.getFerme());

                // Associer cet objet OpeningHours au bon ProRole
                openingHours.setProRole(existingProRole);

                // Ajouter l'OpeningHours dans la liste d'OpeningHours de ProRole
                existingProRole.getOpeningHours().add(openingHours);
            }
        }
        
        
       /* 
        // 3. Mettre à jour les types de compagnies souhaités
        Set<UserTypeCompagnSouhait> updatedUserTypeCompagnSouhaits = new HashSet<>();

        // Supprimer les anciens types de compagnies souhaités s'ils existent
        if (existingProRole.getUserTypeCompagnSouhait() != null) {
            existingProRole.getUserTypeCompagnSouhait().clear();  // Supprime les anciens types de compagnies souhaités
        }

        // Ajouter les nouveaux types de compagnies souhaités venant du DTO
        for (String typeCompagnSouhait : proRoleDTO.getUserTypeCompagnSouhait()) {
            UserTypeCompagnSouhait userTypeCompagnSouhait = new UserTypeCompagnSouhait();
            userTypeCompagnSouhait.setTypecompagnsouhait(typeCompagnSouhait);
            userTypeCompagnSouhait.setProRole(existingProRole);  // Associer au bon utilisateur

            updatedUserTypeCompagnSouhaits.add(userTypeCompagnSouhait);
        }

        // Mettre à jour le Set de UserTypeCompagnSouhait de l'utilisateur
        existingProRole.setUserTypeCompagnSouhait(updatedUserTypeCompagnSouhaits);   */

        // 4. Sauvegarder les changements
        return proRoleRepository.save(existingProRole);
    }

    
    @Transactional
    public User createUserWithUser(UserRoleDTO userRoleDTO) {
    	       
    	  UserRole userRole = new UserRole();
    	  
    	  userRole.setPrenom(userRoleDTO.getPrenom());
          userRole.setNom(userRoleDTO.getNom());
          userRole.setUsername(userRoleDTO.getUsername());
          userRole.setEmail(userRoleDTO.getEmail());
          userRole.setPassword(encoder.encode(userRoleDTO.getPassword()));
          userRole.setEtat("Actif");
          
          userRole.setDatenaiss(userRoleDTO.getDatenaiss());
          userRole.setPays(userRoleDTO.getPays());
          userRole.setVille(userRoleDTO.getVille());
          userRole.setNumtele(userRoleDTO.getNumtele());
          userRole.setNumwhats(userRoleDTO.getNumwhats());
          userRole.setPhoto(userRoleDTO.getPhoto());

          Role userRoleEntity = roleRepository.findByName(ERole.ROLE_USER)
                  .orElseGet(() -> roleRepository.save(new Role(ERole.ROLE_USER)));
          userRole.setRoles(Collections.singleton(userRoleEntity));

          
          return userRepository.save(userRole);
    }
    @Transactional
    public String uploadImages(Long userId, List<MultipartFile> images) throws IOException {
        // Récupérer l'utilisateur par son ID
        ProRole user = proRoleRepository.findById(userId)
                                  .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        // Pour chaque image envoyée
        for (MultipartFile image : images) {
            // Stocker le fichier
            String imageUrl = fileStorageService.storeFile(image);

            // Créer un objet UserImage
            UserImage userImage = new UserImage();
            userImage.setImageUrl(imageUrl);
            userImage.setFileName(image.getOriginalFilename());
            userImage.setProRole(user);  // Associer l'image à l'utilisateur

            // Sauvegarder l'image dans la base de données
            user.getImages().add(userImage); // Ajouter l'image à l'utilisateur
        }

        // Sauvegarder l'utilisateur avec ses images
        userRepository.save(user);

        return "Images uploaded and associated with user successfully";
    }
    
    
  /*  @Transactional
    public UserRole editUserRole(Long userId, UserRole userRole) {

    	userRole.setUsername(userRole.getUsername());
        userRole.setEmail(userRole.getEmail());
        userRole.setNumtele(userRole.getNumtele());
        userRole.setNumwhats(userRole.getNumwhats());
     
        Set<UserLangue> userLangues = userRole.getUserLangues().stream().map(existingUserLangue -> {
            UserLangue userLangue = new UserLangue();
            userLangue.setId(existingUserLangue.getId());
            Langue langue = new Langue();
            langue.setId(existingUserLangue.getLangue().getId());
            langue.setNom(existingUserLangue.getLangue().getNom());
            userLangue.setLangue(langue);
            userLangue.setNv_comp(existingUserLangue.getNv_comp());
            userLangue.setUser(userRole);
 
            return userLangue;
        }).collect(Collectors.toSet());  
 
        userRole.setUserLangues(userLangues);

        Set<UserReseauSociaux> userReseauxSociaux = userRole.getUserReseauSocieaux().stream().map(existingUserReseauSociaux -> {
            UserReseauSociaux userReseauSociaux = new UserReseauSociaux();
            userReseauSociaux.setId(existingUserReseauSociaux.getId());
 
            
            ReseauSociaux reseauSociaux = new ReseauSociaux();
            reseauSociaux.setId(existingUserReseauSociaux.getReseauSociaux().getId());
            reseauSociaux.setNom(existingUserReseauSociaux.getReseauSociaux().getNom());
 
            
            userReseauSociaux.setReseauSociaux(reseauSociaux);
 
            
            userReseauSociaux.setLien(existingUserReseauSociaux.getLien());
 
            
            userReseauSociaux.setUser(userRole);
 
            return userReseauSociaux;
        }).collect(Collectors.toSet()); 
        userRole.setUserReseauSocieaux(userReseauxSociaux);
 
        
     
        Set<CentreInteret> centreInterets = userRole.getCentreInterets().stream().map(existingCentreInteret -> {
            CentreInteret centreInteret = new CentreInteret();
            centreInteret.setId(existingCentreInteret.getId());
            centreInteret.setNom(existingCentreInteret.getNom());
 
            return centreInteret;
        }).collect(Collectors.toSet());
 
        userRole.setCentreInterets(centreInterets);


     
        Set<RecherchePlatform> servicesRecherche = userRole.getServicesRechercheSurPlatform().stream().map(existingService -> {
            RecherchePlatform service = new RecherchePlatform();
            service.setId(existingService.getId());
            service.setNom(existingService.getNom());
 
            return service;
        }).collect(Collectors.toSet());
 
        userRole.setServicesRechercheSurPlatform(servicesRecherche);
 
     

     
        Set<UserRaisonExpat> userRaisonsExpats = userRole.getUserRaisonExpat().stream().map(existingRaisonExpat -> {
            UserRaisonExpat raisonExpat = new UserRaisonExpat();
            raisonExpat.setId(existingRaisonExpat.getId());
            raisonExpat.setRaisonexpat(existingRaisonExpat.getRaisonexpat());
 
            raisonExpat.setUser(userRole); 
            return raisonExpat;
        }).collect(Collectors.toSet());
 
        userRole.setUserRaisonExpat(userRaisonsExpats);

     
        Set<UserPreferCommuni> userPreferCommuniSet = userRole.getUserPreferCommuni().stream().map(existingPreferCommuni -> {
            UserPreferCommuni preferCommuni = new UserPreferCommuni();
            preferCommuni.setId(existingPreferCommuni.getId());
            preferCommuni.setPrefercommuni(existingPreferCommuni.getPrefercommuni()); 
 
            preferCommuni.setUser(userRole); 
            return preferCommuni;
        }).collect(Collectors.toSet());
 
        userRole.setUserPreferCommuni(userPreferCommuniSet);
 
        

 
        return userRoleRepository.save(userRole);
    }*/
    
    @Transactional
    public UserRole updateUserRoleWithDTO(Long userId, UserRoleDTO userRoleDTO) {

        UserRole existingUserRole = userRoleRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé avec l'ID : " + userId));

        existingUserRole.setUsername(userRoleDTO.getUsername());
        existingUserRole.setEmail(userRoleDTO.getEmail());
        existingUserRole.setNumtele(userRoleDTO.getNumtele());
        existingUserRole.setNumwhats(userRoleDTO.getNumwhats());

        Set<UserLangue> updatedUserLangues = new HashSet<>();
        
        for (UserLangueDTO userLangueDTO : userRoleDTO.getUserLangues()) {
            Langue langue = langueRepository.findByNom(userLangueDTO.getLangueNom());
            
            if (langue == null) {
                langue = new Langue();
                langue.setNom(userLangueDTO.getLangueNom());
                langueRepository.save(langue);
            }
            
            Optional<UserLangue> existingUserLangueOpt = existingUserRole.getUserLangues().stream()
                .filter(ul -> ul.getLangue().getNom().equals(userLangueDTO.getLangueNom()))
                .findFirst();

            UserLangue userLangue;
            
            if (existingUserLangueOpt.isPresent()) {
                userLangue = existingUserLangueOpt.get();
                userLangue.setNv_comp(userLangueDTO.getNv_comp());
            } else {
               
                userLangue = new UserLangue();
                userLangue.setLangue(langue);
                userLangue.setNv_comp(userLangueDTO.getNv_comp());
                userLangue.setUser(existingUserRole);
            }
            
            updatedUserLangues.add(userLangue);
        }

        
        existingUserRole.setUserLangues(updatedUserLangues);

        
        return userRoleRepository.save(existingUserRole);
    }


    
    @Transactional
    public User createuserRole(UserRoleDTO userRoleDTO) {
        UserRole userRole = new UserRole();
        userRole.setUsername(userRoleDTO.getUsername());
        userRole.setEmail(userRoleDTO.getEmail());
        userRole.setPassword(encoder.encode(userRoleDTO.getPassword()));
        userRole.setEtat("Actif");
        userRole.setVille(userRoleDTO.getVille());
        userRole.setPays(userRoleDTO.getPays());
        userRole.setAge(userRoleDTO.getAge());
        userRole.setPrenom(userRoleDTO.getPrenom());
        userRole.setNom(userRoleDTO.getNom());
        userRole.setNumtele(userRoleDTO.getNumtele());
        userRole.setNumwhats(userRoleDTO.getNumwhats());
        userRole.setDatenaiss(userRoleDTO.getDatenaiss());
        userRole.setStat_matrim(userRoleDTO.getStat_matrim());
        userRole.setNbr_enf(userRoleDTO.getNbr_enf());
        userRole.setProf_act(userRoleDTO.getProf_act());
        userRole.setSect_act(userRoleDTO.getSect_act());
        userRole.setEmp_act(userRoleDTO.getEmp_act());
        userRole.setGenre(userRoleDTO.getGenre());
        userRole.setAutoris_consent(userRoleDTO.getAutoris_consent());

        userRole.setPrefer_communi(userRoleDTO.getPrefer_communi());
        userRole.setNbr_pays_expat(userRoleDTO.getNbr_pays_expat());
        userRole.setExpat_depui(userRoleDTO.getExpat_depui());
        userRole.setQuestion1(userRoleDTO.getQuestion1());
        userRole.setQuestion2(userRoleDTO.getQuestion2());
        userRole.setQuestion3(userRoleDTO.getQuestion3());
        userRole.setPhoto(userRoleDTO.getPhoto());

 
        Role userRoleEntity = roleRepository.findByName(ERole.ROLE_USER)
                .orElseGet(() -> roleRepository.save(new Role(ERole.ROLE_USER)));
        userRole.setRoles(Collections.singleton(userRoleEntity));
 
        Set<UserLangue> userLangues = new HashSet<>();
        for (UserLangueDTO userLangueDTO : userRoleDTO.getUserLangues()) {
            Langue langue = langueRepository.findByNom(userLangueDTO.getLangueNom());
            if (langue == null) {
                langue = new Langue();
                langue.setNom(userLangueDTO.getLangueNom());
                langueRepository.save(langue);
            }
 
            UserLangue userLangue = new UserLangue();
            userLangue.setLangue(langue);
            userLangue.setNv_comp(userLangueDTO.getNv_comp());
            userLangue.setUser(userRole);
            userLangues.add(userLangue);
        }
        userRole.setUserLangues(userLangues);


        Set<UserReseauSociaux> userReseauSociaux = new HashSet<>();
            for (UserReseauSociauxDTO userReseauSociauxDTO : userRoleDTO.getUserReseauSociaux()) {
                ReseauSociaux reseauSociaux = reseauSociauxRepository.findByNom(userReseauSociauxDTO.getReseauSociauNom());
                if (reseauSociaux == null) {
                    reseauSociaux = new ReseauSociaux();
                    reseauSociaux.setNom(userReseauSociauxDTO.getReseauSociauNom());
                    reseauSociauxRepository.save(reseauSociaux);
                }
 
                UserReseauSociaux userReseauSociau = new UserReseauSociaux();
                userReseauSociau.setReseauSociaux(reseauSociaux);
                userReseauSociau.setLien(userReseauSociauxDTO.getLien());
                userReseauSociau.setUser(userRole);
                userReseauSociaux.add(userReseauSociau);
            }
        userRole.setUserReseauSocieaux(userReseauSociaux);

 
        Set<CentreInteret> centreInterets = new HashSet<>();
        for (String centreInteretNom : userRoleDTO.getCentreInterets()) {
            CentreInteret centreInteret = centreInteretRepository.findByNom(centreInteretNom)
                    .orElseGet(() -> {
                        CentreInteret newCentreInteret = new CentreInteret();
                        newCentreInteret.setNom(centreInteretNom);
                        return centreInteretRepository.save(newCentreInteret);
                    });
            centreInterets.add(centreInteret);
        }
        userRole.setCentreInterets(centreInterets);
        
          Set<RecherchePlatform> servicesRecherches = new HashSet<>();
        for (String serviceNom : userRoleDTO.getServiceRecherches()) {
        	RecherchePlatform serviceRecherche = recherchePlatformRepository.findByNom(serviceNom)
                    .orElseGet(() -> {
                    	RecherchePlatform newService = new RecherchePlatform();
                        newService.setNom(serviceNom);
                        return recherchePlatformRepository.save(newService);
                    });
            servicesRecherches.add(serviceRecherche);
        }
        userRole.setServicesRechercheSurPlatform(servicesRecherches);

 
      Set<MarquesPreferees> marquesPreferees = new HashSet<>();
        for (String marquesPrefereesNoms : userRoleDTO.getMarquesPreferees()) {
        	MarquesPreferees marquesPreferee = marquesPrefereesRepository.findByNom(marquesPrefereesNoms)
                    .orElseGet(() -> {
                    	MarquesPreferees newMarquesPreferees = new MarquesPreferees();
                        newMarquesPreferees.setNom(marquesPrefereesNoms);
                        return marquesPrefereesRepository.save(newMarquesPreferees);
                    });
        	marquesPreferees.add(marquesPreferee);
        }
        userRole.setMarquesPreferees(marquesPreferees);

       Set<UserPreferCommuni> userPreferCommunis = new HashSet<>();
        for (String preferComm : userRoleDTO.getUserPreferCommuni()) {
            UserPreferCommuni userPreferCommuni = new UserPreferCommuni();
            userPreferCommuni.setPrefercommuni(preferComm);
            userPreferCommuni.setUser(userRole); 
            userPreferCommunis.add(userPreferCommuni);
        }
     
        userprefercommunicRepository.saveAll(userPreferCommunis);
 
        
        userRole.setUserPreferCommuni(userPreferCommunis);

        return userRepository.save(userRole);
    }
    
}
