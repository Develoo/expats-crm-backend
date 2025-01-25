package com.bezkoder.springjwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bezkoder.springjwt.models.Rating;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

   
    @GetMapping("/ProRole/{proRoleId}")
    public ResponseEntity<List<Rating>> getRatingsByProRoleId(@PathVariable Long proRoleId) {
        List<Rating> ratings = ratingService.getRatingsByProRoleId(proRoleId);
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/userRole/{userRoleId}/proRole/{proRoleId}")
    public ResponseEntity<List<Rating>> getRatingsByUserRoleIdAndProRoleId(@PathVariable Long userRoleId, @PathVariable Long proRoleId) {
        List<Rating> ratings = ratingService.getRatingsByUserRoleIdAndProRoleId(userRoleId, proRoleId);
        return ResponseEntity.ok(ratings);
    }
    
    @GetMapping("/weighted-sum-stars/{proRoleId}")
    public ResponseEntity<Map<Long, Double>> getWeightedSumOfStarsForAllUsers(@PathVariable Long proRoleId) {
        Map<Long, Double> weightedSumOfStars = ratingService.getWeightedSumOfStarsForAllUsers(proRoleId);
        return ResponseEntity.ok(weightedSumOfStars);
    }

    @GetMapping("/sum-stars/{proRoleId}")
    public ResponseEntity<Map<Long, Integer>> getSumOfStarsForUser(@PathVariable Long proRoleId) {
        Map<Long, Integer> sumOfStars = ratingService.getSumOfStarsForUser(proRoleId);
        return ResponseEntity.ok(sumOfStars);
    }

    @PostMapping("/add")
    public ResponseEntity<Rating> addRating(@RequestParam Long userId, 
                                             @RequestParam Long proRoleId,
                                             @RequestParam int stars,
                                             @RequestParam String content) {
        Rating rating = ratingService.addRating(userId, proRoleId, stars, content);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating);
    }

}
