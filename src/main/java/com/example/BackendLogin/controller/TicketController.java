package com.example.BackendLogin.controller;

import com.example.BackendLogin.model.CreateTicket;
import com.example.BackendLogin.model.User;
import com.example.BackendLogin.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/add")
    public ResponseEntity<CreateTicket> addticket(@RequestBody CreateTicket createTicket) {
        CreateTicket saveticket = ticketService.saveticket(createTicket);
        return ResponseEntity.ok(saveticket);
    }
    @GetMapping
    public ResponseEntity<List<CreateTicket>> getAllTickets(){
        List<CreateTicket> ticket = ticketService.getAllTickets();
        return ResponseEntity.ok(ticket);
    }
}
