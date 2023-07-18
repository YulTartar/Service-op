package com.example.springdatabasicdemo.controllers.storage;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StorageNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(StorageNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String storageNotFoundHandler(StorageNotFoundException ex) {
        return ex.getMessage();
    }
}