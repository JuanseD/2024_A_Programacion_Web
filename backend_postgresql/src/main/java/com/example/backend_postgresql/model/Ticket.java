package com.example.backend_postgresql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int column_number;
    @Column
    private char row;
    @ManyToOne
    @JoinColumn(name = "function_hall_schedule_id")
    private FunctionHallSchedule functionHallSchedule;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    @Column
    private double price;

    public Ticket(int column_number, char row, FunctionHallSchedule functionHallSchedule, Cart cart, double price) {
        this.column_number = column_number;
        this.row = row;
        this.functionHallSchedule = functionHallSchedule;
        this.cart = cart;
        this.price = price;
    }
}
