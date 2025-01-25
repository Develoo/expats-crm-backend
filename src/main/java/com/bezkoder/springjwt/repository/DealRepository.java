package com.bezkoder.springjwt.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bezkoder.springjwt.models.Deal;

public interface DealRepository extends JpaRepository<Deal, Long> {

    List<Deal> findByProRole_VilleIn(List<String> villes);
    List<Deal> findByProRole_CategorieIn(List<String> categorie);

    List<Deal> findByProRoleId(Long userId);

    List<Deal> findByEtat(String etat);
    
}
