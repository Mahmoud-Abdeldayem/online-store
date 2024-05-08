package com.estore.users.dto;

import java.util.Date;

public class CustomerRegisterDto {

    private String firstName;
    private String LastName;
    private String email;
    private String password;

    private String address;
    private String phoneNumber;
    private Date registrationDate;

    public CustomerRegisterDto() {
    }

    public CustomerRegisterDto(String firstName, String lastName, String email, String password, String address, String phoneNumber, Date registrationDate) {
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.registrationDate = registrationDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
