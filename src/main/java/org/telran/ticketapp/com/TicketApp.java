package org.telran.ticketapp.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketApp {

    // localhost:8080/tickets -> DispatcherServlet(Controller) -> TicketController
    // localhost:8080/users-> DispatcherServlet(Controller) -> UserController
    public static void main(String[] args) {
        SpringApplication.run(TicketApp.class, args);
    }
}