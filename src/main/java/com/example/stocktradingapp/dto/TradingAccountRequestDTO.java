package com.example.stocktradingapp.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.example.stocktradingapp.model.User;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

public class TradingAccountRequestDTO {

    
    private UUID userId;
    private double balance;

    public TradingAccountRequestDTO() {
    }

    public TradingAccountRequestDTO(UUID userId, double balance) {
        this.userId = userId;
        this.balance = balance;
    }

    public UUID getUserId() {
        return this.userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public TradingAccountRequestDTO userId(UUID userId) {
        setUserId(userId);
        return this;
    }

    public TradingAccountRequestDTO balance(double balance) {
        setBalance(balance);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TradingAccountRequestDTO)) {
            return false;
        }
        TradingAccountRequestDTO tradingAccountRequestDTO = (TradingAccountRequestDTO) o;
        return Objects.equals(userId, tradingAccountRequestDTO.userId) && balance == tradingAccountRequestDTO.balance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, balance);
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", balance='" + getBalance() + "'" +
            "}";
    }
    
}
