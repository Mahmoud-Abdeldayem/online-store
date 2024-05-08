package com.estore.users.controllers;

import com.estore.users.dto.CustomerRegisterDto;
import com.estore.users.dto.LoginDto;
import com.estore.users.dto.LoginResponseDto;
import com.estore.users.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<CustomerRegisterDto> registerCustomer(@RequestBody CustomerRegisterDto customerRegisterDto){
       return new ResponseEntity<>(authService.Register(customerRegisterDto) , HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto){
        return new ResponseEntity<>(authService.login(loginDto) , HttpStatus.OK);
    }
}
