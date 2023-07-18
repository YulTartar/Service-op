package com.example.springdatabasicdemo.services;

import com.example.springdatabasicdemo.dtos.ShopDto;

import java.util.List;
import java.util.Optional;

public interface ShopService<ID> {

    ShopDto register(ShopDto shop);

    void expel(ShopDto shop);

    void expel(ID id);

    Optional<ShopDto> findShop(ID id);
    /*
    List<ShopDto> findShopByAddress(String address);
*/
    List<ShopDto> getAll();

}

