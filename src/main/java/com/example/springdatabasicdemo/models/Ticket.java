package com.example.springdatabasicdemo.models;

import com.example.springdatabasicdemo.models.BaseEntity;
import com.example.springdatabasicdemo.models.TicketStatus;
import com.example.springdatabasicdemo.models.Window;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ticket")
public class Ticket extends BaseEntity {

    @Column(name = "ticket_number", nullable = false)
    private int ticketNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TicketStatus status;

    @ManyToOne
    @JoinColumn(name = "window_id", referencedColumnName = "id", nullable = false)
    private Window window;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "queue_id", referencedColumnName = "id")
    private Queue queue;

    @Override
    public String toString() {
        return "Ticket { id=" + id + ", ticket_number=" + ticketNumber + ", status=" + status
                + ", window=" + window + ", client=" + client + ", queue=" + queue + " }";
    }
}