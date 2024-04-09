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
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "cart")
    private List<Ticket> ticketList;
    @OneToMany(mappedBy = "cart")
    private List<ProductCart> productList;
    @OneToMany(mappedBy = "cart")
    private List<ComboCart> comboList;
    @Column
    private double totalPrice;


    public Cart(User user, List<Ticket> ticketList, List<ProductCart> productList, List<ComboCart> comboList, double totalPrice) {
        this.user = user;
        this.ticketList = ticketList;
        this.productList = productList;
        this.comboList = comboList;
        this.totalPrice = totalPrice;
    }

}
