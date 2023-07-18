package com.example.springdatabasicdemo.controllers.shop;

class ShopNotFoundException extends RuntimeException {
    ShopNotFoundException(Integer id) {
        super("Could not find shop " + id);
    }
}