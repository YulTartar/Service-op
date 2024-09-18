package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.QueueDTO;

import java.util.List;
import java.util.Optional;

public interface QueueService {
    QueueDTO createQueueForWindow(Long windowId);

    void removeQueue(Long id);

    Optional<QueueDTO> findQueue(Long id);

    List<QueueDTO> getAllQueues();
}
