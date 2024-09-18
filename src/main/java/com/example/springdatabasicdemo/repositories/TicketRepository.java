package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Ticket;
import com.example.springdatabasicdemo.models.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByWindow(Window window);

}
