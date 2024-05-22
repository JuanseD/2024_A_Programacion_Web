package com.example.segundo_parcial.Controller;

import com.example.segundo_parcial.model.User;
import com.example.segundo_parcial.service.LoginHistoryService;
import com.example.segundo_parcial.service.LoginRequest;
import com.example.segundo_parcial.service.LoginResponse;
import com.example.segundo_parcial.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/users")
public class LoginController {

    private final LoginService loginService;
    private final LoginHistoryService loginHistoryService;

    @Autowired
    public LoginController(LoginService loginService, LoginHistoryService loginHistoryService) {
        this.loginService = loginService;
        this.loginHistoryService = loginHistoryService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        String ipAddress = request.getRemoteAddr();

        LoginResponse response = loginService.login(loginRequest.getUsername(), loginRequest.getPassword(), ipAddress);

        if (response != null && "Ingreso con éxito".equals(response.getMessage())) {
            User user = loginService.getUserByUsername(loginRequest.getUsername());
            loginHistoryService.saveLoginHistory(user, new Date());
        }

        return response;
    }
}





