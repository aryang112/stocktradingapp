package com.example.stocktradingapp.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.stocktradingapp.dto.TradingAccountRequestDTO;
import com.example.stocktradingapp.dto.TradingAccountResponseDTO;
import com.example.stocktradingapp.mapper.TradingAccountMapper;
import com.example.stocktradingapp.model.TradingAccount;
import com.example.stocktradingapp.model.User;
import com.example.stocktradingapp.repository.TradingAccountRepository;
import com.example.stocktradingapp.repository.UserRespository;
import com.example.stocktradingapp.utils.SimpleIdGenerator;

@Service
public class TradingAccountService {

    @Autowired
    UserRespository userRespository;
    @Autowired
    TradingAccountRepository tradingAccountRepository;

    @Autowired
    TradingAccountMapper tradingAccountMapper;

    public boolean isDataValid(TradingAccountRequestDTO tradingAccountRequestDTO) {

        UUID userId = tradingAccountRequestDTO.getUserId();
        double balance = tradingAccountRequestDTO.getBalance();

        return userId != null && isValidBalance(balance);
    }

    private boolean isValidBalance(double balance) {
        return balance >= 1;
    }

    public TradingAccountResponseDTO createTradingAccount(TradingAccountRequestDTO tradingAccountRequestDTO) {
        
        User user = userRespository.findById(tradingAccountRequestDTO.getUserId())
        .orElseThrow();
        String Id = SimpleIdGenerator.generateId();

        TradingAccount tradingAccount = new TradingAccount();

        tradingAccount.setUser(user);
        tradingAccount.setUpdatedAt(LocalDateTime.now());
        tradingAccount.setBalance(tradingAccountRequestDTO.getBalance());
        tradingAccount.setId(Id);
        
        TradingAccountResponseDTO tradingAccountResponseDTO = tradingAccountMapper.toResponseDTO(tradingAccount);
        tradingAccountResponseDTO.setUserId(tradingAccountRequestDTO.getUserId());
        
        tradingAccountRepository.save(tradingAccount);


        return tradingAccountResponseDTO;
    }

    public boolean doesUserExist(UUID userId) {
        Optional<User> userOptional = userRespository.findById(userId);
        return userOptional.isPresent();
    }


}
