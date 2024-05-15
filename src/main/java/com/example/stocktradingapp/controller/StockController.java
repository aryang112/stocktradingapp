package com.example.stocktradingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.stocktradingapp.dto.StockDTO;
import com.example.stocktradingapp.dto.TradingAccountRequestDTO;
import com.example.stocktradingapp.dto.TradingAccountResponseDTO;
import com.example.stocktradingapp.http.ResponseEntityFactory;
import com.example.stocktradingapp.service.StockService;

import jakarta.websocket.server.PathParam;

@RestController
public class StockController {
    
    @Autowired
    private StockService stockService;
    @SuppressWarnings("rawtypes")
    ResponseEntityFactory responseEntityFactory = new ResponseEntityFactory<>();

    @SuppressWarnings("unchecked")
    @GetMapping("/{symbol}")
    public ResponseEntity<StockDTO> getStockPrice(@PathVariable String symbol) {

        StockDTO stockDTO = stockService.getStockPrice(symbol);

        if (stockDTO.getSymbol() == null) {
            
            return responseEntityFactory.create(HttpStatus.BAD_REQUEST);
        }


        return responseEntityFactory.create(stockDTO, HttpStatus.OK);
    }

}
