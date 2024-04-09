package com.example.backend_postgresql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "hours")
public class Hours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "function_hall_schedule_id")
    private FunctionHallSchedule functionHallSchedule;
    @Column
    private LocalTime startHour, finishHour;

    public Hours(int id, FunctionHallSchedule functionHallSchedule, LocalTime startHour, LocalTime finishHour) {
        this.functionHallSchedule = functionHallSchedule;
        this.startHour = startHour;
        this.finishHour = finishHour;
    }

}
