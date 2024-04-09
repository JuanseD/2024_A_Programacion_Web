package com.example.backend_postgresql.controller;

import com.example.backend_postgresql.model.HallChair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.backend_postgresql.repositories.HallChairRepository;

import java.util.List;

@RestController
@RequestMapping("/hall_chairs")
public class HallChairController {

    @Autowired
    private HallChairRepository hallChairRepository;

    // Crear una nueva silla de sala
    @PostMapping("/createhallchair")
    public HallChair createHallChair(@RequestBody HallChair hallChair) {
        return hallChairRepository.save(hallChair);
    }

    // Leer todas las sillas de sala
    @GetMapping("/allhallchairs")
    public List<HallChair> getAllHallChairs() {
        return hallChairRepository.findAll();
    }

    // Leer una silla de sala por su ID
    @GetMapping("/searchhallchair/{id}")
    public HallChair getHallChairById(@PathVariable Long id) {
        return hallChairRepository.findById(id).orElse(null);
    }

    // Actualizar una silla de sala existente
    @PutMapping("/updatehallchair/{id}")
    public HallChair updateHallChair(@PathVariable Long id, @RequestBody HallChair hallChairDetails) {
        return hallChairRepository.findById(id)
                .map(hallChair -> hallChairRepository.save(hallChair))
                .orElse(null);
    }

    // Eliminar una silla de sala por su ID
    @DeleteMapping("/deletehallchair/{id}")
    public void deleteHallChair(@PathVariable Long id) {
        hallChairRepository.deleteById(id);
    }
}

