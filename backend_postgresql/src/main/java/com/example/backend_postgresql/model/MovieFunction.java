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
@Table(name = "movie_functions")
public class MovieFunction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @Column
    private LocalDate startDate, finishDate;
    @OneToMany(mappedBy = "movieFunction")
    private List<FunctionHallSchedule> scheduleList;

    public MovieFunction(Movie movie, LocalDate startDate, LocalDate finishDate, List<FunctionHallSchedule> scheduleList) {
        this.movie = movie;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.scheduleList = scheduleList;
    }
}
