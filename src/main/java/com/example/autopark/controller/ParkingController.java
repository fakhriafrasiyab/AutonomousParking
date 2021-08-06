package com.example.autopark.controller;

import com.example.autopark.model.Car;
import com.example.autopark.model.Floor;
import com.example.autopark.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParkingController {
    @Autowired
    ParkingService parkingService;

    @PostMapping(path = "/floor")
    public Floor getAvailableFloor(@RequestBody Car car) {
        return parkingService.getAvailableFloor(car);
    }

    @PostMapping(path = "/parkCar")
    public void parkCar(@RequestBody Car car) {
        parkingService.parkCar(car);
    }

    @PostMapping(path = "/leave")
    public void leave(@RequestBody Car car, @RequestParam int floorNumber) {
        parkingService.leave(car, floorNumber);
    }
}
