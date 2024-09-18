package com.example.springdatabasicdemo.controllers.Queue;

import com.example.springdatabasicdemo.dtos.QueueDTO;
import com.example.springdatabasicdemo.services.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/queues")
public class QueueController {

    @Autowired
    private QueueService queueService;

    @PostMapping("/window/{windowId}")
    public EntityModel<QueueDTO> createQueueForWindow(@PathVariable Long windowId) {
        QueueDTO queueDTO = queueService.createQueueForWindow(windowId);
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(QueueController.class).getQueue(queueDTO.getId())).withSelfRel();
        return EntityModel.of(queueDTO, selfLink);
    }

    @GetMapping("/{id}")
    public EntityModel<QueueDTO> getQueue(@PathVariable Long id) {
        QueueDTO queueDTO = queueService.findQueue(id).orElseThrow(() -> new RuntimeException("Queue not found"));
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(QueueController.class).getQueue(id)).withSelfRel();
        return EntityModel.of(queueDTO, selfLink);
    }

    @GetMapping
    public List<EntityModel<QueueDTO>> getAllQueues() {
        List<QueueDTO> queues = queueService.getAllQueues();
        return queues.stream()
                .map(queueDTO -> {
                    Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(QueueController.class).getQueue(queueDTO.getId())).withSelfRel();
                    return EntityModel.of(queueDTO, selfLink);
                })
                .toList();
    }
}
