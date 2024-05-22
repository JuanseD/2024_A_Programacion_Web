package com.example.segundo_parcial.service;

import lombok.Data;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
