package com.example.springdatabasicdemo.models;

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
@Table(name = "client")
public class Client extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Ticket ticket;

    @Override
    public String toString() {
        return "Client { id=" + id + ", name=" + name + ", ticket=" + ticket + " }";
    }
}
