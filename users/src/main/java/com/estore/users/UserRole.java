package com.estore.users;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    Customer ,
    Admin;

    @Override
    public String getAuthority() {
        return name();
    }
}
