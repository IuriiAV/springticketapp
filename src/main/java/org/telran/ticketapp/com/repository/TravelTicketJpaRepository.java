package org.telran.ticketapp.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telran.ticketapp.com.entity.TravelTicket;

public interface TravelTicketJpaRepository extends JpaRepository<TravelTicket, Long> {

}
