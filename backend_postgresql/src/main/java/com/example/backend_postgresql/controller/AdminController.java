package com.example.backend_postgresql.controller;

import com.example.backend_postgresql.repositories.AdminRepository;
import com.example.backend_postgresql.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    // Crear un nuevo admin
    @PostMapping("/createadmin")
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminRepository.save(admin);
    }

    // Leer todos los admins
    @GetMapping("/alladmins")
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Leer un admin por su ID
    @GetMapping("/searchadmin/{id}")
    public Admin getAdminById(@PathVariable Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    // Actualizar un admin existente
    @PutMapping("/updateadmin/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails) {
        return adminRepository.findById(id)
                .map(admin -> {
                    admin.setUser(adminDetails.getUser());
                    admin.setCreationDate(adminDetails.getCreationDate());
                    return adminRepository.save(admin);
                })
                .orElse(null);
    }

    // Eliminar un admin por su ID
    @DeleteMapping("/deleteadmin/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminRepository.deleteById(id);
    }
}
