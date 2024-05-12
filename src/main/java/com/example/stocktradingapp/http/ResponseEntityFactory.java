package com.example.stocktradingapp.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import io.micrometer.common.lang.Nullable;

public class ResponseEntityFactory<T> {
    
    public ResponseEntityFactory() {

    }
    public ResponseEntity<T> create(HttpStatus httpStatus) {
        
        return new ResponseEntity<>(httpStatus);
        
    }

    public ResponseEntity<T> create(@Nullable T body, HttpStatus httpStatus) {
        
        return new ResponseEntity<>(body, httpStatus);
        
    }
}
