package com.bezkoder.springjwt.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.ProRole;
import com.bezkoder.springjwt.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);
    List<User> findByRolesNameAndEtat(ERole roleName, String etat);
    Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
    List<User> findByRolesName(ERole roleName);
    Optional<User> findByIdAndRolesName(Long userId, ERole roleName);

 //   List<User> findByRolesNameAndCategorie(ERole roleName, String categorieNom);
    List<ProRole> findByRolesNameAndCategorie(ERole roleName, String categorieNom);
    List<User> findByRolesNameIn(List<ERole> roleNames);
    List<ProRole> findByRolesNameAndTagsName(ERole roleName, String tagsNom);
    List<User> findByRolesNameAndPays(ERole roleName, String nomPays);

}
