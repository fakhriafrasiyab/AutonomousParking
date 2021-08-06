package com.example.autopark.repository;

import com.example.autopark.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepo extends CrudRepository<Car, Integer> {

}
