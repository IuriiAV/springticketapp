package org.telran.ticketapp.com.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_info")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private String role = "ROLE_USER";

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

    //OneToMany ->Unidirectional
    //user -> order -> travel_card

    //OneToMany ->Bidirectional
    //user <-> order -> travel_card

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    //@JoinColumn(name = "user_id")
    @JsonManagedReference
    private Set<Order> orders = new HashSet<>();

    public User(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
}
