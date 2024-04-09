package com.example.backend_postgresql.controller;

import com.example.backend_postgresql.model.Combo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.backend_postgresql.repositories.ComboRepository;

import java.util.List;

@RestController
@RequestMapping("/combos")
public class ComboController {

    @Autowired
    private ComboRepository comboRepository;

    // Crear un nuevo combo
    @PostMapping("/createcombo")
    public Combo createCombo(@RequestBody Combo combo) {
        return comboRepository.save(combo);
    }

    // Leer todos los combos
    @GetMapping("/allcombos")
    public List<Combo> getAllCombos() {
        return comboRepository.findAll();
    }

    // Leer un combo por su ID
    @GetMapping("/searchcombo/{id}")
    public Combo getComboById(@PathVariable Long id) {
        return comboRepository.findById(id).orElse(null);
    }

    // Actualizar un combo existente
    @PutMapping("/updatecombo/{id}")
    public Combo updateCombo(@PathVariable Long id, @RequestBody Combo comboDetails) {
        return comboRepository.findById(id)
                .map(combo -> comboRepository.save(combo))
                .orElse(null);
    }

    // Eliminar un combo por su ID
    @DeleteMapping("deletecombo/{id}")
    public void deleteCombo(@PathVariable Long id) {
        comboRepository.deleteById(id);
    }
}
