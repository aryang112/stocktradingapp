package com.example.stocktradingapp.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "trades")
public class Trades {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID tradeId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
    String symbol;
    int quantity;
    @Enumerated(EnumType.STRING)
    TradeType tradeType;
    BigDecimal price;
    LocalDateTime tradeDate;



    public Trades() {
    }

    public Trades(UUID tradeId, User user, String symbol, int quantity, TradeType tradeType, BigDecimal price, LocalDateTime tradeDate) {
        this.tradeId = tradeId;
        this.user = user;
        this.symbol = symbol;
        this.quantity = quantity;
        this.tradeType = tradeType;
        this.price = price;
        this.tradeDate = tradeDate;
    }

    public UUID getTradeId() {
        return this.tradeId;
    }

    public void setTradeId(UUID tradeId) {
        this.tradeId = tradeId;
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

    public TradeType getTradeType() {
        return this.tradeType;
    }

    public void setTradeType(TradeType tradeType) {
        this.tradeType = tradeType;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getTradeDate() {
        return this.tradeDate;
    }

    public void setTradeDate(LocalDateTime tradeDate) {
        this.tradeDate = tradeDate;
    }

    public Trades tradeId(UUID tradeId) {
        setTradeId(tradeId);
        return this;
    }

    public Trades user(User user) {
        setUser(user);
        return this;
    }

    public Trades symbol(String symbol) {
        setSymbol(symbol);
        return this;
    }

    public Trades quantity(int quantity) {
        setQuantity(quantity);
        return this;
    }

    public Trades tradeType(TradeType tradeType) {
        setTradeType(tradeType);
        return this;
    }

    public Trades price(BigDecimal price) {
        setPrice(price);
        return this;
    }

    public Trades tradeDate(LocalDateTime tradeDate) {
        setTradeDate(tradeDate);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Trades)) {
            return false;
        }
        Trades trades = (Trades) o;
        return Objects.equals(tradeId, trades.tradeId) && Objects.equals(user, trades.user) && Objects.equals(symbol, trades.symbol) && quantity == trades.quantity && Objects.equals(tradeType, trades.tradeType) && Objects.equals(price, trades.price) && Objects.equals(tradeDate, trades.tradeDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tradeId, user, symbol, quantity, tradeType, price, tradeDate);
    }

    @Override
    public String toString() {
        return "{" +
            " tradeId='" + getTradeId() + "'" +
            ", user='" + getUser() + "'" +
            ", symbol='" + getSymbol() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", tradeType='" + getTradeType() + "'" +
            ", price='" + getPrice() + "'" +
            ", tradeDate='" + getTradeDate() + "'" +
            "}";
    }
    
    
}
