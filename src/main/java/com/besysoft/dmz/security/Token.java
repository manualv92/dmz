package com.besysoft.dmz.security;

import com.besysoft.dmz.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Arrays;

/**
* Created by lzielinski on 18/07/2016.
*/
public class Token {

private byte[] key;
private String jwt;
private final String salt = "besy1234";

public Token(User user) {

    try {
        key = (salt + user.getUsername() + user.getPassword()).getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-512");
        key = sha.digest(key);
        key = Arrays.copyOf(key, 16);

    } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
        e.printStackTrace();
    }


    this.jwt = Jwts.builder()
            .setSubject(user.getUsername())
            .signWith(SignatureAlgorithm.HS512, key)
            .compact();
}

public String getJwt() {
    return jwt;
}

public boolean verify() {
    System.out.println(Jwts.parser().setSigningKey(this.key).parseClaimsJws(this.jwt).getBody().getSubject());
    return false;
}
}
