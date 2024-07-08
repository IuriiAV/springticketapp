package org.telran.ticketapp.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.telran.ticketapp.com.entity.TravelTicket;

import java.util.List;

public interface TravelTicketJpaRepository extends JpaRepository<TravelTicket, Long> {

    TravelTicket findByTitle(String title);

    //select * from travel_tickets where title = title
    List<TravelTicket> findAllByTitle(String title);

    @Query("SELECT t FROM TravelTicket t ORDER BY t.price LIMIT 1")
    TravelTicket getCheapestTicket();
}
