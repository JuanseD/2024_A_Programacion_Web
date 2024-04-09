package com.example.backend_postgresql.controller;

import com.example.backend_postgresql.model.Hours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.backend_postgresql.repositories.HoursRepository;

import java.util.List;

@RestController
@RequestMapping("/hours")
public class HoursController {

    @Autowired
    private HoursRepository hoursRepository;

    // Crear una nueva hora
    @PostMapping("/createhours")
    public Hours createHours(@RequestBody Hours hours) {
        return hoursRepository.save(hours);
    }

    // Leer todas las horas
    @GetMapping("/allhours")
    public List<Hours> getAllHours() {
        return hoursRepository.findAll();
    }

    // Leer una hora por su ID
    @GetMapping("/searchhours/{id}")
    public Hours getHoursById(@PathVariable Long id) {
        return hoursRepository.findById(id).orElse(null);
    }

    // Actualizar una hora existente
    @PutMapping("/updatehours/{id}")
    public Hours updateHours(@PathVariable Long id, @RequestBody Hours hoursDetails) {
        return hoursRepository.findById(id)
                .map(hours -> hoursRepository.save(hours))
                .orElse(null);
    }

    // Eliminar una hora por su ID
    @DeleteMapping("/deletehours/{id}")
    public void deleteHours(@PathVariable Long id) {
        hoursRepository.deleteById(id);
    }
}

