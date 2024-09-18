package com.example.springdatabasicdemo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TicketDTO {
    private Long id;
    private int ticketNumber;
    private int statusCode;
    private WindowDTO window;

    @Override
    public String toString() {
        return "Ticket { id=" + id + ", ticketNumber=" + ticketNumber + ", statusCode=" + statusCode + ", window=" + window + " }";
    }
}
