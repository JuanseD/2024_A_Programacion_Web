package com.example.backend_postgresql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    protected boolean disableStatus, vipStatus;
    @Column
    protected String name, address, email, phone, billingInfo;
    @Column
    protected LocalDate creationDate;
    @OneToMany(mappedBy = "user")
    protected List<Cart> cartList;

    public User(boolean disableStatus, boolean vipStatus, String name, String address, String email, String phone, String billingInfo, LocalDate creationDate, List<Cart> cartList) {
        this.disableStatus = disableStatus;
        this.vipStatus = vipStatus;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.billingInfo = billingInfo;
        this.creationDate = creationDate;
        this.cartList = cartList;
    }
}
