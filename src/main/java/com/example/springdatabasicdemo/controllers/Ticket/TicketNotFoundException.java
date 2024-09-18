package com.example.springdatabasicdemo.controllers.Ticket;

class TicketNotFoundException extends RuntimeException {
    TicketNotFoundException(Integer id) {
        super("Could not find talon" + id);
    }
    TicketNotFoundException() {
        super("Could not find talon :(");
    }
}

