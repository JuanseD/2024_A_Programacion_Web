package com.example.segundo_parcial.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "login_history")
@Getter
@Setter
@NoArgsConstructor
public class LoginHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "login_time")
    private Date loginTime;

    public LoginHistory(User user, Date loginTime) {
        this.user = user;
        this.loginTime = loginTime;
    }
}

