package com.jid.util;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.NoSuchAlgorithmException;

/**
 * Created by igor on 28/11/15.
 */
public class JidPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return null;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        try {
            return Sha.hash256(rawPassword.toString()).equals(encodedPassword);
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }
}
