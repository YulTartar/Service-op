package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.ClientDTO;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    ClientDTO registerClient(ClientDTO clientDto);

    void removeClient(Long id);

    Optional<ClientDTO> findClient(Long id);

    List<ClientDTO> getAllClients();

    ClientDTO addClient(ClientDTO clientDTO);
}
