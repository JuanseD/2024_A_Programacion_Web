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
@Table(name = "function_hall_schedules")
public class FunctionHallSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_Function_id")
    private MovieFunction movieFunction;
    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;
    @Column
    private LocalDate startDate, finishDate;
    @OneToMany(mappedBy = "functionHallSchedule")
    private List<Hours> hoursList;

    public FunctionHallSchedule(MovieFunction movieFunction, Hall hall, LocalDate startDate, LocalDate finishDate, List<Hours> hoursList) {
        this.movieFunction = movieFunction;
        this.hall = hall;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.hoursList = hoursList;
    }

}
