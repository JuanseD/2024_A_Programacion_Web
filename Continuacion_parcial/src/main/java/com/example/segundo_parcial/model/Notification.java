package com.example.segundo_parcial.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notificationId")
    private Long notificationId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "title")
    private String title;

    @Column(name = "message")
    private String message;

    @Column(name = "timestamp")
    private Date timestamp;

    public Notification(User user, String title, String message, Date timestamp) {
        this.user = user;
        this.title = title;
        this.message = message;
        this.timestamp = timestamp;
    }
}

