package com.example.autopark.repository;

import com.example.autopark.model.Floor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FloorRepo extends CrudRepository<Floor,Integer> {
    @Override
    List<Floor> findAll();
    Optional<Floor> findByFloorNumber(int floorNumber);
}
