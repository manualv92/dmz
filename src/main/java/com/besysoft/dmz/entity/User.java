package com.besysoft.dmz.entity;

import com.besysoft.dmz.security.Token;

/**
 * Created by manua on 15/7/2016.
 */
public class User {
    private String username, password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    /*
    public String toJsonString() {
        //return "{\"username\": \"" + getUsername() + "\", \"password\": \""+ getPassword() + "\"}";
        return "{\"username\": \"" + getUsername() + "\", \"password\": \""+ getPassword() + "\"}";
    }

    public String getUserToken() {
        return new Token(this).getJwt();
    }*/
}
