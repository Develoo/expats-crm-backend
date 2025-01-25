package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
 // Method to find nearby addresses based on latitude and longitude
 // You can implement the logic for finding nearby addresses here
 // For example, using native queries or Spring Data JPA's query methods
 // Check Spring Data JPA documentation for more details
}
