package com.example.segundo_parcial.Controller;

import com.example.segundo_parcial.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import com.example.segundo_parcial.repositories.UserRepository;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/allusers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/searchuser/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @PostMapping("/createuser")
    public User createUser(@RequestBody User user) {
        user.setPassword(user.getPassword());

        return userRepository.save(user);
    }

    @PutMapping("/updateuser/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        user.setUsername(userDetails.getUsername());
        return userRepository.save(user);
    }

    @DeleteMapping("/deleteuser/{id}")
    public void deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        userRepository.delete(user);
    }
}


