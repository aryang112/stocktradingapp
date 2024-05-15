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


}
