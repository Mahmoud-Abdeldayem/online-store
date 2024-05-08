package com.estore.users.services;

import com.estore.users.Repositories.CustomerDetailsRepo;
import com.estore.users.Repositories.UserRepo;
import com.estore.users.dto.CustomerProfileDto;
import com.estore.users.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CustomerDetailsRepo customerDetailsRepo;

    public String deleteCustomer(String email){
        userRepo.deleteByEmail(email);
        return "Deleted";
    }

    //public
}
