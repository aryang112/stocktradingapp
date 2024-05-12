package com.example.stocktradingapp.repository;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stocktradingapp.model.User;


public interface UserRespository extends JpaRepository<User, UUID>{

    Optional<User> findByssn(String ssn);
    
}
