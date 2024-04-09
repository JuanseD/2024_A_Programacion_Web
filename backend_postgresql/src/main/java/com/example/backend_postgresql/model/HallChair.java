package com.example.backend_postgresql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "hall_chairs")
public class HallChair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;
    @Column
    private char row;
    @Column
    private int column_number;
    @Column
    private boolean isVip, isOccupied, isDamaged;
    @Column
    private double chairPrice, vipChairPrice;

    public HallChair(Hall hall, char row, int column_number, boolean isVip, boolean isOccupied, boolean isDamaged, double chairPrice, double vipChairPrice) {
        this.hall = hall;
        this.row = row;
        this.column_number = column_number;
        this.isVip = isVip;
        this.isOccupied = isOccupied;
        this.isDamaged = isDamaged;
        this.chairPrice = chairPrice;
        this.vipChairPrice = vipChairPrice;
    }
}
