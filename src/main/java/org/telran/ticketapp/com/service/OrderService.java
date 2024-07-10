package org.telran.ticketapp.com.service;

import org.telran.ticketapp.com.entity.Order;

import java.util.List;

public interface OrderService {

    Order add(Order order, Long userId);

    List<Order> getAll();

    Order getByid(Long orderId);
}
