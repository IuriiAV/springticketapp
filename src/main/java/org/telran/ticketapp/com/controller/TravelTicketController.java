package org.telran.ticketapp.com.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telran.ticketapp.com.entity.TravelTicket;
import org.telran.ticketapp.com.model.Ticket;
import org.telran.ticketapp.com.service.TravelTicketService;

import java.util.List;

@RestController
@RequestMapping("/travel_tickets")
//@Slf4j
public class TravelTicketController {

    private static final Logger log = LoggerFactory.getLogger(TravelTicketController.class);

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

    @GetMapping("/search")
    public TravelTicket getByTitle(@RequestParam String title) {
//        log.info("Call method get by title {}", title);
        log.error("Call method get by title {}", title);
        return service.getByTitle(title);
    }

    @GetMapping("/cheapest")
    public TravelTicket getByCheapest() {
        return service.getCheapest();
    }
}
