package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.WindowDTO;

import java.util.List;
import java.util.Optional;

public interface WindowService {
    WindowDTO addWindow(WindowDTO windowDto);

    void removeWindow(Long id);

    Optional<WindowDTO> findWindow(Long id);

    List<WindowDTO> getAllWindows();
}
