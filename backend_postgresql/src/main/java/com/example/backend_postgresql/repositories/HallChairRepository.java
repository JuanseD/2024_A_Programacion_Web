package com.example.backend_postgresql.repositories;

import com.example.backend_postgresql.model.HallChair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallChairRepository extends JpaRepository<HallChair, Long> {


}
