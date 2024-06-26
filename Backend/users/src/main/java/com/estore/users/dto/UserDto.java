package com.estore.users.dto;

import com.estore.users.UserRole;
import jakarta.persistence.*;

public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private UserRole role;

    public UserDto() {

    }

    public UserDto(Long id, String firstName, String lastName, String password, String email, UserRole role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setRole(UserRole role) {
        this.role = role;
    }

}
