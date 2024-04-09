package com.example.backend_postgresql.controller;

import com.example.backend_postgresql.model.MovieFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.backend_postgresql.repositories.MovieFunctionRepository;

import java.util.List;

@RestController
@RequestMapping("/movie_functions")
public class MovieFunctionController {

    @Autowired
    private MovieFunctionRepository movieFunctionRepository;

    // Crear una nueva función de película
    @PostMapping("/createmoviefunction")
    public MovieFunction createMovieFunction(@RequestBody MovieFunction movieFunction) {
        return movieFunctionRepository.save(movieFunction);
    }

    // Leer todas las funciones de película
    @GetMapping("/allmoviefunctions")
    public List<MovieFunction> getAllMovieFunctions() {
        return movieFunctionRepository.findAll();
    }

    // Leer una función de película por su ID
    @GetMapping("/searchmoviefunction/{id}")
    public MovieFunction getMovieFunctionById(@PathVariable Long id) {
        return movieFunctionRepository.findById(id).orElse(null);
    }

    // Actualizar una función de película existente
    @PutMapping("/updatemoviefunction/{id}")
    public MovieFunction updateMovieFunction(@PathVariable Long id, @RequestBody MovieFunction movieFunctionDetails) {
        return movieFunctionRepository.findById(id)
                .map(movieFunction -> movieFunctionRepository.save(movieFunction))
                .orElse(null);
    }

    // Eliminar una función de película por su ID
    @DeleteMapping("/deletemoviefunction/{id}")
    public void deleteMovieFunction(@PathVariable Long id) {
        movieFunctionRepository.deleteById(id);
    }
}

