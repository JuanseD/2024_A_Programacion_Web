package com.example.segundo_parcial.Controller;

import com.example.segundo_parcial.model.LoginHistory;
import com.example.segundo_parcial.repositories.LoginHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login_historys")
public class LoginHistoryController {

    @Autowired
    private LoginHistoryRepository loginHistoryRepository;

    @GetMapping("/allloginhistorys")
    public List<LoginHistory> getAllLoginHistories() {
        return loginHistoryRepository.findAll();
    }

    @GetMapping("/searchloginhistory/{id}")
    public LoginHistory getLoginHistoryById(@PathVariable Long id) {
        return loginHistoryRepository.findById(id).orElse(null);
    }

    @PostMapping("/createloginhistory")
    public LoginHistory addLoginHistory(@RequestBody LoginHistory loginHistory) {
        return loginHistoryRepository.save(loginHistory);
    }

    @PutMapping("/updateloginhistory/{id}")
    public LoginHistory updateLoginHistory(@PathVariable Long id, @RequestBody LoginHistory updatedLoginHistory) {
        updatedLoginHistory.setId(id);
        return loginHistoryRepository.save(updatedLoginHistory);
    }

    @DeleteMapping("/deleteloginhistory/{id}")
    public void deleteLoginHistory(@PathVariable Long id) {
        loginHistoryRepository.deleteById(id);
    }
}

