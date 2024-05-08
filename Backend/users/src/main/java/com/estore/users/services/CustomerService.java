package com.estore.users.services;

import com.estore.users.Repositories.CustomerDetailsRepo;
import com.estore.users.Repositories.UserRepo;
import com.estore.users.dto.CustomerProfileDto;
import com.estore.users.models.CustomerDetails;
import com.estore.users.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CustomerDetailsRepo customerDatailsRopo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String deleteAccount(String email){
        userRepo.deleteByEmail(email);
        return "Deleted";
    }

    public CustomerProfileDto showCustomerProfile(String email){
        User customerBasicInfo = userRepo.findByEmail(email);
        CustomerDetails customerDetails = customerDatailsRopo.getReferenceById(customerBasicInfo.getId());
        CustomerProfileDto customerProfile = new CustomerProfileDto(
                customerBasicInfo.getFirstName() ,
                customerBasicInfo.getLastName() ,
                customerBasicInfo.getEmail() ,
                customerDetails.getPhoneNumer() ,
                customerDetails.getAddress()
        );
        return customerProfile;
    }

}
