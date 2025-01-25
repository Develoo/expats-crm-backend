package com.bezkoder.springjwt.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.bezkoder.springjwt.models.AdminRole;
import com.bezkoder.springjwt.models.AmbassadeurRole;
import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.EshopRole;
import com.bezkoder.springjwt.models.ProRole;
import com.bezkoder.springjwt.models.ProRoleDTO;
import com.bezkoder.springjwt.models.Role;
import com.bezkoder.springjwt.models.Tags;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.models.UserDTO;
import com.bezkoder.springjwt.models.UserImage;
import com.bezkoder.springjwt.models.UserLangue;
import com.bezkoder.springjwt.models.UserRole;
import com.bezkoder.springjwt.models.UserRoleDTO;
import com.bezkoder.springjwt.payload.request.LoginRequest;
import com.bezkoder.springjwt.payload.response.JwtResponse;
import com.bezkoder.springjwt.repository.FilesStorageServiceImpl;
import com.bezkoder.springjwt.repository.RoleRepository;
import com.bezkoder.springjwt.repository.UserImageRepository;
import com.bezkoder.springjwt.repository.UserRepository;
import com.bezkoder.springjwt.security.ResourceNotFoundException;
import com.bezkoder.springjwt.security.jwt.JwtUtils;
import com.bezkoder.springjwt.security.services.UserDetailsImpl;
import java.util.Optional;
import java.util.Set;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
    @Autowired
    private UserService userService;
    
    @Autowired
    private FilesStorageServiceImpl storageService;
    
    @Autowired
    private UserImageRepository userImageRepository;
    
	
   /* @Autowired
    private ApplicationEventPublisher eventPublisher;*/
    
    /*test*/

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
	
		if (userDetails.getEtat().equals("Actif")) {
		    return ResponseEntity.ok(new JwtResponse(jwt, 
		                                             userDetails.getId(), 
		                                             userDetails.getUsername(), 
		                                             userDetails.getEmail(), 
		                                             roles,
		                                             userDetails.getEtat()));
		} else {
		    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Compte inactif");
		}
	}
	
	@PostMapping("/signout")
	public ResponseEntity<?> logoutUser(HttpServletRequest request) {
	    // Ajouter une logique si vous souhaitez conserver une liste de tokens invalidés
	    String authHeader = request.getHeader("Authorization");
	    
	    if (authHeader != null && authHeader.startsWith("Bearer ")) {
	        String jwt = authHeader.substring(7); // Extraire le token JWT
	        // Optionnel : ajouter le JWT à une liste noire (blacklist)
	        // tokenBlacklistService.invalidateToken(jwt);
	    }
	    
	    SecurityContextHolder.clearContext(); // Supprimer l'authentification du contexte de sécurité
	    return ResponseEntity.ok("Vous êtes déconnecté avec succès !");
	}



	  @GetMapping("/user")
	  public List<User> getAllUserPoste() {
	    System.out.println("Get all UserPoste...");
	 
	    List<User> User = new ArrayList<>();
	    userRepository.findAll().forEach(User::add);
	 
	    return User;
	   
	  }
	  

	    @GetMapping("/users/by-role-and-category")
	    public List<ProRole> getUsersByRoleProAndCategoryName(@RequestParam String categoryName) {
	        return userService.getUsersByRoleProAndCategoryName(categoryName);
	    }
	    
	    @GetMapping("/by-role-and-tags")
	    public List<ProRole> getUsersByRoleProAndTagsName(@RequestParam String tagsName) {
	        return userService.getUsersByRoleProAndTagsName(tagsName);
	    }
	    
	  @GetMapping("/role-pro")
	    public List<User> getUsersByRolePro() {
	        return userRepository.findByRolesName(ERole.ROLE_PRO);
	    }
	  @GetMapping("/role-pro/Actif/{userId}")
	  public Optional<User> getRoleProById(@PathVariable Long userId) {
	      return userRepository.findByIdAndRolesName(userId, ERole.ROLE_PRO);
	  }
	  @GetMapping("/role-pro/Actif")
	    public List<User> getUsersByRoleProActif() {
	        return userRepository.findByRolesNameAndEtat( ERole.ROLE_PRO, "Actif");
	    }
	  @GetMapping("/role-pro/EnAttente")
	  public List<User> getUsersByRoleProEnAttente() {
	        return userRepository.findByRolesNameAndEtat( ERole.ROLE_PRO, "En attente");
	    }
	  
	  @GetMapping("/role-pro/Refusé")
	  public List<User> getUsersByRoleProRefusé() {
	        return userRepository.findByRolesNameAndEtat( ERole.ROLE_PRO, "Refusé");
	    }
	  @GetMapping("/role-user")
	    public List<User> getUsersByRoleUser() {
	        return userRepository.findByRolesName(ERole.ROLE_USER);
	    }
	  @GetMapping("/{id}")
	    public User getUserById(@PathVariable Long id) {
	        Optional<User> user = userService.getUserById(id);
	        return user.orElse(null);
	    }
	  /* @GetMapping("/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable Long id) {
	        User user = userService.getUserById(id);
	        return ResponseEntity.ok(user);
	    }*/
	  @GetMapping("/role-embassadeur")
	    public List<User> getUsersByRoleEmbassadeur() {
	        return userRepository.findByRolesName(ERole.ROLE_EMBASSADEUR);
	    }
	  @GetMapping("/role-user-embassadeur")
	    public List<User> getUsersByRoleUserAndEmbassadeur() {
	        List<User> usersWithRoleUser = userRepository.findByRolesName(ERole.ROLE_USER);
	        List<User> usersWithRoleEmbassadeur = userRepository.findByRolesName(ERole.ROLE_EMBASSADEUR);
	        
	        // Combine the two lists using Java Stream API
	        List<User> combinedUsers = Stream.concat(usersWithRoleUser.stream(), usersWithRoleEmbassadeur.stream())
	                                          .collect(Collectors.toList());
	        
	        return combinedUsers;
	    }
	  @GetMapping("/role-admin")
	    public List<User> getUsersByRoleAdmin() {
	        return userRepository.findByRolesName(ERole.ROLE_ADMIN);
	    }

	  @PutMapping("/update")
	public User updateUser(@Valid @RequestBody User user) {
		
		user.setPassword(encoder.encode(user.getPassword()));

	        return userRepository.save(user);
			 
	}
	    @PutMapping("up/{id}")
	    public User updateUserEtat(@PathVariable Long id, @RequestBody UserDTO userDTO) {
	        Optional<User> optionalUser = userRepository.findById(id);
	        if (optionalUser.isPresent()) {
	            User existingUser = optionalUser.get();
	            existingUser.setEtat(userDTO.getEtat());
	            existingUser.setUsername(userDTO.getUsername());
	            existingUser.setEmail(userDTO.getEmail());
	            return userRepository.save(existingUser);
	        }
	        return null;
	    }
	  @RequestMapping(value = "/users/{iduser}/update", method = RequestMethod.PUT)
			User updateUser(@PathVariable("iduser") Long iduser, @RequestBody User users) {
				User user = userRepository.findById(iduser).get();
				return userRepository.save(user);
			}
	  
	  @PutMapping("/update/{userId}")
	  public ResponseEntity<User> updateUserProWithPro(
	          @PathVariable Long userId,
	          @RequestBody ProRoleDTO proRoleDTO) {
	      // Validation de la demande (ajoutez des validations si besoin)
	      if (proRoleDTO == null) {
	          return ResponseEntity.badRequest().build();
	      }

	      // Appeler le service pour mettre à jour le ProRole
	      User updatedProRole = userService.updateUserProWithPro(userId, proRoleDTO);

	      // Retourner la réponse HTTP 200 OK avec l'utilisateur mis à jour
	      return ResponseEntity.ok(updatedProRole);
	  }

	

	  @PutMapping("/{userId}/update1")
	  public ResponseEntity<User> updateUserProWithPro(
	          @PathVariable Long userId,
	          @RequestBody ProRole proRole) {  // Recevoir un ProRole directement dans la requête

	      // Appeler le service pour mettre à jour le ProRole avec les images
	      User updatedUser = userService.updateUserProWithPro1(userId, proRole);

	      // Retourner la réponse HTTP 200 OK avec l'utilisateur mis à jour
	      return ResponseEntity.ok(updatedUser);
	  }

	  
	  
	  @PostMapping("/pro")
	  public ProRole createProUser(@RequestBody ProRole proRole) {
	
        proRole.setPassword( encoder.encode(proRole.getPassword()));


        Role userRoleEntity = roleRepository.findByName(ERole.ROLE_PRO)
                .orElseGet(() -> roleRepository.save(new Role(ERole.ROLE_PRO)));

        proRole.setRoles(Collections.singleton(userRoleEntity));
        proRole.setEtat("En attente");

	    //    eventPublisher.publishEvent(new UserRegisteredEvent(proRole));
	        return userRepository.save(proRole);

	  }
	
	@PostMapping("/user")
    public UserRole createUserUser(@RequestBody UserRole userRole) {

		userRole.setPassword( encoder.encode(userRole.getPassword()));


		   Role userRoleEntity = roleRepository.findByName(ERole.ROLE_USER)
	                .orElseGet(() -> roleRepository.save(new Role(ERole.ROLE_USER)));

	        /*for (UserLangue userLangue : userLangues) {
	            userLangue.setUser(userRole);
	            Langue savedLangue = langueRepository.save(userLangue.getLangue());
	            userLangue.setLangue(savedLangue);

	            userLangueRepository.save(userLangue);
	        }*/

	        userRole.setRoles(Collections.singleton(userRoleEntity));
	        userRole.setEtat("Actif");

       // eventPublisher.publishEvent(new UserRegisteredEvent(userRole));

        return userRepository.save(userRole);

  }
	

	    
		  @PostMapping("/ajusers")
		    public ResponseEntity<User> createUser(@RequestBody UserRoleDTO userRoleDTO) {
		        User createdUser = userService.createuserRole(userRoleDTO);
		        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
		    }
		  
		  @PostMapping("/ajuserspro")

		    public ResponseEntity<User> createUserPro(@RequestBody ProRoleDTO proRoleDTO) {

		        User createdUserPro = userService.createuserPro(proRoleDTO);

		        return new ResponseEntity<>(createdUserPro, HttpStatus.CREATED);

		    }
		  @PostMapping("/enregisteruserspro")

		    public ResponseEntity<User> enregisterPro(@RequestBody ProRoleDTO proRoleDTO) {

		        User createdUserPro = userService.createuserProWithPro(proRoleDTO);

		        return new ResponseEntity<>(createdUserPro, HttpStatus.CREATED);

		    }

		  @PostMapping("/enregisteruser")

		    public ResponseEntity<User> enregisterUser(@RequestBody UserRoleDTO userRoleDTO) {

		        User createdUserPro = userService.createUserWithUser(userRoleDTO);

		        return new ResponseEntity<>(createdUserPro, HttpStatus.CREATED);

		    }
		 

	@PostMapping("/admin")
    public AdminRole createAdminUser(@RequestBody AdminRole adminRole) {

		adminRole.setPassword( encoder.encode(adminRole.getPassword()));

		   Role userRoleEntity = roleRepository.findByName(ERole.ROLE_ADMIN)
	                .orElseGet(() -> roleRepository.save(new Role(ERole.ROLE_ADMIN)));

		   adminRole.setRoles(Collections.singleton(userRoleEntity));
		   adminRole.setEtat("Actif");

        return userRepository.save(adminRole);
  }
	
	@PostMapping("/Embassadeur")
    public AmbassadeurRole createEmbassadeurUser(@RequestBody AmbassadeurRole ambassadeurRole) {

		ambassadeurRole.setPassword( encoder.encode(ambassadeurRole.getPassword()));


		   Role userRoleEntity = roleRepository.findByName(ERole.ROLE_EMBASSADEUR)
	                .orElseGet(() -> roleRepository.save(new Role(ERole.ROLE_EMBASSADEUR)));

		   ambassadeurRole.setRoles(Collections.singleton(userRoleEntity));
		   ambassadeurRole.setEtat("Actif");

        return userRepository.save(ambassadeurRole);
  }
	
	@PostMapping("/Eshop")
    public EshopRole createEshopUser(@RequestBody EshopRole eshopRole) {

		eshopRole.setPassword( encoder.encode(eshopRole.getPassword()));


		   Role userRoleEntity = roleRepository.findByName(ERole.ROLE_E_SHOP)
	                .orElseGet(() -> roleRepository.save(new Role(ERole.ROLE_E_SHOP)));

		   eshopRole.setRoles(Collections.singleton(userRoleEntity));
		   eshopRole.setEtat("Actif");

        return userRepository.save(eshopRole);
  }
    @GetMapping("/{id}/tags")
    public Set<Tags> getTags(@PathVariable Long id) {
        return userService.getTagsByProRoleId(id);
    }
    
    @GetMapping("/pays/{nomPays}")
    public List<User> getUserProByPays(@PathVariable String nomPays) {
        return userRepository.findByRolesNameAndPays( ERole.ROLE_PRO, nomPays);
    }
   
    @GetMapping("/categ/{nomCateg}")
    public List<ProRole> getUserProByCateg(@PathVariable String nomCateg) {
        return userRepository.findByRolesNameAndCategorie( ERole.ROLE_PRO, nomCateg);
    }
   
    
     
    @PostMapping("/upload")
	  public List<String> uploadFiles(@RequestParam("files") MultipartFile[] files) {
	      List<String> fileNames = new ArrayList<>();
	      try {
	          for (MultipartFile file : files) {
	              storageService.save(file);
	             fileNames.add(file.getOriginalFilename());
	          }
	          return fileNames;
	      } catch (Exception e) {
	          throw new RuntimeException("Could not upload the files. Error: " + e.getMessage());
	      }
	  }

	  /*
		@GetMapping("/files/{filename:.+}")
		@ResponseBody
		public ResponseEntity<Resource> getFile(@PathVariable String filename) {
			Resource file = storageService.load(filename);
			return ResponseEntity.ok()
			        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
		}*/
    
   /* @PostMapping("/{userId}/upload-images")
    public String uploadImages(@PathVariable Long userId,
                               @RequestParam List<MultipartFile> images) throws IOException {
        // Appelle la méthode correcte sur le service
        for (MultipartFile image : images) {
            String imageUrl = storageService.storeFile(image);  // Assure-toi que la méthode existe
            // Traite l'URL ou autre logique
        }

        return "Images uploaded successfully";
    }*/
    @PostMapping("/{userId}/upload-images")
    public String uploadImages(@PathVariable Long userId,
                               @RequestParam List<MultipartFile> images) throws IOException {
        return userService.uploadImages(userId, images);
    }
    
    @GetMapping("/{userId}/upload-images")
    public List<UserImage> getuploadImages(@PathVariable Long userId) {
        return userImageRepository.findByProRoleId( userId);
    }
	  @DeleteMapping("/upload-images/{imageId}")
	  public ResponseEntity<?> deleteImage(@PathVariable Long imageId) throws ResourceNotFoundException {
	      return userImageRepository.findById(imageId).map(img -> {
	    	  userImageRepository.delete(img);
	          return ResponseEntity.ok().build();
	      }).orElseThrow(() -> new ResourceNotFoundException("imageId " + imageId + " not found"));
	  }
	  
	  @PutMapping("/{userId}")
	    public ResponseEntity<UserRole> updateUserRole(@PathVariable Long userId, @RequestBody UserRoleDTO userRole) {
	        UserRole updatedUserRole = userService.updateUserRoleWithDTO(userId, userRole);
	        return ResponseEntity.ok(updatedUserRole);
	    }
	  
	  @DeleteMapping("/user/{id}")
	    public void deleteUser(@PathVariable Long id) {
			userRepository.deleteById(id);
	    }
	  
	  
	  
	  
}
