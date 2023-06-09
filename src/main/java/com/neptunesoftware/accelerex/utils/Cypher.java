package com.neptunesoftware.accelerex.utils;

import jakarta.xml.bind.DatatypeConverter;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class Cypher {
    private static final String KEY = "NeptuneMbranch01"; // 128 bit encryption key
    private static final String ALGORITHM = "AES";

    public static String deCypher(String encryptedText) {
        String decrypted = "";
        try {
            // Create key and cipher
            Key aesKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            // decrypt the text
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            byte[] decodedText = DatatypeConverter.parseBase64Binary(encryptedText);
            decrypted = new String(cipher.doFinal(decodedText));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException |
                 BadPaddingException e) {
            //System.out.println("Error is "+e.getMessage());
        }
        return decrypted;
    }

    public static String enCrypt(String originalText) {
        String encodedText = "";
        try {
            // Create key and cipher
            Key aesKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);

            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(originalText.getBytes());
            encodedText = DatatypeConverter.printBase64Binary(encrypted);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException |
                 BadPaddingException e) {
            System.out.println("Error is " + e.getMessage());
        }
        return encodedText;
    }
}
