package com.bezkoder.springjwt.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.models.UserReseauSociaux;

public interface UserReseauSociauxRepository extends JpaRepository<UserReseauSociaux, Long>{
	
    List<UserReseauSociaux> findByUser(User user);


}
