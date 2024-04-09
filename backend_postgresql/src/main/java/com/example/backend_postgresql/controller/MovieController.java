package com.example.backend_postgresql.controller;

import com.example.backend_postgresql.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.backend_postgresql.repositories.MovieRepository;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    // Crear una nueva película
    @PostMapping("/createmovie")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    // Leer todas las películas
    @GetMapping("/allmovies")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Leer una película por su ID
    @GetMapping("/searchmovie/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    // Actualizar una película existente
    @PutMapping("/updatemovie/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movieDetails) {
        return movieRepository.findById(id)
                .map(movie -> movieRepository.save(movie))
                .orElse(null);
    }

    // Eliminar una película por su ID
    @DeleteMapping("/deletemovie/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieRepository.deleteById(id);
    }
}

