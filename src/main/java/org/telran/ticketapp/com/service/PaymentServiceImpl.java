package org.telran.ticketapp.com.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telran.ticketapp.com.entity.Order;
import org.telran.ticketapp.com.entity.Payment;
import org.telran.ticketapp.com.model.OrderState;
import org.telran.ticketapp.com.repository.PaymentRepository;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;
    private final OrderService orderService;

    @Override
    public void makePayment(Long orderId) {
        Order order = orderService.getByid(orderId);
        order.setState(OrderState.PAID);
        Payment payment = Payment.builder()
                .paymentDate(new Date())
                .order(order)
                .build();
        repository.save(payment);
    }
}
