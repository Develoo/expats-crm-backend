package com.bezkoder.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.ProRole;
import com.bezkoder.springjwt.models.User;

@Repository
public interface ProRoleRepository extends JpaRepository<ProRole, Long> {

	User save(Optional<ProRole> existingProRole);
 

}