package org.telran.ticketapp.com.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

    //user | id | name |

    //travel_ticket | id | name | user_id

    //    user
    //   / | \
    //  t1 t2 t3
    // select t1.* from user_info  t1 inner join travel_ticket t2
    // on t1.id = t2.user_id

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<TravelTicket> travelTicket = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<Order> orders = new HashSet<>();

}
