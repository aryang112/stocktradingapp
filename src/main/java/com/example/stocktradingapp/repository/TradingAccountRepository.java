package com.example.stocktradingapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stocktradingapp.model.TradingAccount;

public interface TradingAccountRepository extends JpaRepository<TradingAccount, Long>{
    
}
