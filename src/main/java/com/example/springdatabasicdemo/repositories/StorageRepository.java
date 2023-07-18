package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Integer> {
    @Query(value = "SELECT v.name FROM Storage v WHERE v.capacity < :capacity")
    List<String> findStorageByCapacity(@Param(value = "capacity") int capacity);
}
