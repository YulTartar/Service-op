package com.example.springdatabasicdemo.controllers.Window;

class WindowNotFoundException extends RuntimeException {
    WindowNotFoundException(Integer id) {
        super("Could not find Okno" + id);
    }
    WindowNotFoundException() {
        super("Could not find oknj :(");
    }
}

