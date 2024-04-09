package com.example.backend_postgresql.controller;

import com.example.backend_postgresql.model.ComboCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.backend_postgresql.repositories.ComboCartRepository;

import java.util.List;

@RestController
@RequestMapping("/combo_carts")
public class ComboCartController {

    @Autowired
    private ComboCartRepository comboCartRepository;

    // Crear un nuevo ComboCart
    @PostMapping("/createcombocart")
    public ComboCart createComboCart(@RequestBody ComboCart comboCart) {
        return comboCartRepository.save(comboCart);
    }

    // Leer todos los comboCarts
    @GetMapping("/allcombocarts")
    public List<ComboCart> getAllComboCarts() {
        return comboCartRepository.findAll();
    }

    // Leer un ComboCart por su ID
    @GetMapping("/searchcombocart/{id}")
    public ComboCart getComboCartById(@PathVariable Long id) {
        return comboCartRepository.findById(id).orElse(null);
    }

    // Actualizar un ComboCart existente
    @PutMapping("/updatecombocart/{id}")
    public ComboCart updateComboCart(@PathVariable Long id, @RequestBody ComboCart comboCartDetails) {
        return comboCartRepository.findById(id)
                .map(comboCart -> comboCartRepository.save(comboCart))
                .orElse(null);
    }

    // Eliminar un ComboCart por su ID
    @DeleteMapping("/deletecombocart/{id}")
    public void deleteComboCart(@PathVariable Long id) {
        comboCartRepository.deleteById(id);
    }
}
