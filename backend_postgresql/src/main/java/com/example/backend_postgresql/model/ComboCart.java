package com.example.backend_postgresql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "combo_carts")
public class ComboCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int amount;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    @ManyToOne
    @JoinColumn(name = "combo_id")
    private Combo combo;
    @Column
    private double totalPrice;

    public ComboCart(int amount, Cart cart, Combo combo, double totalPrice) {
        this.amount = amount;
        this.cart = cart;
        this.combo = combo;
        this.totalPrice = totalPrice;
    }
}
