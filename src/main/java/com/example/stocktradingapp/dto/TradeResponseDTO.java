package com.example.stocktradingapp.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.example.stocktradingapp.model.TradeType;
import java.util.Objects;

public class TradeResponseDTO {
    
    private UUID userId;
    String symbol;
    int quantity;
    TradeType tradeType;
    double price;
    LocalDateTime tradeDate;

    public TradeResponseDTO() {
    }

    public TradeResponseDTO(UUID userId, String symbol, int quantity, TradeType tradeType, double price, LocalDateTime tradeDate) {
        this.userId = userId;
        this.symbol = symbol;
        this.quantity = quantity;
        this.tradeType = tradeType;
        this.price = price;
        this.tradeDate = tradeDate;
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

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getTradeDate() {
        return this.tradeDate;
    }

    public void setTradeDate(LocalDateTime tradeDate) {
        this.tradeDate = tradeDate;
    }

    public TradeResponseDTO userId(UUID userId) {
        setUserId(userId);
        return this;
    }

    public TradeResponseDTO symbol(String symbol) {
        setSymbol(symbol);
        return this;
    }

    public TradeResponseDTO quantity(int quantity) {
        setQuantity(quantity);
        return this;
    }

    public TradeResponseDTO tradeType(TradeType tradeType) {
        setTradeType(tradeType);
        return this;
    }

    public TradeResponseDTO price(double price) {
        setPrice(price);
        return this;
    }

    public TradeResponseDTO tradeDate(LocalDateTime tradeDate) {
        setTradeDate(tradeDate);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TradeResponseDTO)) {
            return false;
        }
        TradeResponseDTO tradeResponseDTO = (TradeResponseDTO) o;
        return Objects.equals(userId, tradeResponseDTO.userId) && Objects.equals(symbol, tradeResponseDTO.symbol) && quantity == tradeResponseDTO.quantity && Objects.equals(tradeType, tradeResponseDTO.tradeType) && price == tradeResponseDTO.price && Objects.equals(tradeDate, tradeResponseDTO.tradeDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, symbol, quantity, tradeType, price, tradeDate);
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", symbol='" + getSymbol() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", tradeType='" + getTradeType() + "'" +
            ", price='" + getPrice() + "'" +
            ", tradeDate='" + getTradeDate() + "'" +
            "}";
    }

    
}
