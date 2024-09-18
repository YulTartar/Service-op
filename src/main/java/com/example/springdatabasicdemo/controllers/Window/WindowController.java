package com.example.springdatabasicdemo.controllers.Window;

import com.example.springdatabasicdemo.dtos.WindowDTO;
import com.example.springdatabasicdemo.services.WindowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/windows")
public class WindowController {

    @Autowired
    private WindowService windowService;

    @PostMapping
    public EntityModel<WindowDTO> addWindow(@RequestBody WindowDTO windowDTO) {
        WindowDTO createdWindow = windowService.addWindow(windowDTO);
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(WindowController.class).getWindow(createdWindow.getId())).withSelfRel();
        return EntityModel.of(createdWindow, selfLink);
    }

    @GetMapping("/{id}")
    public EntityModel<WindowDTO> getWindow(@PathVariable Long id) {
        WindowDTO windowDTO = windowService.findWindow(id).orElseThrow(() -> new RuntimeException("Window not found"));
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(WindowController.class).getWindow(id)).withSelfRel();
        return EntityModel.of(windowDTO, selfLink);
    }

    @GetMapping
    public List<EntityModel<WindowDTO>> getAllWindows() {
        List<WindowDTO> windows = windowService.getAllWindows();
        return windows.stream()
                .map(windowDTO -> {
                    Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(WindowController.class).getWindow(windowDTO.getId())).withSelfRel();
                    return EntityModel.of(windowDTO, selfLink);
                })
                .toList();
    }

    @DeleteMapping("/{id}")
    public void removeWindow(@PathVariable Long id) {
        windowService.removeWindow(id);
    }
}