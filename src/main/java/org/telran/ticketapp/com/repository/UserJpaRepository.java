package org.telran.ticketapp.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telran.ticketapp.com.entity.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {
}
