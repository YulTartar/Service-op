package com.example.springdatabasicdemo.controllers.Queue;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class QueueNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(QueueNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String queueNotFoundHandler(QueueNotFoundException ex) {
        return ex.getMessage();
    }
}

