package com.example.stocktradingapp.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.stocktradingapp.dto.TradingAccountRequestDTO;
import com.example.stocktradingapp.dto.TradingAccountResponseDTO;
import com.example.stocktradingapp.dto.UserRequestDTO;
import com.example.stocktradingapp.dto.UserResponseDTO;
import com.example.stocktradingapp.http.ResponseEntityFactory;
import com.example.stocktradingapp.model.TradingAccount;
import com.example.stocktradingapp.model.User;
import com.example.stocktradingapp.repository.UserRespository;
import com.example.stocktradingapp.service.TradingAccountService;
import com.example.stocktradingapp.service.UserService;

@RestController
public class TradingAcctController {

    @Autowired
    TradingAccountService tradingAccountService;
    
    @SuppressWarnings("rawtypes")
    ResponseEntityFactory responseEntityFactory = new ResponseEntityFactory<>();
    @Autowired
    UserService userService;
    @Autowired
    UserRespository userRespository;

    @SuppressWarnings("unchecked")
    @PostMapping(value = "/createTradingAccount",
    produces = {"application/json"})
    public ResponseEntity<TradingAccountResponseDTO> createStudent(
        @RequestBody TradingAccountRequestDTO tradingAccountRequestDTO) {        
        
        if (!tradingAccountService.isDataValid(tradingAccountRequestDTO)) {
            return responseEntityFactory.create(HttpStatus.BAD_REQUEST);
        }

        if (!tradingAccountService.doesUserExist(tradingAccountRequestDTO.getUserId()) ||
        tradingAccountService.doesUserHaveTradingAccount(tradingAccountRequestDTO.getUserId())) {

            return responseEntityFactory.create(HttpStatus.METHOD_NOT_ALLOWED);
        }


        // Else proceed to create the trading account
        TradingAccountResponseDTO tradingAccountResponseDTO = tradingAccountService.createTradingAccount(tradingAccountRequestDTO);

        return responseEntityFactory.create(tradingAccountResponseDTO, HttpStatus.CREATED);
    }

    @SuppressWarnings("unchecked")
    @GetMapping(value = "/readTradingAccount/{userId}",
    produces = ("application/json"))
    public ResponseEntity<TradingAccountResponseDTO> readTradingAccount(@PathVariable UUID userId) {

        TradingAccountResponseDTO tradingAccountResponseDTO = tradingAccountService.getTradingAccount(userId);

        if (tradingAccountResponseDTO == null) {
            return responseEntityFactory.create(HttpStatus.NOT_FOUND);
        }

        return responseEntityFactory.create(tradingAccountResponseDTO, HttpStatus.OK);
    
    }

    
}
