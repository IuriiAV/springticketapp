package org.telran.ticketapp.com.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telran.ticketapp.com.entity.Order;
import org.telran.ticketapp.com.entity.User;
import org.telran.ticketapp.com.model.OrderState;
import org.telran.ticketapp.com.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;

//    public OrderServiceImpl(OrderRepository orderRepository) {
//        this.orderRepository = orderRepository;
//    }

    @Override
    public Order add(Order order, Long userId) {
        User user = userService.findById(userId);
        order.setUser(user);
        order.setState(OrderState.UNPAID);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getByid(Long orderId) {
        return orderRepository.findById(orderId).get();
    }
}
