package com.example.segundo_parcial.service;

import com.example.segundo_parcial.model.LoginHistory;
import com.example.segundo_parcial.model.User;
import com.example.segundo_parcial.repositories.LoginHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoginHistoryService {

    @Autowired
    private LoginHistoryRepository loginHistoryRepository;

    public void saveLoginHistory(User user, Date loginTime) {
        LoginHistory loginHistory = new LoginHistory(user, loginTime);
        loginHistoryRepository.save(loginHistory);
    }
}

