package com.estore.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Service;

@Service
public class JWTDecoderService {

    @Autowired
    private JwtDecoder jwtDecoder;

    public void decodeAndInspectJwt(String jwtToken) {
        Jwt jwt = jwtDecoder.decode(jwtToken);
        System.out.println("Decoded JWT Claims: " + jwt.getClaims());
    }
}
