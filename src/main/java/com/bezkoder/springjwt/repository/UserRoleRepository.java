package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}