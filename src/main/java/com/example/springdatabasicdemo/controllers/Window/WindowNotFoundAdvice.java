package com.example.springdatabasicdemo.controllers.Window;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WindowNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(WindowNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String windowNotFoundHandler(WindowNotFoundException ex) {
        return ex.getMessage();
    }
}

