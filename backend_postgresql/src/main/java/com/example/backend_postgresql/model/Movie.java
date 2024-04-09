package com.example.backend_postgresql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int duration;
    @Column
    private String imageUrl, title, director, synopsis, studio;
    @Column
    private LocalDate releaseYear;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public Movie(int id, int duration, String imageUrl, String title, String director, String synopsis, String studio, LocalDate releaseYear, Genre genre) {
        this.duration = duration;
        this.imageUrl = imageUrl;
        this.title = title;
        this.director = director;
        this.synopsis = synopsis;
        this.studio = studio;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }
}
