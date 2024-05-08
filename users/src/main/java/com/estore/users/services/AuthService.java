package com.estore.users.services;

import com.estore.users.Repositories.CustomerDetailsRepo;
import com.estore.users.Repositories.UserRepo;
import com.estore.users.UserRole;
import com.estore.users.dto.CustomerRegisterDto;
import com.estore.users.dto.LoginDto;
import com.estore.users.dto.LoginResponseDto;
import com.estore.users.mapper.CustomerRegistrationMapper;
import com.estore.users.models.CustomerDetails;
import com.estore.users.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CustomerDetailsRepo customerDetailsRepo;

    @Autowired
    private CustomerRegistrationMapper customerRegistrationMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private JWTDecoderService jwtDecoderService;

    public CustomerRegisterDto Register(CustomerRegisterDto customerRegisterDto){
        if(userRepo.findByEmail(customerRegisterDto.getEmail()) == null) {
            User newUser = customerRegistrationMapper.CustomerToUser(customerRegisterDto);
            CustomerDetails newCustomerDetails = customerRegistrationMapper.CustomerToDetails(customerRegisterDto);
            newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
            userRepo.save(newUser);
            Long newUserId = userRepo.getIdByEmail(newUser.getEmail());
            newCustomerDetails.setCustomerId(newUserId);
            newCustomerDetails.setRegistrationDate(new Date());
            customerDetailsRepo.save(newCustomerDetails);
            userRepo.save(new User( "Mahmoud" ,
                    "Abdeldayem" ,
                    passwordEncoder.encode("12345678"),
                    "mahmoud@gmail.com" ,
                    UserRole.Admin));
            return customerRegisterDto;
        }
        return null;
    }

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepo.findByEmail(email);
    }

    public LoginResponseDto login(LoginDto loginDto){
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail() , loginDto.getPassword())
            );
            System.out.println(auth.getAuthorities());
            String token = tokenService.generateJwt(auth);
            jwtDecoderService.decodeAndInspectJwt(token);
            User loggedIn = userRepo.findByEmail(loginDto.getEmail());
            if (loggedIn != null){
                if(passwordEncoder.matches(loginDto.getPassword() , loggedIn.getPassword())){
                   return  new LoginResponseDto(loggedIn.getFirstName(),
                           loggedIn.getLastName() ,
                           loggedIn.getEmail() ,
                           loggedIn.getRole().name() ,
                           token
                   );
                }
            }
        }catch (AuthenticationException e){
            System.out.println(e.toString() + loginDto.getPassword());
            return new LoginResponseDto("" , "" , "" , "" , "");
        }
            return null;
    }
}
