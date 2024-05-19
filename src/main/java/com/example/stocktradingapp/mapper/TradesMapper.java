package com.example.stocktradingapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.stocktradingapp.dto.TradeResponseDTO;
import com.example.stocktradingapp.dto.UserResponseDTO;
import com.example.stocktradingapp.model.Trades;
import com.example.stocktradingapp.model.User;

@Mapper(componentModel = "spring")
public interface TradesMapper {

    TradesMapper INSTANCE = Mappers.getMapper(TradesMapper.class);

    Trades toEntity(TradeResponseDTO tradeResponseDTO);

    
}
