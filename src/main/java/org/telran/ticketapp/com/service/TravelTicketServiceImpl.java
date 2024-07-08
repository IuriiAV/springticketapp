package org.telran.ticketapp.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.ticketapp.com.entity.TravelTicket;
import org.telran.ticketapp.com.repository.TravelTicketJpaRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TravelTicketServiceImpl implements TravelTicketService {

    //save,findOne,findAll,findById,delete
    @Autowired
    private TravelTicketJpaRepository repository;

    @Override
    public List<TravelTicket> getAll() {
        return repository.findAll();
    }

    @Override
    public TravelTicket getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No ticket with id " + id));
    }

    @Override
    public TravelTicket create(TravelTicket ticket) {
        TravelTicket entity = repository.save(ticket);
        return entity;
    }

    @Override
    public void delete(Long id) {
        TravelTicket entity = getById(id);
        repository.delete(entity);
    }

    @Override
    public TravelTicket getByTitle(String title) {
        return repository.findByTitle(title);
    }

    @Override
    public TravelTicket getCheapest() {
        return repository.getCheapestTicket();
    }
}
