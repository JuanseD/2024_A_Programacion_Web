package com.example.backend_postgresql.controller;

import com.example.backend_postgresql.model.FunctionHallSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.backend_postgresql.repositories.FunctionHallScheduleRepository;

import java.util.List;

@RestController
@RequestMapping("/function_hall_schedules")
public class FunctionHallScheduleController {

    @Autowired
    private FunctionHallScheduleRepository functionHallScheduleRepository;

    // Crear un nuevo horario de sala de funciones
    @PostMapping("/createfunctionhallschedule")
    public FunctionHallSchedule createFunctionHallSchedule(@RequestBody FunctionHallSchedule functionHallSchedule) {
        return functionHallScheduleRepository.save(functionHallSchedule);
    }

    // Leer todos los horarios de sala de funciones
    @GetMapping("/allfunctionhallschedules")
    public List<FunctionHallSchedule> getAllFunctionHallSchedules() {
        return functionHallScheduleRepository.findAll();
    }

    // Leer un horario de sala de funciones por su ID
    @GetMapping("/searchfunctionhallschedule/{id}")
    public FunctionHallSchedule getFunctionHallScheduleById(@PathVariable Long id) {
        return functionHallScheduleRepository.findById(id).orElse(null);
    }

    // Actualizar un horario de sala de funciones existente
    @PutMapping("/updatefunctionhallschedule/{id}")
    public FunctionHallSchedule updateFunctionHallSchedule(@PathVariable Long id, @RequestBody FunctionHallSchedule functionHallScheduleDetails) {
        return functionHallScheduleRepository.findById(id)
                .map(functionHallSchedule -> functionHallScheduleRepository.save(functionHallSchedule))
                .orElse(null);
    }

    // Eliminar un horario de sala de funciones por su ID
    @DeleteMapping("/deletefunctionhallschedule/{id}")
    public void deleteFunctionHallSchedule(@PathVariable Long id) {
        functionHallScheduleRepository.deleteById(id);
    }
}
