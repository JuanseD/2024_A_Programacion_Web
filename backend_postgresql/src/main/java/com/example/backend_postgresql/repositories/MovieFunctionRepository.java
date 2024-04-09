package com.example.backend_postgresql.repositories;

import com.example.backend_postgresql.model.MovieFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieFunctionRepository extends JpaRepository<MovieFunction, Long> {


}
