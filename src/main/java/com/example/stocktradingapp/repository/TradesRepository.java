package com.example.stocktradingapp.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stocktradingapp.model.Trades;

public interface TradesRepository extends JpaRepository <Trades, UUID> {
    
}
