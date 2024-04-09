package com.example.backend_postgresql.controller;

import com.example.backend_postgresql.model.ProductCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.backend_postgresql.repositories.ProductCartRepository;

import java.util.List;

@RestController
@RequestMapping("/product_carts")
public class ProductCartController {

    @Autowired
    private ProductCartRepository productCartRepository;

    // Crear un nuevo producto en el carrito
    @PostMapping("/createproductcart")
    public ProductCart createProductCart(@RequestBody ProductCart productCart) {
        return productCartRepository.save(productCart);
    }

    // Leer todos los productos en el carrito
    @GetMapping("/allproductcarts")
    public List<ProductCart> getAllProductCarts() {
        return productCartRepository.findAll();
    }

    // Leer un producto en el carrito por su ID
    @GetMapping("/searchproductcart/{id}")
    public ProductCart getProductCartById(@PathVariable Long id) {
        return productCartRepository.findById(id).orElse(null);
    }

    // Actualizar un producto en el carrito existente
    @PutMapping("/updateproductcart/{id}")
    public ProductCart updateProductCart(@PathVariable Long id, @RequestBody ProductCart productCartDetails) {
        return productCartRepository.findById(id)
                .map(productCart -> productCartRepository.save(productCart))
                .orElse(null);
    }

    // Eliminar un producto en el carrito por su ID
    @DeleteMapping("/deleteproductcart/{id}")
    public void deleteProductCart(@PathVariable Long id) {
        productCartRepository.deleteById(id);
    }
}

