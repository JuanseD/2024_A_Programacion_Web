package com.example.segundo_parcial.service;

import com.example.segundo_parcial.model.User;
import com.example.segundo_parcial.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Date;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private LoginHistoryService loginHistoryService;

    public LoginResponse login(String username, String password, String ipAddress) {
        User user = userRepository.findByUsername(username);
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            System.out.println("El usuario " + username + " ha iniciado sesión desde la dirección IP: " + ipAddress);
            emailService.sendLoginEmail(user, ipAddress);

            loginHistoryService.saveLoginHistory(user, new Date());

            String token = JWTUtil.generateToken(username);
            return new LoginResponse(token, "Ingreso con éxito");
        } else {
            return new LoginResponse(null, "Ingreso fallido");
        }
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}







