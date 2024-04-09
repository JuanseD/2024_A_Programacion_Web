package com.example.backend_postgresql.controller;

import com.example.backend_postgresql.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.backend_postgresql.repositories.CartRepository;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    // Crear un nuevo carrito
    @PostMapping("/createcart")
    public Cart createCart(@RequestBody Cart cart) {
        return cartRepository.save(cart);
    }

    // Leer todos los carritos
    @GetMapping("/allcarts")
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    // Leer un carrito por su ID
    @GetMapping("/searchcart/{id}")
    public Cart getCartById(@PathVariable Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    // Actualizar un carrito existente
    @PutMapping("/updatecart/{id}")
    public Cart updateCart(@PathVariable Long id, @RequestBody Cart cartDetails) {
        return cartRepository.findById(id)
                .map(cart -> {
                    cart.setUser(cartDetails.getUser());
                    // Actualizar otros campos según sea necesario
                    return cartRepository.save(cart);
                })
                .orElse(null);
    }

    // Eliminar un carrito por su ID
    @DeleteMapping("/deletecart/{id}")
    public void deleteCart(@PathVariable Long id) {
        cartRepository.deleteById(id);
    }
}
