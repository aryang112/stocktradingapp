package com.example.stocktradingapp.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

public class StockDTO {

    private String symbol;

    private String open;

    private String high;

    private String low;

    private String price;

    private String volume;

    private String latestTradingDay;

    private String previousClose;

    private String change;

    private String changePercent;


    public StockDTO() {
    }

    public StockDTO(String symbol, String open, String high, String low, String price, String volume, String latestTradingDay, String previousClose, String change, String changePercent) {
        this.symbol = symbol;
        this.open = open;
        this.high = high;
        this.low = low;
        this.price = price;
        this.volume = volume;
        this.latestTradingDay = latestTradingDay;
        this.previousClose = previousClose;
        this.change = change;
        this.changePercent = changePercent;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getOpen() {
        return this.open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return this.high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return this.low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVolume() {
        return this.volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getLatestTradingDay() {
        return this.latestTradingDay;
    }

    public void setLatestTradingDay(String latestTradingDay) {
        this.latestTradingDay = latestTradingDay;
    }

    public String getPreviousClose() {
        return this.previousClose;
    }

    public void setPreviousClose(String previousClose) {
        this.previousClose = previousClose;
    }

    public String getChange() {
        return this.change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getChangePercent() {
        return this.changePercent;
    }

    public void setChangePercent(String changePercent) {
        this.changePercent = changePercent;
    }

    public StockDTO symbol(String symbol) {
        setSymbol(symbol);
        return this;
    }

    public StockDTO open(String open) {
        setOpen(open);
        return this;
    }

    public StockDTO high(String high) {
        setHigh(high);
        return this;
    }

    public StockDTO low(String low) {
        setLow(low);
        return this;
    }

    public StockDTO price(String price) {
        setPrice(price);
        return this;
    }

    public StockDTO volume(String volume) {
        setVolume(volume);
        return this;
    }

    public StockDTO latestTradingDay(String latestTradingDay) {
        setLatestTradingDay(latestTradingDay);
        return this;
    }

    public StockDTO previousClose(String previousClose) {
        setPreviousClose(previousClose);
        return this;
    }

    public StockDTO change(String change) {
        setChange(change);
        return this;
    }

    public StockDTO changePercent(String changePercent) {
        setChangePercent(changePercent);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StockDTO)) {
            return false;
        }
        StockDTO stockDTO = (StockDTO) o;
        return Objects.equals(symbol, stockDTO.symbol) && Objects.equals(open, stockDTO.open) && Objects.equals(high, stockDTO.high) && Objects.equals(low, stockDTO.low) && Objects.equals(price, stockDTO.price) && Objects.equals(volume, stockDTO.volume) && Objects.equals(latestTradingDay, stockDTO.latestTradingDay) && Objects.equals(previousClose, stockDTO.previousClose) && Objects.equals(change, stockDTO.change) && Objects.equals(changePercent, stockDTO.changePercent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, open, high, low, price, volume, latestTradingDay, previousClose, change, changePercent);
    }

    @Override
    public String toString() {
        return "{" +
            " symbol='" + getSymbol() + "'" +
            ", open='" + getOpen() + "'" +
            ", high='" + getHigh() + "'" +
            ", low='" + getLow() + "'" +
            ", price='" + getPrice() + "'" +
            ", volume='" + getVolume() + "'" +
            ", latestTradingDay='" + getLatestTradingDay() + "'" +
            ", previousClose='" + getPreviousClose() + "'" +
            ", change='" + getChange() + "'" +
            ", changePercent='" + getChangePercent() + "'" +
            "}";
    }


}
