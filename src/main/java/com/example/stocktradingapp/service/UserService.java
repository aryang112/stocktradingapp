package com.example.stocktradingapp.service;

import java.util.Optional;
import java.util.UUID;

import org.mapstruct.control.MappingControl.Use;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.stocktradingapp.dto.TradingAccountRequestDTO;
import com.example.stocktradingapp.dto.TradingAccountResponseDTO;
import com.example.stocktradingapp.dto.UserRequestDTO;
import com.example.stocktradingapp.dto.UserResponseDTO;
import com.example.stocktradingapp.mapper.UserMapper;
import com.example.stocktradingapp.model.User;
import com.example.stocktradingapp.model.UserStatus;
import com.example.stocktradingapp.repository.UserRespository;

import jakarta.transaction.Transactional;


@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TradingAccountService tradingAccountService;


    @Transactional
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        
        UserResponseDTO userResponseDTO = UserMapper.INSTANCE.requestToResponseDTO(userRequestDTO);
        
        userResponseDTO.setStatus(UserStatus.Pending);
        userResponseDTO.setId(UUID.randomUUID());

        User user = UserMapper.INSTANCE.toEntity(userResponseDTO);

        userRespository.save(user);

        //Calling to create a Trading Account
        TradingAccountRequestDTO tradingAccountRequestDTO = new TradingAccountRequestDTO();
        tradingAccountRequestDTO.setUserId(user.getId());
        tradingAccountRequestDTO.setBalance(0);
        
        tradingAccountService.createTradingAccount(tradingAccountRequestDTO);

        return userResponseDTO;
        
    }

    public boolean isDataValid(UserRequestDTO userRequestDTO) {
        
        String firstName = userRequestDTO.getFirstName();
        String ssn = userRequestDTO.getSsn();

        String email = userRequestDTO.getEmail();

        return (StringUtils.hasLength(ssn) && StringUtils.hasLength(firstName) && StringUtils.hasLength(email));
    }

    public boolean doesUserExistbySSN(String ssn) {
        
        Optional<User> userOptional = userRespository.findByssn(ssn);
        return userOptional.isPresent();
    }

    public UserResponseDTO getUser(UUID Id) {
        
        Optional<User> userOptional = userRespository.findById(Id);
        UserResponseDTO userResponseDTO = null;

        if (userOptional.isPresent()) {
            userResponseDTO = new UserResponseDTO();
            User user = userOptional.get();

            //mapping
            userResponseDTO = userMapper.toResponseDTO(user);
        }
        
        return userResponseDTO;
    }
    
}
