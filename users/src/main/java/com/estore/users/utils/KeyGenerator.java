package com.estore.users.utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class KeyGenerator {

    public static KeyPair generateKey(){

        KeyPair keyPair;
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
        }catch (Exception e){
            throw new IllegalStateException();
        }
        return keyPair;
    }
}
