package org.telran.ticketapp.com.service;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.telran.ticketapp.com.entity.TravelTicket;
import org.telran.ticketapp.com.entity.User;
import org.telran.ticketapp.com.exception.NoUniqueUserEmailException;
import org.telran.ticketapp.com.exception.TravelTicketNotFoundException;
import org.telran.ticketapp.com.exception.UserNotFoundException;
import org.telran.ticketapp.com.repository.UserJpaRepository;

import java.util.List;
import java.util.Optional;

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
        log.info("All users : {}", all);
        return repository.findAll();
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public User create(User user) {
        Optional<User> userFromDb = findByEmail(user.getEmail());
        if (userFromDb.isPresent()) {
            throw new NoUniqueUserEmailException("User with email " + user.getEmail() + "" +
                    " already exists");
        }

//        TravelTicket travelTicket = user.getTravelTicket();
//        ticketService.create(travelTicket);
        return repository.save(user);
    }

    @Override
    public User findById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("No user with id " + id));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
