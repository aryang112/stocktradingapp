package com.example.stocktradingapp.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.stocktradingapp.dto.UserRequestDTO;
import com.example.stocktradingapp.dto.UserResponseDTO;
import com.example.stocktradingapp.http.ResponseEntityFactory;
import com.example.stocktradingapp.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    
    @SuppressWarnings("rawtypes")
    ResponseEntityFactory responseEntityFactory = new ResponseEntityFactory<>();
    
    @GetMapping("/healthCheck")
    public ResponseEntity<?> healthcheck() {
        return responseEntityFactory.create(HttpStatus.OK);

    }

    @SuppressWarnings("unchecked")
    @PostMapping(value = "/createUser",
    produces = {"application/json"})
    public ResponseEntity<UserResponseDTO> createStudent(@RequestBody UserRequestDTO userRequestDTO) {        
        
        if (!userService.isDataValid(userRequestDTO)) {
            return responseEntityFactory.create(HttpStatus.BAD_REQUEST);
        }

        if (userService.doesUserExistbySSN(userRequestDTO.getSsn())) {

            return responseEntityFactory.create(HttpStatus.METHOD_NOT_ALLOWED);
        }

        // Else proceed to create the user
        UserResponseDTO userResponseDTO = userService.createUser(userRequestDTO);

        return responseEntityFactory.create(userResponseDTO, HttpStatus.CREATED);
    }

    @SuppressWarnings("unchecked")
    @GetMapping(value = "/readUser/{Id}",
    produces = ("application/json"))
    public ResponseEntity<UserResponseDTO> readUser(@PathVariable UUID Id) {

        UserResponseDTO userResponseDTO = userService.getUser(Id);

        if (userResponseDTO == null) {
            return responseEntityFactory.create(HttpStatus.NOT_FOUND);
        }

        return responseEntityFactory.create(userResponseDTO, HttpStatus.OK);
    
    }
}
