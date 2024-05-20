package com.example.stocktradingapp.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.example.stocktradingapp.dto.StockDTO;
import com.example.stocktradingapp.dto.TradeRequestDTO;
import com.example.stocktradingapp.dto.TradeResponseDTO;
import com.example.stocktradingapp.dto.TradingAccountResponseDTO;
import com.example.stocktradingapp.mapper.TradesMapper;
import com.example.stocktradingapp.mapper.TradingAccountMapper;
import com.example.stocktradingapp.model.TradeHoldings;
import com.example.stocktradingapp.model.TradeType;
import com.example.stocktradingapp.model.Trades;
import com.example.stocktradingapp.model.TradingAccount;
import com.example.stocktradingapp.model.User;
import com.example.stocktradingapp.repository.TradeHoldingsRepository;
import com.example.stocktradingapp.repository.TradesRepository;
import com.example.stocktradingapp.repository.TradingAccountRepository;
import com.example.stocktradingapp.repository.UserRespository;

@Service
public class TradeService {

    @Autowired
    StockService stockService;
    @Autowired
    TradingAccountRepository tradingAccountRepository;
    @Autowired
    TradingAccountMapper tradingAccountMapper;
    @Autowired
    TradeHoldingsRepository tradeHoldingsRepository;
    @Autowired
    TradesRepository tradesRepository;
    @Autowired
    TradesMapper tradesMapper;
    @Autowired
    UserRespository userRespository;

    public TradeResponseDTO executeTrade(TradeRequestDTO tradeRequestDTO) throws Exception {
        
        
        StockDTO stockDTO = stockService.getStockPrice(tradeRequestDTO.getSymbol());

        
        Optional<TradingAccount> tradingAccountOptional = tradingAccountRepository.findByUserId(tradeRequestDTO.getUserId());
        User user = userRespository.findById(tradeRequestDTO.getUserId())
        .orElseThrow();
        //Optional<TradeHoldings> tradeHoldings = tradeHoldingsRepository.findByUserId(tradeRequestDTO.getUserId());

        
        if (!tradingAccountOptional.isPresent()) {
            TradeResponseDTO tradeResponseDTO = new TradeResponseDTO();
            return tradeResponseDTO;
    }
    TradingAccountResponseDTO tradingAccountResponseDTO = new TradingAccountResponseDTO();
    TradingAccount tradingAccount = tradingAccountOptional.get();    
    //mapping
    tradingAccountResponseDTO = tradingAccountMapper.toResponseDTO(tradingAccount);

    
    //Validate if user's request is valid (buy or sell)
    Boolean isRequestValid = isRequestValid(tradeRequestDTO);
    if (!isRequestValid) {
        
        
        return new TradeResponseDTO();
    }
    TradeHoldings tradeHoldings = tradeHoldingsRepository.findByUserIdAndSymbol(tradeRequestDTO.getUserId(), tradeRequestDTO.getSymbol())
    .orElse(null);
    
    TradeResponseDTO tradeResponseDTO = new TradeResponseDTO();
    tradeResponseDTO.setUserId(tradeRequestDTO.getUserId());
    tradeResponseDTO.setSymbol(tradeRequestDTO.getSymbol());
    double stockPrice = Double.parseDouble(stockDTO.getPrice());


    // Create a new Trade entity and set its properties
    Trades trades = new Trades();
    trades.setUser(user);  // Set the User object
    trades.setSymbol(tradeRequestDTO.getSymbol());
    trades.setPrice(BigDecimal.valueOf(stockPrice));
    trades.setQuantity(tradeRequestDTO.getQuantity());
    trades.setTradeType(tradeRequestDTO.getTradeType());
    trades.setTradeDate(LocalDateTime.now());
    tradesRepository.save(trades);

    double accountBalance = tradingAccount.getBalance();
    int quantityRequested = tradeRequestDTO.getQuantity();
    double totalAmount = stockPrice * quantityRequested;
    double revisedBalance = accountBalance;
    
    if (TradeType.Buy.equals(tradeRequestDTO.getTradeType())) {

        revisedBalance = accountBalance - totalAmount;

        handleBuyTrade(user, tradeRequestDTO, stockDTO);
    }

    if (TradeType.Sell.equals(tradeRequestDTO.getTradeType())) {
        
        revisedBalance = accountBalance - totalAmount;

        handleSellTrade(user, tradeRequestDTO, stockDTO);

    }

    //map and persist
    tradingAccount.setBalance(revisedBalance);
    tradingAccount.setUpdatedAt(LocalDateTime.now());
    tradingAccountRepository.save(tradingAccount);
    //set the dto
    tradeResponseDTO.setPrice(stockPrice);
    tradeResponseDTO.setQuantity(quantityRequested);
    tradeResponseDTO.setTradeDate(LocalDateTime.now());
    tradeResponseDTO.setTradeType(tradeRequestDTO.getTradeType());
    trades = tradesMapper.toEntity(tradeResponseDTO);
        

    return tradeResponseDTO;
    
}

    public boolean isRequestValid(TradeRequestDTO tradeRequestDTO) {

        StockDTO stockDTO = stockService.getStockPrice(tradeRequestDTO.getSymbol());

        if (stockDTO == null) {
            return false;
        }

        TradingAccount tradingAccount = tradingAccountRepository.findByUserId(tradeRequestDTO.getUserId())
        .orElse(null);
        TradeHoldings tradeHoldings = tradeHoldingsRepository.findByUserIdAndSymbol(tradeRequestDTO.getUserId(), tradeRequestDTO.getSymbol())
        .orElse(null);
        
        if (tradingAccount == null) {
            return false;
        }
        if (TradeType.Buy.equals(tradeRequestDTO.getTradeType())) {

            double balance = tradingAccount.getBalance();
            int quantity = tradeRequestDTO.getQuantity();
            double price = Double.parseDouble(stockDTO.getPrice());
            double totalCost = price * quantity;
            Boolean conditionMet = balance >= totalCost;
            return conditionMet;
            
        }

        if (TradeType.Sell.equals(tradeRequestDTO.getTradeType())) {

            double balance = tradingAccount.getBalance();
            int holdingsQuantity = tradeHoldings.getQuantity();

            if (tradeHoldings == null || holdingsQuantity == 0) {
                return false;
            }
            int quantity = tradeRequestDTO.getQuantity();
            Boolean conditionMet = holdingsQuantity >= quantity;

            return conditionMet;
            
        }

        return false;
    }

    public void handleBuyTrade(User user, TradeRequestDTO tradeRequestDTO, StockDTO stockDTO) {
        // Check if a holding exists for the user and symbol
        Optional<TradeHoldings> existingHolding = tradeHoldingsRepository.findByUserIdAndSymbol(user.getId(), tradeRequestDTO.getSymbol());
    
        if (existingHolding.isPresent()) {
            // Update the existing holding
            TradeHoldings holding = existingHolding.get();
            holding.setQuantity(holding.getQuantity() + tradeRequestDTO.getQuantity());
            tradeHoldingsRepository.save(holding);
        } else {
            // Create a new holding
            TradeHoldings newHolding = new TradeHoldings();
            newHolding.setUser(user);
            newHolding.setSymbol(tradeRequestDTO.getSymbol());
            newHolding.setQuantity(tradeRequestDTO.getQuantity());
            tradeHoldingsRepository.save(newHolding);
        }
    }

    public void handleSellTrade(User user, TradeRequestDTO tradeRequestDTO, StockDTO stockDTO) throws Exception {
        // Check if a holding exists for the user and symbol
        Optional<TradeHoldings> existingHolding = tradeHoldingsRepository.findByUserIdAndSymbol(user.getId(), tradeRequestDTO.getSymbol());
    
        if (existingHolding.isPresent()) {
            TradeHoldings holding = existingHolding.get();
            int currentQuantity = holding.getQuantity();
            
            if (currentQuantity >= tradeRequestDTO.getQuantity()) {
                // Update the existing holding
                holding.setQuantity(currentQuantity - tradeRequestDTO.getQuantity());
                
                if (holding.getQuantity() == 0) {
                    // Optionally, delete the holding if quantity becomes zero
                    tradeHoldingsRepository.delete(holding);
                } else {
                    // Save the updated holding
                    tradeHoldingsRepository.save(holding);
                }
            } else {
                // Handle error: not enough quantity to sell
                throw new Exception("This exception");
            }
        } else {
            // Handle error: no holdings found for the symbol
            throw new Exception("No holdings found for the symbol");
        }
    }
    
    
}

 
