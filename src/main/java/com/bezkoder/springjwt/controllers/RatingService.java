package com.bezkoder.springjwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bezkoder.springjwt.repository.ProRoleRepository;
import com.bezkoder.springjwt.repository.RatingRepository;
import com.bezkoder.springjwt.repository.UserRoleRepository;
import com.bezkoder.springjwt.security.ResourceNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.bezkoder.springjwt.models.Favorite;
import com.bezkoder.springjwt.models.ProRole;
import com.bezkoder.springjwt.models.Rating;
import com.bezkoder.springjwt.models.UserRole;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private ProRoleRepository proRoleRepository;

    public Rating saveRating(Long userRoleId, Long proRoleId, Rating rating) {
        UserRole userRole = userRoleRepository.findById(userRoleId)
                .orElseThrow(() -> new UserRoleNotFoundException("UserRole not found with id: " + userRoleId));
        ProRole proRole = proRoleRepository.findById(proRoleId)
                .orElseThrow(() -> new ProRoleNotFoundException("ProRole not found with id: " + proRoleId));
        
        rating.setUserRole(userRole);
        rating.setProRole(proRole);
        
        return ratingRepository.save(rating);
    }

    public List<Rating> getRatingsByProRoleId(Long proRoleId) {
        return ratingRepository.findByProRoleId(proRoleId);
    }
    
    public List<Rating> getRatingsByUserRoleIdAndProRoleId(Long userRoleId, Long proRoleId) {
        return ratingRepository.findByUserRoleIdAndProRoleId(userRoleId, proRoleId);
    }

    public Map<Long, Double> getWeightedSumOfStarsForAllUsers(Long proRoleId) {
        List<Rating> ratings = ratingRepository.findByProRoleId(proRoleId);

        return ratings.stream()
                .collect(Collectors.groupingBy(
                        rating -> rating.getProRole().getId(),
                        Collectors.averagingDouble(rating -> rating.getStars())
                ));
    }
    
    public Map<Long, Integer> getSumOfStarsForUser(Long proRoleId) {
        List<Rating> ratings = ratingRepository.findByProRoleId(proRoleId);

        return ratings.stream()
                .collect(Collectors.groupingBy(
                        rating -> rating.getProRole().getId(),
                        Collectors.summingInt(Rating::getStars)
                ));
    }

    // Custom exceptions
    public class UserRoleNotFoundException extends RuntimeException {
        public UserRoleNotFoundException(String message) {
            super(message);
        }
    }

    public class ProRoleNotFoundException extends RuntimeException {
        public ProRoleNotFoundException(String message) {
            super(message);
        }
    }
    public Rating addRating(Long userId, Long proRoleId, int stars, String content) {
        UserRole userRole = userRoleRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("UserRole not found"));

        ProRole proRole = proRoleRepository.findById(proRoleId)
            .orElseThrow(() -> new ResourceNotFoundException("ProRole not found"));

        Rating rating = new Rating();
        rating.setUserRole(userRole);
        rating.setProRole(proRole);
        rating.setStars(stars);
        rating.setContent(content);

        return ratingRepository.save(rating);
    }

}
