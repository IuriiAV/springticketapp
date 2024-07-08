package org.telran.ticketapp.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.ticketapp.com.entity.TravelTicket;
import org.telran.ticketapp.com.entity.User;
import org.telran.ticketapp.com.repository.UserJpaRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJpaRepository repository;

//    @Autowired
//    private TravelTicketService ticketService;

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public User create(User user) {
//        TravelTicket travelTicket = user.getTravelTicket();
//        ticketService.create(travelTicket);
        return repository.save(user);
    }
}
