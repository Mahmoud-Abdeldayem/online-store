package com.estore.users.dto;

public class LoginResponseDto {

    private String first_name;
    private String lastName;
    private String email;
    private String role;
    private String jwt;

    public LoginResponseDto(){

    }

    public LoginResponseDto(String first_name, String lastName, String email, String role , String jwt) {
        this.first_name = first_name;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.jwt = jwt;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getJwt() {
        return jwt;
    }


    public String getRole() {
        return role;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
