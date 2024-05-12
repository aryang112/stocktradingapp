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
import com.example.stocktradingapp.dto.UpdateBalanceRequestDTO;
import com.example.stocktradingapp.dto.UserResponseDTO;
import com.example.stocktradingapp.mapper.TradingAccountMapper;
import com.example.stocktradingapp.model.OperationType;
import com.example.stocktradingapp.model.TradingAccount;
import com.example.stocktradingapp.model.User;
import com.example.stocktradingapp.model.UserStatus;
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
        
        TradingAccount tradingAccount = tradingAccountMapper.toEntity(tradingAccountRequestDTO);
        tradingAccount.setUpdatedAt(LocalDateTime.now());

        User user = userRespository.findById(tradingAccountRequestDTO.getUserId())
        .orElseThrow();
        String Id = SimpleIdGenerator.generateId();
        user.setStatus(UserStatus.Active);

        tradingAccount.setUser(user);
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

    public boolean doesUserHaveTradingAccount(UUID userId) {
        
        Optional<TradingAccount> tradingAccountOptional = tradingAccountRepository.findByUserId(userId);
        return tradingAccountOptional.isPresent();
    }

    public TradingAccountResponseDTO getTradingAccount(UUID userId) {
        
    Optional<TradingAccount> tradingAccountOptional = tradingAccountRepository.findByUserId(userId);
    TradingAccountResponseDTO tradingAccountResponseDTO = null;

    if (tradingAccountOptional.isPresent()) {
        tradingAccountResponseDTO = new TradingAccountResponseDTO();
        TradingAccount tradingAccount = tradingAccountOptional.get();

        //mapping
        tradingAccountResponseDTO = tradingAccountMapper.toResponseDTO(tradingAccount);
        tradingAccountResponseDTO.setUserId(userId);
    }
        
    return tradingAccountResponseDTO;
    }

    public TradingAccountResponseDTO updateBalance(UUID userId, UpdateBalanceRequestDTO updateBalanceRequestDTO) {
        
        TradingAccount tradingAccount = tradingAccountRepository.findByUserId(userId).
        orElseThrow();

        double newBalance = tradingAccount.getBalance();
        double newAmount = updateBalanceRequestDTO.getAmount();

        if (OperationType.Deposit.equals(updateBalanceRequestDTO.getOperationType())) {

            newBalance = newBalance + newAmount;
        }
        if (OperationType.Withdrawal.equals(updateBalanceRequestDTO.getOperationType())) {

            newBalance = newBalance - newAmount;
        }

        tradingAccount.setBalance(newBalance);
        tradingAccount.setUpdatedAt(LocalDateTime.now());

        tradingAccountRepository.save(tradingAccount);

        TradingAccountResponseDTO tradingAccountResponseDTO = tradingAccountMapper.toResponseDTO(tradingAccount);
        tradingAccountResponseDTO.setUserId(userId);

        return tradingAccountResponseDTO;
    }

    public boolean isDTOValid(UpdateBalanceRequestDTO updateBalanceRequestDTO) {
        double amount = updateBalanceRequestDTO.getAmount();
        OperationType operationType = updateBalanceRequestDTO.getOperationType();

        return isValidAmount(amount) && isValidOperationType(operationType);
    }

    private boolean isValidAmount(double amount) {
        return amount > 0;
    }

    private boolean isValidOperationType(OperationType operationType) {
        return operationType == OperationType.Deposit || operationType == OperationType.Withdrawal;
    }


}
