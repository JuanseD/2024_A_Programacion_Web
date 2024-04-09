package com.example.backend_postgresql.controller;

import com.example.backend_postgresql.model.Hall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.backend_postgresql.repositories.HallRepository;

import java.util.List;

@RestController
@RequestMapping("/halls")
public class HallController {

    @Autowired
    private HallRepository hallRepository;

    // Crear una nueva sala
    @PostMapping("/createhall")
    public Hall createHall(@RequestBody Hall hall) {
        return hallRepository.save(hall);
    }

    // Leer todas las salas
    @GetMapping("/allhalls")
    public List<Hall> getAllHalls() {
        return hallRepository.findAll();
    }

    // Leer una sala por su ID
    @GetMapping("/searchhall/{id}")
    public Hall getHallById(@PathVariable Long id) {
        return hallRepository.findById(id).orElse(null);
    }

    // Actualizar una sala existente
    @PutMapping("/updatehall/{id}")
    public Hall updateHall(@PathVariable Long id, @RequestBody Hall hallDetails) {
        return hallRepository.findById(id)
                .map(hall -> hallRepository.save(hall))
                .orElse(null);
    }

    // Eliminar una sala por su ID
    @DeleteMapping("/deletehall/{id}")
    public void deleteHall(@PathVariable Long id) {
        hallRepository.deleteById(id);
    }
}
