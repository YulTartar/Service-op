package com.example.springdatabasicdemo.services.impl;


import com.example.springdatabasicdemo.dtos.TicketDTO;
import com.example.springdatabasicdemo.dtos.WindowDTO;
import com.example.springdatabasicdemo.models.*;
import com.example.springdatabasicdemo.repositories.ClientRepository;
import com.example.springdatabasicdemo.repositories.QueueRepository;
import com.example.springdatabasicdemo.repositories.TicketRepository;
import com.example.springdatabasicdemo.repositories.WindowRepository;
import com.example.springdatabasicdemo.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private WindowRepository windowRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private QueueRepository queueRepository;

    @Override
    public Ticket issueTicket(Long windowId, Client client) {
        Window window = windowRepository.findById(windowId)
                .orElseThrow(() -> new RuntimeException("Window not found"));


        Queue queue = queueRepository.findByWindow(window);
        if (queue == null) {
            queue = new Queue();
            queue.setWindow(window);
            queueRepository.save(queue);
        }

        int nextTicketNumber = ticketRepository.findByWindow(window).size() + 1;

        Ticket ticket = new Ticket();
        ticket.setTicketNumber(nextTicketNumber);
        ticket.setStatus(TicketStatus.WAITING);
        ticket.setWindow(window);
        ticket.setClient(client);
        ticket.setQueue(queue);


        ticketRepository.save(ticket);


        queue.getTickets().add(ticket);
        queueRepository.save(queue);

        return ticket;
    }
    @Override
    public Optional<TicketDTO> findTicket(Long id) {
        return ticketRepository.findById(id)
                .map(ticket -> {
                    TicketDTO ticketDTO = new TicketDTO();
                    ticketDTO.setId(ticket.getId());
                    ticketDTO.setTicketNumber(ticket.getTicketNumber());
                    ticketDTO.setStatusCode(ticket.getStatus().getCode());
                    ticketDTO.setWindow(new WindowDTO(ticket.getWindow().getId(), ticket.getWindow().getWindowNumber()));
                    return ticketDTO;
                });
    }

    @Override
    public void serveTicket(Long ticketId) {
        // Найти талон по идентификатору
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));


        ticket.setStatus(TicketStatus.SERVED);
        ticketRepository.save(ticket);

        Queue queue = ticket.getQueue();
        if (queue != null) {
            queue.getTickets().remove(ticket);
            queueRepository.save(queue);
        }
    }


    @Override
    public void cancelTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        ticket.setStatus(TicketStatus.CANCELED);
        ticketRepository.save(ticket);

        Queue queue = ticket.getQueue();
        queue.getTickets().remove(ticket);
        queueRepository.save(queue);
    }
}
