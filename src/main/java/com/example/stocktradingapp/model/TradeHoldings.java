package com.example.stocktradingapp.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "tradeholdings")
public class TradeHoldings {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID holdingId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
    String symbol;
    int quantity;

    public TradeHoldings() {
    }

    public TradeHoldings(UUID holdingId, User user, String symbol, int quantity) {
        this.holdingId = holdingId;
        this.user = user;
        this.symbol = symbol;
        this.quantity = quantity;
    }

    public UUID getHoldingId() {
        return this.holdingId;
    }

    public void setHoldingId(UUID holdingId) {
        this.holdingId = holdingId;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public TradeHoldings holdingId(UUID holdingId) {
        setHoldingId(holdingId);
        return this;
    }

    public TradeHoldings user(User user) {
        setUser(user);
        return this;
    }

    public TradeHoldings symbol(String symbol) {
        setSymbol(symbol);
        return this;
    }

    public TradeHoldings quantity(int quantity) {
        setQuantity(quantity);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TradeHoldings)) {
            return false;
        }
        TradeHoldings tradeHoldings = (TradeHoldings) o;
        return Objects.equals(holdingId, tradeHoldings.holdingId) && Objects.equals(user, tradeHoldings.user) && Objects.equals(symbol, tradeHoldings.symbol) && quantity == tradeHoldings.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(holdingId, user, symbol, quantity);
    }

    @Override
    public String toString() {
        return "{" +
            " holdingId='" + getHoldingId() + "'" +
            ", user='" + getUser() + "'" +
            ", symbol='" + getSymbol() + "'" +
            ", quantity='" + getQuantity() + "'" +
            "}";
    }

    
}
