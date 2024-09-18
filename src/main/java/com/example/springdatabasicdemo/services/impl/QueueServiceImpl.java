package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.QueueDTO;
import com.example.springdatabasicdemo.dtos.TicketDTO;
import com.example.springdatabasicdemo.dtos.WindowDTO;
import com.example.springdatabasicdemo.models.Queue;
import com.example.springdatabasicdemo.models.Window;
import com.example.springdatabasicdemo.repositories.QueueRepository;
import com.example.springdatabasicdemo.repositories.WindowRepository;
import com.example.springdatabasicdemo.services.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QueueServiceImpl implements QueueService {

    @Autowired
    private QueueRepository queueRepository;

    @Autowired
    private WindowRepository windowRepository;

    @Override
    public QueueDTO createQueueForWindow(Long windowId) {
        Window window = windowRepository.findById(windowId)
                .orElseThrow(() -> new RuntimeException("Window not found"));

        Queue queue = queueRepository.findByWindow(window);
        if (queue == null) {
            queue = new Queue();
            queue.setWindow(window);
            queue = queueRepository.save(queue);
        }

        WindowDTO windowDTO = new WindowDTO(window.getId(), window.getWindowNumber());

        List<TicketDTO> ticketDTOs = queue.getTickets().stream()
                .map(ticket -> new TicketDTO(ticket.getId(), ticket.getTicketNumber(), ticket.getStatus().getCode(), windowDTO))
                .collect(Collectors.toList());

        return new QueueDTO(queue.getId(), windowDTO, ticketDTOs);
    }



    @Override
    public void removeQueue(Long id) {
        queueRepository.deleteById(id);
    }

    @Override
    public Optional<QueueDTO> findQueue(Long id) {
        return queueRepository.findById(id)
                .map(queue -> {
                    Window window = queue.getWindow();
                    WindowDTO windowDTO = new WindowDTO(window.getId(), window.getWindowNumber());

                    List<TicketDTO> ticketDTOs = queue.getTickets().stream()
                            .map(ticket -> new TicketDTO(ticket.getId(), ticket.getTicketNumber(), ticket.getStatus().getCode(), windowDTO))
                            .collect(Collectors.toList());

                    return new QueueDTO(queue.getId(), windowDTO, ticketDTOs);
                });
    }


    @Override
    public List<QueueDTO> getAllQueues() {
        return queueRepository.findAll().stream()
                .map(queue -> {
                    Window window = queue.getWindow();
                    WindowDTO windowDTO = new WindowDTO(window.getId(), window.getWindowNumber());

                    List<TicketDTO> ticketDTOs = queue.getTickets().stream()
                            .map(ticket -> new TicketDTO(ticket.getId(), ticket.getTicketNumber(), ticket.getStatus().getCode(), windowDTO))
                            .collect(Collectors.toList());

                    return new QueueDTO(queue.getId(), windowDTO, ticketDTOs);
                })
                .collect(Collectors.toList());
    }

}
