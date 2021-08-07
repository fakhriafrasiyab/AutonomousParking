package com.example.autopark.controller;

import com.example.autopark.model.Car;
import com.example.autopark.model.Floor;
import com.example.autopark.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkingController {
    @Autowired
    ParkingService parkingService;

    @PostMapping(path = "/floor")
    public Floor getAvailableFloor(@RequestBody Car car) throws Exception {
        return parkingService.getAvailableFloor(car);
    }

    @PostMapping(path = "/parkCar")
    public void parkCar(@RequestBody Car car) throws Exception {
        parkingService.parkCar(car);
    }

    @PostMapping(path = "/leave/{carId}/{floorNumber}")
    public void leave(@PathVariable int carId, @PathVariable int floorNumber) {
        parkingService.leave(carId, floorNumber);
    }

    @GetMapping(path = "/getAll")
    public List<Floor> getAll(){
        return parkingService.getAll();
    }
}
