package com.bezkoder.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.UserImage;

@Repository
public interface UserImageRepository extends JpaRepository<UserImage, Long> {

    List<UserImage> findByProRoleId(Long userId);

}
