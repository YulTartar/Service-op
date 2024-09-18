package com.example.springdatabasicdemo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientDTO {
    private Long id;
    private String name;
    private TicketDTO ticket;

    @Override
    public String toString() {
        return "Client { id=" + id + ", name=" + name + ", ticket=" + ticket + " }";
    }
}