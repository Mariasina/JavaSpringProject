package com.trevis.startup.example.impl.security;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.function.IntPredicate;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.trevis.startup.example.exceptions.BadHashConfigurationException;
import com.trevis.startup.example.services.PasswordService;

public class PBKDF2PasswordService implements PasswordService {
    public String applyCryptography(String password) throws BadHashConfigurationException {
        SecureRandom random = new SecureRandom();

        byte[] salt = new byte[16];
        random.nextBytes(salt);

        int iterations = 65536;

        String generatedHash;

        try {
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

            byte[] signature = factory.generateSecret(spec).getEncoded();

            generatedHash = String.format("%s:%s:%s", iterations, toHex(salt), toHex(signature));
        } catch (NoSuchAlgorithmException ex) {
            throw new BadHashConfigurationException("Algorithm given in hash configuration doesn't exist.");
        } catch (InvalidKeySpecException ex) {
            throw new BadHashConfigurationException("Generated hash was invalid, likely due to bad configuration of the hasher.");
        }

        return generatedHash;
    }

    @Override
    public Boolean verifyCryptography(String password, String encryptedPassword) throws BadHashConfigurationException {
        String[] params = encryptedPassword.split(":");
        
        int iterations = Integer.parseInt(params[0]);
        byte[] salt = fromHex(params[1]);
        byte[] signature = fromHex(params[2]);
        
        PBEKeySpec spec = new PBEKeySpec(
            password.toCharArray(),
            salt,
            iterations,
            signature.length * 8
        );

        byte[] validationSignature;

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            validationSignature = skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException ex) {
            throw new BadHashConfigurationException("Algorithm given in hash configuration doesn't exist.");
        } catch (InvalidKeySpecException ex) {
            throw new BadHashConfigurationException("Generated hash was invalid, likely due to bad configuration of the hasher.");
        }

        return Arrays.equals(signature, validationSignature);
    }

    @Override
    public int verifyRules(String password) {
        int parametersMet = 1;

        if (password.length() >= 8) parametersMet++;
        
        if (containsLowerCase(password)) parametersMet++;

        if (containsUpperCase(password)) parametersMet++;

        if (containsNumber(password)) parametersMet++;

        return parametersMet;
    }

    private boolean contains(String value, IntPredicate predicate) {
        return value.chars().anyMatch(predicate);
    }

    private boolean containsLowerCase(String value) {
        return contains(
            value,
            i -> Character.isLetter(i) && Character.isLowerCase(i)
        );
    }

    private boolean containsUpperCase(String value) {
        return contains(
            value,
            i -> Character.isLetter(i) && Character.isUpperCase(i)
        );
    }

    private boolean containsNumber(String value) {
        return contains(value, Character::isDigit);
    }

    private static String toHex(byte[] byteArray) {
        BigInteger bi = new BigInteger(1, byteArray);
        String hex = bi.toString(16);

        int paddingLength = (byteArray.length * 2) - hex.length();

        if (paddingLength > 0)
            return String.format("%0" + paddingLength + "d", 0) + hex;
        else
            return hex;
    }

    private static byte[] fromHex(String hex)
    {
        byte[] byteArray = new byte[hex.length() / 2];
        for(int i = 0; i < byteArray.length ;i++)
            byteArray[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        
        return byteArray;
    }
}
