package com.example.springdatabasicdemo.repositories;


import com.example.springdatabasicdemo.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}