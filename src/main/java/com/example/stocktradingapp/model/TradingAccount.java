package com.example.stocktradingapp.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "tradingaccount")
public class TradingAccount {

    @Id
    private String Id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private double balance;
    private LocalDateTime updatedAt;
    

    public TradingAccount() {
    }

    public TradingAccount(String Id, User user, double balance, LocalDateTime updatedAt) {
        this.Id = Id;
        this.user = user;
        this.balance = balance;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return this.Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public TradingAccount Id(String Id) {
        setId(Id);
        return this;
    }

    public TradingAccount user(User user) {
        setUser(user);
        return this;
    }

    public TradingAccount balance(double balance) {
        setBalance(balance);
        return this;
    }

    public TradingAccount updatedAt(LocalDateTime updatedAt) {
        setUpdatedAt(updatedAt);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TradingAccount)) {
            return false;
        }
        TradingAccount tradingAccount = (TradingAccount) o;
        return Objects.equals(Id, tradingAccount.Id) && Objects.equals(user, tradingAccount.user) && balance == tradingAccount.balance && Objects.equals(updatedAt, tradingAccount.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, user, balance, updatedAt);
    }

    @Override
    public String toString() {
        return "{" +
            " Id='" + getId() + "'" +
            ", user='" + getUser() + "'" +
            ", balance='" + getBalance() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            "}";
    }

    
}
