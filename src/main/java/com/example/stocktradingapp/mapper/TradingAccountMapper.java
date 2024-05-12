package com.example.stocktradingapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.stocktradingapp.dto.TradingAccountRequestDTO;
import com.example.stocktradingapp.dto.TradingAccountResponseDTO;
import com.example.stocktradingapp.dto.UserRequestDTO;
import com.example.stocktradingapp.dto.UserResponseDTO;
import com.example.stocktradingapp.model.TradingAccount;
import com.example.stocktradingapp.model.User;

@Mapper(componentModel = "spring")
public interface TradingAccountMapper {

    TradingAccountMapper INSTANCE = Mappers.getMapper(TradingAccountMapper.class);

    TradingAccountResponseDTO requestToResponseDTO(TradingAccountRequestDTO tradingAccountRequestDTO);

    TradingAccount toEntity(TradingAccountResponseDTO tradingAccountResponseDTO);
    TradingAccountResponseDTO toResponseDTO(TradingAccount tradingAccount);

    TradingAccount toEntity(TradingAccountRequestDTO tradingAccountRequestDTO);

}
