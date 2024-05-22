package com.example.segundo_parcial.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private String message;

    public LoginResponse(String message) {
        this.message = message;
        this.token = null;
    }
}

