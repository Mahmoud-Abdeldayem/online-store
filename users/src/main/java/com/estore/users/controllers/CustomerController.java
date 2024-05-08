package com.estore.users.controllers;

import com.estore.users.dto.CustomerRegisterDto;
import com.estore.users.dto.UserDto;
import com.estore.users.mapper.CustomerRegistrationMapper;
import com.estore.users.models.CustomerDetails;
import com.estore.users.models.User;
import com.estore.users.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("customer")
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRegistrationMapper customerRegistrationMapper;


    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

}
