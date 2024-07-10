package org.telran.ticketapp.com.service;

import org.telran.ticketapp.com.entity.Order;

public interface OrderService {

    Order add(Order order, Long userId);
}
