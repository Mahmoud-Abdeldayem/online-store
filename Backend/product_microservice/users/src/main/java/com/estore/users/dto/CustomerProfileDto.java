package com.estore.users.dto;

public class CustomerProfileDto {

    private String firstName;
    private String LastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;

    public CustomerProfileDto(){

    }

    public CustomerProfileDto(String firstName, String lastName, String email, String password, String phoneNumber, String address) {
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public CustomerProfileDto(String firstName, String lastName, String email, String phoneNumber, String address) {
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
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


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
