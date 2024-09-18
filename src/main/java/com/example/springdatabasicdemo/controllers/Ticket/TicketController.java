package com.example.springdatabasicdemo.controllers.Ticket;


import com.example.springdatabasicdemo.dtos.TicketDTO;
import com.example.springdatabasicdemo.dtos.WindowDTO;
import com.example.springdatabasicdemo.models.Client;
import com.example.springdatabasicdemo.models.Ticket;
import com.example.springdatabasicdemo.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public EntityModel<TicketDTO> issueTicket(@RequestBody TicketDTO ticketDTO) {
        Client client = new Client();
        client.setId(1L);

        Ticket ticket = ticketService.issueTicket(ticketDTO.getWindow().getId(), client);
        TicketDTO createdTicketDTO = new TicketDTO();
        createdTicketDTO.setId(ticket.getId());
        createdTicketDTO.setTicketNumber(ticket.getTicketNumber());
        createdTicketDTO.setStatusCode(ticket.getStatus().getCode());
        createdTicketDTO.setWindow(new WindowDTO(ticket.getWindow().getId(), ticket.getWindow().getWindowNumber()));

        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TicketController.class).getTicket(createdTicketDTO.getId())).withSelfRel();

        return EntityModel.of(createdTicketDTO, selfLink);
    }


    @GetMapping("/{id}")
    public EntityModel<TicketDTO> getTicket(@PathVariable Long id) {
        TicketDTO ticketDTO = ticketService.findTicket(id).orElseThrow(() -> new RuntimeException("Ticket not found"));
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TicketController.class).getTicket(id)).withSelfRel();
        return EntityModel.of(ticketDTO, selfLink);
    }

    @PutMapping("/{id}/serve")
    public void serveTicket(@PathVariable Long id) {
        ticketService.serveTicket(id);
    }

    @PutMapping("/{id}/cancel")
    public void cancelTicket(@PathVariable Long id) {
        ticketService.cancelTicket(id);
    }
}