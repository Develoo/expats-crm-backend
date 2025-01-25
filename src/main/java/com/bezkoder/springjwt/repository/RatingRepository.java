package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bezkoder.springjwt.models.Rating;
import java.util.List;


@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
   List<Rating> findByProRoleId(Long userId);
   List<Rating> findByUserRoleIdAndProRoleId(Long userRoleId, Long proRoleId);

}