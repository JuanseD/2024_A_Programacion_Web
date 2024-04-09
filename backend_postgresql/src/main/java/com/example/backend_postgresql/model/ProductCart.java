package com.example.backend_postgresql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "product_carts")
public class ProductCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int amount;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column
    private double totalPrice;

    public ProductCart(int amount, Cart cart, Product product, double totalPrice) {
        this.amount = amount;
        this.cart = cart;
        this.product = product;
        this.totalPrice = totalPrice;
    }

}
