package com.example.springdatabasicdemo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QueueDTO {
    private Long id;
    private WindowDTO window;
    private List<TicketDTO> tickets;

    @Override
    public String toString() {
        return "Queue { id=" + id + ", window=" + window + ", tickets=" + tickets + " }";
    }
}
