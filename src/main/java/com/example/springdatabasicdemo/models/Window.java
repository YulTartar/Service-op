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
@Table(name = "window")
public class Window extends BaseEntity {

    @Column(name = "window_number", nullable = false)
    private int windowNumber;

    @Column(name = "status", nullable = false)
    private String status;

    @Override
    public String toString() {
        return "Window { id=" + id + ", windowNumber=" + windowNumber + ", status=" + status + " }";
    }
}