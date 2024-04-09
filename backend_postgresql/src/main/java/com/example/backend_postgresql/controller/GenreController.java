package com.example.backend_postgresql.controller;

import com.example.backend_postgresql.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.backend_postgresql.repositories.GenreRepository;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    // Crear un nuevo género
    @PostMapping("/creategenre")
    public Genre createGenre(@RequestBody Genre genre) {
        return genreRepository.save(genre);
    }

    // Leer todos los géneros
    @GetMapping("/allgenres")
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    // Leer un género por su ID
    @GetMapping("/searchgenre/{id}")
    public Genre getGenreById(@PathVariable Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    // Actualizar un género existente
    @PutMapping("/updategenre/{id}")
    public Genre updateGenre(@PathVariable Long id, @RequestBody Genre genreDetails) {
        return genreRepository.findById(id)
                .map(genre -> genreRepository.save(genre))
                .orElse(null);
    }

    // Eliminar un género por su ID
    @DeleteMapping("/deletegenre/{id}")
    public void deleteGenre(@PathVariable Long id) {
        genreRepository.deleteById(id);
    }
}

