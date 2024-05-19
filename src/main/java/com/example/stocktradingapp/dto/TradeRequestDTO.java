package com.example.stocktradingapp.dto;

import java.util.UUID;

import com.example.stocktradingapp.model.TradeType;
import java.util.Objects;

public class TradeRequestDTO {

    private UUID userId;
    String symbol;
    int quantity;
    TradeType tradeType;

    public TradeRequestDTO() {
    }

    public TradeRequestDTO(UUID userId, String symbol, int quantity, TradeType tradeType) {
        this.userId = userId;
        this.symbol = symbol;
        this.quantity = quantity;
        this.tradeType = tradeType;
    }

    public UUID getUserId() {
        return this.userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public TradeType getTradeType() {
        return this.tradeType;
    }

    public void setTradeType(TradeType tradeType) {
        this.tradeType = tradeType;
    }

    public TradeRequestDTO userId(UUID userId) {
        setUserId(userId);
        return this;
    }

    public TradeRequestDTO symbol(String symbol) {
        setSymbol(symbol);
        return this;
    }

    public TradeRequestDTO quantity(int quantity) {
        setQuantity(quantity);
        return this;
    }

    public TradeRequestDTO tradeType(TradeType tradeType) {
        setTradeType(tradeType);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TradeRequestDTO)) {
            return false;
        }
        TradeRequestDTO tradeRequestDTO = (TradeRequestDTO) o;
        return Objects.equals(userId, tradeRequestDTO.userId) && Objects.equals(symbol, tradeRequestDTO.symbol) && quantity == tradeRequestDTO.quantity && Objects.equals(tradeType, tradeRequestDTO.tradeType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, symbol, quantity, tradeType);
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", symbol='" + getSymbol() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", tradeType='" + getTradeType() + "'" +
            "}";
    }

    
}
