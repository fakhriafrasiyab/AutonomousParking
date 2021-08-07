package com.example.autopark.repository;

import com.example.autopark.model.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CarRepo extends CrudRepository<Car, Integer> {
    Optional<Car> findCarById(int id);
}
