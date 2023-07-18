package com.example.springdatabasicdemo.controllers.shop;

import com.example.springdatabasicdemo.dtos.ShopDto;
import com.example.springdatabasicdemo.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/shop")
    Iterable<ShopDto> all() {
        return shopService.getAll();
    }

    @PostMapping("/shop")
    ShopDto newshop(@RequestBody ShopDto newShop) {  return shopService.register(newShop); }

    @GetMapping("/shop/{id}")
    ShopDto one(@PathVariable Integer id) throws Throwable {
        return (ShopDto) shopService.findShop(id)
                .orElseThrow(() -> new ShopNotFoundException(id));
    }

    @DeleteMapping("/shop/{id}")
    void deleteshop(@PathVariable Integer id) {
        shopService.expel(id);
    }
}
