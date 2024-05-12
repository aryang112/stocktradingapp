package com.example.stocktradingapp.utils;
import java.security.SecureRandom;


public class SimpleIdGenerator {

    private static final SecureRandom secureRandom = new SecureRandom();

    public static String generateId() {
        long randomNum = Math.abs(secureRandom.nextLong());
        return String.format("%012d", randomNum % 1_000_000_000_000L);
    }
    
}
