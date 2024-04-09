package com.example.backend_postgresql.repositories;

import com.example.backend_postgresql.model.FunctionHallSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FunctionHallScheduleRepository extends JpaRepository<FunctionHallSchedule, Long> {


}
