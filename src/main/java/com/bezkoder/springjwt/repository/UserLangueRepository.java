package com.bezkoder.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.models.UserLangue;

public interface UserLangueRepository extends JpaRepository<UserLangue, Long>{
	
    List<UserLangue> findByUser(User user);
    
    
    List<UserLangue> findByUserId(Long userId);
    UserLangue findByUserIdAndLangueNom(Long userId, String langueNom);


}
