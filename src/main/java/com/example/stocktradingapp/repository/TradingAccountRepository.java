package com.example.stocktradingapp.repository;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stocktradingapp.model.TradingAccount;

public interface TradingAccountRepository extends JpaRepository<TradingAccount, String>{

    Optional<TradingAccount> findByUserId(UUID userId);
    
}
