package com.estore.users.mapper;

import com.estore.users.UserRole;
import com.estore.users.dto.CustomerRegisterDto;
import com.estore.users.models.CustomerDetails;
import com.estore.users.models.User;
import org.springframework.stereotype.Component;

@Component
public class CustomerRegistrationMapper {

    public User CustomerToUser(CustomerRegisterDto customerRegisterDto){
        return new User(
                        customerRegisterDto.getFirstName() ,
                        customerRegisterDto.getLastName() ,
                        customerRegisterDto.getPassword() ,
                        customerRegisterDto.getEmail() ,
                        UserRole.Customer
                );
    }

    public CustomerDetails CustomerToDetails(CustomerRegisterDto customerRegisterDto){
        return  new CustomerDetails(
                customerRegisterDto.getPhoneNumber() ,
                customerRegisterDto.getAddress() ,
                customerRegisterDto.getRegistrationDate()
        );
    }
}
