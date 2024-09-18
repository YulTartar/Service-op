package com.example.springdatabasicdemo.controllers.Queue;

class QueueNotFoundException extends RuntimeException {
    QueueNotFoundException(Integer id) {
        super("Could not find ochered" + id);
    }
    QueueNotFoundException() {
        super("Could not find ochered :(");
    }
}

