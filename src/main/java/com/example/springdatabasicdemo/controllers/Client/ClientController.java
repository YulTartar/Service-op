package com.example.springdatabasicdemo.controllers.Client;

import com.example.springdatabasicdemo.dtos.ClientDTO;
import com.example.springdatabasicdemo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public EntityModel<ClientDTO> addClient(@RequestBody ClientDTO clientDTO) {
        ClientDTO createdClient = clientService.addClient(clientDTO);
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClientController.class).getClient(createdClient.getId())).withSelfRel();
        return EntityModel.of(createdClient, selfLink);
    }

    @GetMapping("/{id}")
    public EntityModel<ClientDTO> getClient(@PathVariable Long id) {
        ClientDTO clientDTO = clientService.findClient(id).orElseThrow(() -> new RuntimeException("Client not found"));
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClientController.class).getClient(id)).withSelfRel();
        return EntityModel.of(clientDTO, selfLink);
    }

    @GetMapping
    public List<EntityModel<ClientDTO>> getAllClients() {
        List<ClientDTO> clients = clientService.getAllClients();
        return clients.stream()
                .map(clientDTO -> {
                    Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ClientController.class).getClient(clientDTO.getId())).withSelfRel();
                    return EntityModel.of(clientDTO, selfLink);
                })
                .toList();
    }

    @DeleteMapping("/{id}")
    public void removeClient(@PathVariable Long id) {
        clientService.removeClient(id);
    }
}
