package org.telran.ticketapp.com.service;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.telran.ticketapp.com.entity.TravelTicket;
import org.telran.ticketapp.com.entity.User;
import org.telran.ticketapp.com.repository.UserJpaRepository;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJpaRepository repository;

//    @Autowired
//    private TravelTicketService ticketService;

    @Override
    public List<User> getAll() {
        List<User> all = repository.findAll();
        log.info("All users : {}", all );
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

    @Override
    public User findById(long id) {
        return repository.findById(id).get();
    }
}
