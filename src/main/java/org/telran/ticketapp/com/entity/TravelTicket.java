package org.telran.ticketapp.com.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity  // объекты этого класса это строки в таблице базы данных
@Table(name = "travel_tickets")
@Getter
@Setter
@NoArgsConstructor
public class TravelTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private double price;

    private double priceByYear; // price_by_year

    @Column(name = "half_price")
    private double priceByHalfYear; // price_by_half_year

    public TravelTicket(String title, String description, double price, double priceByYear) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.priceByYear = priceByYear;
    }
}
