package com.example.stocktradingapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.stocktradingapp.dto.UserRequestDTO;
import com.example.stocktradingapp.dto.UserResponseDTO;
import com.example.stocktradingapp.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

        UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

        //Convert to Entity to persist in the DB
        User toEntity(UserResponseDTO userResponseDTO);
        
        //Convert to DTO
        UserResponseDTO toResponseDTO(User user);
        
        User toUserEntity(UserRequestDTO userRequestDTO);

        UserResponseDTO requestToResponseDTO(UserRequestDTO userRequestDTO);





    
}
