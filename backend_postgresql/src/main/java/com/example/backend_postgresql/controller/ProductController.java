package com.example.backend_postgresql.controller;

import com.example.backend_postgresql.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.backend_postgresql.repositories.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // Crear un nuevo producto
    @PostMapping("/createproduct")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // Leer todos los productos
    @GetMapping("/allproducts")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Leer un producto por su ID
    @GetMapping("/searchproduct/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Actualizar un producto existente
    @PutMapping("/updateproduct/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return productRepository.findById(id)
                .map(product -> productRepository.save(product))
                .orElse(null);
    }

    // Eliminar un producto por su ID
    @DeleteMapping("/deleteproduct/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}

