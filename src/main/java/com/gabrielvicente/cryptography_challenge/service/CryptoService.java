package com.gabrielvicente.cryptography_challenge.service;

import org.jasypt.util.text.StrongTextEncryptor;
import org.springframework.stereotype.Service;

@Service
public class CryptoService {

    private static final StrongTextEncryptor encryptor;

    static {
        encryptor = new StrongTextEncryptor();
        encryptor.setPassword(System.getenv("CRYPTO_KEY"));
    }

    public static String encrypt(String data) {
        return encryptor.encrypt(data);
    }

    public static String decrypt(String data) {
        return encryptor.decrypt(data);
    }
}
