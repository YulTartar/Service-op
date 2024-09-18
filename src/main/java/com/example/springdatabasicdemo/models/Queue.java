package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "queue")
public class Queue extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "window_id", nullable = false)
    private Window window;

    @OneToMany(mappedBy = "queue", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets;

    @Override
    public String toString() {
        return "Queue { id=" + id + ", window=" + window + ", tickets=" + tickets + " }";
    }
}