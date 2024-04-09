package com.example.backend_postgresql.controller;

import com.example.backend_postgresql.model.ProductComboAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.backend_postgresql.repositories.ProductComboAmountRepository;

import java.util.List;

@RestController
@RequestMapping("/product_combo_amounts")
public class ProductComboAmountController {

    @Autowired
    private ProductComboAmountRepository productComboAmountRepository;

    // Crear un nuevo producto en el combo
    @PostMapping("/createproductcomboamount")
    public ProductComboAmount createProductComboAmount(@RequestBody ProductComboAmount productComboAmount) {
        return productComboAmountRepository.save(productComboAmount);
    }

    // Leer todos los productos en el combo
    @GetMapping("/allproductcomboamounts")
    public List<ProductComboAmount> getAllProductComboAmounts() {
        return productComboAmountRepository.findAll();
    }

    // Leer un producto en el combo por su ID
    @GetMapping("/searchproductcomboamount/{id}")
    public ProductComboAmount getProductComboAmountById(@PathVariable Long id) {
        return productComboAmountRepository.findById(id).orElse(null);
    }

    // Actualizar un producto en el combo existente
    @PutMapping("/updateproductcomboamount/{id}")
    public ProductComboAmount updateProductComboAmount(@PathVariable Long id, @RequestBody ProductComboAmount productComboAmountDetails) {
        return productComboAmountRepository.findById(id)
                .map(productComboAmount -> productComboAmountRepository.save(productComboAmount))
                .orElse(null);
    }

    // Eliminar un producto en el combo por su ID
    @DeleteMapping("/deleteproductcomboamount/{id}")
    public void deleteProductComboAmount(@PathVariable Long id) {
        productComboAmountRepository.deleteById(id);
    }
}

