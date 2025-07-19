package com.workat.tech.practice.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HashingDemo {
    public static void main(String[] args) throws Exception {
        String input = "MyPassword";

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(input.getBytes());

        String hash = Base64.getEncoder().encodeToString(hashBytes);
        System.out.println("Hashed (SHA-256): " + hash);
    }
}
