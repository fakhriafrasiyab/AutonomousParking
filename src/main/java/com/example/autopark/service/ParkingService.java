package com.example.autopark.service;

import com.example.autopark.model.Car;
import com.example.autopark.model.Floor;
import com.example.autopark.repository.FloorRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ParkingService {
    private final FloorRepo floorRepo;

    public ParkingService(FloorRepo floorRepo) {
        this.floorRepo = floorRepo;
    }

    public Floor getAvailableFloor(Car car) {
        List<Floor> floors = floorRepo.findAll();
        for (Floor floor : floors) {
            if (floor.getCeilingHeight() > car.getHeight() && floor.getRemainingCapacity() > car.getWeight()) {
                return floor;
            }
        }
        return null;
    }

    public void parkCar(Car car, Floor floor) {
        floor.getCars().add(car);
        floorRepo.save(floor);
    }

    public void leave(Car car, int floorNumber) {
        Floor floor = floorRepo.findByFloorNumber(floorNumber).orElseThrow(() -> new NoSuchElementException("There is no this kind of floor"));
        floor.getCars().remove(car);
        floorRepo.save(floor);
    }
}
