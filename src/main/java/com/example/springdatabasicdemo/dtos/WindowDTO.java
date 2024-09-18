package com.example.springdatabasicdemo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WindowDTO {
    private Long id;
    private int windowNumber;

    @Override
    public String toString() {
        return "Window { id=" + id + ", windowNumber=" + windowNumber + " }";
    }
}
