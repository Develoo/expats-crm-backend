package com.bezkoder.springjwt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Favorite;
import com.bezkoder.springjwt.models.ProRole;
import com.bezkoder.springjwt.models.UserRole;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    Optional<Favorite> findByUserRoleAndProRole(UserRole userRole, ProRole proRole);
    List<Favorite> findByUserRole(UserRole userRole);
}
