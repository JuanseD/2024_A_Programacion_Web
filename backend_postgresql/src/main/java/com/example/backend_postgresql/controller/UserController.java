package com.example.backend_postgresql.controller;

import com.example.backend_postgresql.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.backend_postgresql.repositories.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Crear un nuevo usuario
    @PostMapping("/createuser")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // Leer todos los usuarios
    @GetMapping("/allusers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Leer un usuario por su ID
    @GetMapping("/searchuser/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Actualizar un usuario existente
    @PutMapping("/updateuser/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userRepository.findById(id)
                .map(user -> userRepository.save(user))
                .orElse(null);
    }

    // Eliminar un usuario por su ID
    @DeleteMapping("/deleteuser/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}

