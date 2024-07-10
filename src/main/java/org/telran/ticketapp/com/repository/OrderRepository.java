package org.telran.ticketapp.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telran.ticketapp.com.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
