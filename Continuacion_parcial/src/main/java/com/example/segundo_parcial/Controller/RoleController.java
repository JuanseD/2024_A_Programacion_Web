package com.example.segundo_parcial.Controller;

import com.example.segundo_parcial.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import com.example.segundo_parcial.repositories.RoleRepository;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/allroles")
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @GetMapping("/searchrole/{id}")
    public Role getRoleById(@PathVariable Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id));
    }

    @PostMapping("/createrole")
    public Role createRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    @PutMapping("/updaterole/{id}")
    public Role updateRole(@PathVariable Long id, @RequestBody Role roleDetails) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id));

        role.setRoleName(roleDetails.getRoleName());
        return roleRepository.save(role);
    }

    @DeleteMapping("/deleterole/{id}")
    public void deleteRole(@PathVariable Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id));

        roleRepository.delete(role);
    }
}

