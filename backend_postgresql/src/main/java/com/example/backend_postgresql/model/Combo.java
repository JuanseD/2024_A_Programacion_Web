package com.example.backend_postgresql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "combos")
public class Combo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "combo")
    private List<ProductComboAmount> productList;
    @Column
    private double price, vipPrice;

    public Combo(List<ProductComboAmount> productList, double price, double vipPrice) {
        this.productList = productList;
        this.price = price;
        this.vipPrice = vipPrice;
    }

}
