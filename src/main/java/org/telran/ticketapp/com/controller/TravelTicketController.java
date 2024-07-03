package org.telran.ticketapp.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telran.ticketapp.com.entity.TravelTicket;
import org.telran.ticketapp.com.model.Ticket;
import org.telran.ticketapp.com.service.TravelTicketService;

import java.util.List;

@RestController
@RequestMapping("/travel_tickets")
public class TravelTicketController {

    @Autowired
    private TravelTicketService service;

    @GetMapping
    public List<TravelTicket> getAll() {
        return service.getAll();
    }

    @PostMapping
    public TravelTicket create(@RequestBody TravelTicket travelTicket) {
        return service.create(travelTicket);
    }

}
