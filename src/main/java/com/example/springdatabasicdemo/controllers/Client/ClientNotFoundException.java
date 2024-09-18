package com.example.springdatabasicdemo.controllers.Client;

class ClientNotFoundException extends RuntimeException {
    ClientNotFoundException(Integer id) {
        super("Could not find chel" + id);
    }
    ClientNotFoundException() {
        super("Could not find chel :(");
    }
}

