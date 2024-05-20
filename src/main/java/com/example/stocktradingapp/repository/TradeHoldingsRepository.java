package com.example.stocktradingapp.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stocktradingapp.model.TradeHoldings;

public interface TradeHoldingsRepository extends JpaRepository <TradeHoldings,UUID> {

    Optional<TradeHoldings> findByUserIdAndSymbol(UUID userId, String symbol);

    Optional<TradeHoldings> findByUserId(UUID userId);
}
