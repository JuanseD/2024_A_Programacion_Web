package com.example.backend_postgresql.controller;

import com.example.backend_postgresql.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.backend_postgresql.repositories.TicketRepository;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    // Crear un nuevo ticket
    @PostMapping("/createticket")
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // Leer todos los tickets
    @GetMapping("/alltickets")
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Leer un ticket por su ID
    @GetMapping("/searchticket/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    // Actualizar un ticket existente
    @PutMapping("/updateticket/{id}")
    public Ticket updateTicket(@PathVariable Long id, @RequestBody Ticket ticketDetails) {
        return ticketRepository.findById(id)
                .map(ticket -> ticketRepository.save(ticket))
                .orElse(null);
    }

    // Eliminar un ticket por su ID
    @DeleteMapping("/deleteticket/{id}")
    public void deleteTicket(@PathVariable Long id) {
        ticketRepository.deleteById(id);
    }
}

