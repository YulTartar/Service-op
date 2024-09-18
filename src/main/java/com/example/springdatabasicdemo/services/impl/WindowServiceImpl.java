package com.example.springdatabasicdemo.services.impl;

import com.example.springdatabasicdemo.dtos.WindowDTO;
import com.example.springdatabasicdemo.models.Window;
import com.example.springdatabasicdemo.repositories.WindowRepository;
import com.example.springdatabasicdemo.services.WindowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WindowServiceImpl implements WindowService {

    @Autowired
    private WindowRepository windowRepository;

    @Override
    public WindowDTO addWindow(WindowDTO windowDto) {
        Window window = new Window();
        window.setWindowNumber(windowDto.getWindowNumber());
        window = windowRepository.save(window);
        return new WindowDTO(window.getId(), window.getWindowNumber());
    }

    @Override
    public void removeWindow(Long id) {
        windowRepository.deleteById(id);
    }

    @Override
    public Optional<WindowDTO> findWindow(Long id) {
        return windowRepository.findById(id)
                .map(window -> new WindowDTO(window.getId(), window.getWindowNumber()));
    }

    @Override
    public List<WindowDTO> getAllWindows() {
        return windowRepository.findAll().stream()
                .map(window -> new WindowDTO(window.getId(), window.getWindowNumber()))
                .collect(Collectors.toList());
    }
}
