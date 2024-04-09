package com.example.backend_postgresql.controller;

import com.example.backend_postgresql.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.backend_postgresql.repositories.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Crear un nuevo empleado
    @PostMapping("/createemployee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // Leer todos los empleados
    @GetMapping("/allemployees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Leer un empleado por su ID
    @GetMapping("/searchemployee/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // Actualizar un empleado existente
    @PutMapping("/updateemployee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        return employeeRepository.findById(id)
                .map(employee -> employeeRepository.save(employee))
                .orElse(null);
    }

    // Eliminar un empleado por su ID
    @DeleteMapping("/deleteemployee/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}

