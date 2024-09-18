package com.example.springdatabasicdemo.init;

import com.example.springdatabasicdemo.models.Client;
import com.example.springdatabasicdemo.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;


import com.example.springdatabasicdemo.dtos.QueueDTO;
import com.example.springdatabasicdemo.dtos.ClientDTO;
import com.example.springdatabasicdemo.dtos.WindowDTO;
import com.example.springdatabasicdemo.dtos.TicketDTO;
import com.example.springdatabasicdemo.services.QueueService;
import com.example.springdatabasicdemo.services.ClientService;
import com.example.springdatabasicdemo.services.WindowService;
import com.example.springdatabasicdemo.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private QueueService queueService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private WindowService windowService;

    @Autowired
    private TicketService ticketService;

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() {
        // Создание и сохранение окон
        WindowDTO window1 = new WindowDTO(0L, 1); // Примерный номер окна
        WindowDTO window2 = new WindowDTO(0L, 2); // Примерный номер окна

        window1 = windowService.addWindow(window1);
        window2 = windowService.addWindow(window2);

        // Создание и сохранение клиентов
        ClientDTO client1 = new ClientDTO(0L, "Иван Иванов", null);
        ClientDTO client2 = new ClientDTO(0L, "Мария Петрова", null);

        client1 = clientService.addClient(client1);
        client2 = clientService.addClient(client2);


        QueueDTO queue1 = queueService.createQueueForWindow(window1.getId());
        QueueDTO queue2 = queueService.createQueueForWindow(window2.getId());


        System.out.println("Clients:");
        List<ClientDTO> clients = clientService.getAllClients();
        clients.forEach(System.out::println);

        System.out.println("Tickets:");
        List<TicketDTO> tickets = ticketService.getAllTickets(); // Предположим, что этот метод существует в TicketService
        tickets.forEach(System.out::println);

        System.out.println("Queues:");
        List<QueueDTO> queues = queueService.getAllQueues();
        queues.forEach(System.out::println);

        System.out.println("Windows:");
        List<WindowDTO> windows = windowService.getAllWindows();
        windows.forEach(System.out::println);
    }
}
