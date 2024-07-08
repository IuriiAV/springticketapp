package org.telran.ticketapp.com.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_info")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "travel_id", referencedColumnName = "id")
    private TravelTicket travelTicket;

}
