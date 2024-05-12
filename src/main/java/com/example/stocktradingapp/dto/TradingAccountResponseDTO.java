package com.example.stocktradingapp.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.Objects;

public class TradingAccountResponseDTO {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;
    private double balance;
    private UUID userId;
    
    private LocalDateTime updatedAt;


    public TradingAccountResponseDTO() {
    }

    public TradingAccountResponseDTO(String Id, double balance, UUID userId, LocalDateTime updatedAt) {
        this.Id = Id;
        this.balance = balance;
        this.userId = userId;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return this.Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public UUID getUserId() {
        return this.userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public TradingAccountResponseDTO Id(String Id) {
        setId(Id);
        return this;
    }

    public TradingAccountResponseDTO balance(double balance) {
        setBalance(balance);
        return this;
    }

    public TradingAccountResponseDTO userId(UUID userId) {
        setUserId(userId);
        return this;
    }

    public TradingAccountResponseDTO updatedAt(LocalDateTime updatedAt) {
        setUpdatedAt(updatedAt);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TradingAccountResponseDTO)) {
            return false;
        }
        TradingAccountResponseDTO tradingAccountResponseDTO = (TradingAccountResponseDTO) o;
        return Objects.equals(Id, tradingAccountResponseDTO.Id) && balance == tradingAccountResponseDTO.balance && Objects.equals(userId, tradingAccountResponseDTO.userId) && Objects.equals(updatedAt, tradingAccountResponseDTO.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, balance, userId, updatedAt);
    }

    @Override
    public String toString() {
        return "{" +
            " Id='" + getId() + "'" +
            ", balance='" + getBalance() + "'" +
            ", userId='" + getUserId() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            "}";
    }
    

    
}
