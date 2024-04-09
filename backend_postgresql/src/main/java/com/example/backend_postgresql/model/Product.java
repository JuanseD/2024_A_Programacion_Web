package com.example.backend_postgresql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int amount;
    @Column
    private String name;
    @Column
    private double price, vipPrice;

    public Product(int amount, String name, double price, double vipPrice) {
        this.amount = amount;
        this.name = name;
        this.price = price;
        this.vipPrice = vipPrice;
    }
}
