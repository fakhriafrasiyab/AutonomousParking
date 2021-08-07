package com.example.autopark.service;

import com.example.autopark.model.Car;
import com.example.autopark.model.Floor;
import com.example.autopark.repository.CarRepo;
import com.example.autopark.repository.FloorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ParkingService {
    private final FloorRepo floorRepo;
    private final CarRepo carRepo;

    public ParkingService(FloorRepo floorRepo, CarRepo carRepo) {
        this.floorRepo = floorRepo;
        this.carRepo = carRepo;
    }

    public Floor getAvailableFloor(Car car) throws Exception {
        List<Floor> floors = floorRepo.findAll();
        for (Floor floor : floors) {
            if (floor.getCeilingHeight() > car.getHeight() && floor.getRemainingCapacity() > car.getWeight()) {
                return floor;
            }
        }
        throw new Exception("There is no matched floor");
    }

    public void parkCar(Car car) throws Exception {
        Floor floor = getAvailableFloor(car);
        if (floor == null) {
            return;
        }
        car.setFloor(floor);
        floor.getCars().add(car);
        carRepo.save(car);
        floorRepo.save(floor);
    }

    public void leave(int carId, int floorNumber) {
        Car car = carRepo.findCarById(carId).orElseThrow(() -> new NoSuchElementException("There is no this kind of car!"));
        Floor floor = floorRepo.findFloorByFloorNumber(floorNumber).orElseThrow(() -> new NoSuchElementException("There is no this kind of floor!"));
        floor.getCars().remove(car);
        floorRepo.save(floor);
    }

    public List<Floor> getAll() {
        List<Floor> floors = floorRepo.findAll();
        return floors;
    }
}
