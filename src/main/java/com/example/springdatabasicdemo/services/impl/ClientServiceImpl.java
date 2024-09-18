package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.ClientDTO;
import com.example.springdatabasicdemo.dtos.TicketDTO;
import com.example.springdatabasicdemo.models.Client;
import com.example.springdatabasicdemo.repositories.ClientRepository;
import com.example.springdatabasicdemo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    private TicketDTO ticketDTO;

    @Override
    public ClientDTO registerClient(ClientDTO clientDto) {
        Client client = new Client();
        client.setName(clientDto.getName());
        client = clientRepository.save(client);
        return new ClientDTO(client.getId(), client.getName(), ticketDTO);
    }

    @Override
    public void removeClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Optional<ClientDTO> findClient(Long id) {
        return clientRepository.findById(id)
                .map(client -> new ClientDTO(client.getId(), client.getName(), ticketDTO));
    }

    @Override
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(client -> new ClientDTO(client.getId(), client.getName(), ticketDTO))
                .collect(Collectors.toList());
    }
    @Override
    public ClientDTO addClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());

        client = clientRepository.save(client);

        return new ClientDTO(client.getId(), client.getName(), null);
    }
}
