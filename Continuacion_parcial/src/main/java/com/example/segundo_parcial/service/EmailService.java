package com.example.segundo_parcial.service;

import com.example.segundo_parcial.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendLoginEmail(User user, String ipAddress) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Inicio de sesión exitoso");
        message.setText("Estimado " + user.getUsername() + ",\n\nSe ha realizado un inicio de sesión exitoso en su cuenta.\n\nFecha y hora: " + LocalDateTime.now() + "\nIP: " + ipAddress);
        javaMailSender.send(message);
    }
}

