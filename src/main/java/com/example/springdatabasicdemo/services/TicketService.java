package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.TicketDTO;
import com.example.springdatabasicdemo.models.Client;
import com.example.springdatabasicdemo.models.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    Ticket issueTicket(Long windowId, Client client);

    Optional<TicketDTO> findTicket(Long id);

    List<TicketDTO> getAllTickets();

    void serveTicket(Long ticketId);

    void cancelTicket(Long ticketId);
}
