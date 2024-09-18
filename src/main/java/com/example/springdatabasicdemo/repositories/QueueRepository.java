package com.example.springdatabasicdemo.repositories;
import com.example.springdatabasicdemo.models.Queue;
import com.example.springdatabasicdemo.models.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueRepository extends JpaRepository<Queue, Long> {
    Queue findByWindow(Window window);
}
