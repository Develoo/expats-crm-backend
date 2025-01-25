package com.bezkoder.springjwt.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.OpeningHours;


import java.util.List;

public interface OpeningHoursRepository extends JpaRepository<OpeningHours, Long> {
    List<OpeningHours> findByProRoleId(Long proRoleId);
}
