package com.workat.tech.practice.security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class EncryptionUsingAES {
    public static void main(String[] args) throws Exception {
        String plainText = "HelloWorld";

        // Generate AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();

        // Encrypt
        Cipher encryptCipher = Cipher.getInstance("AES");
        encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = encryptCipher.doFinal(plainText.getBytes());
        String encrypted = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted: " + encrypted);

        // Decrypt
        Cipher decryptCipher = Cipher.getInstance("AES");
        decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = decryptCipher.doFinal(Base64.getDecoder().decode(encrypted));
        String decrypted = new String(decryptedBytes);
        System.out.println("Decrypted: " + decrypted);
    }
}
