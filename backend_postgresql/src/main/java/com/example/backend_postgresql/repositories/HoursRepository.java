package com.example.backend_postgresql.repositories;

import com.example.backend_postgresql.model.Hours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoursRepository extends JpaRepository<Hours, Long> {


}
