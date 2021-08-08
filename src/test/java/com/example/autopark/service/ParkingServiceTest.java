package com.example.autopark.service;

import com.example.autopark.model.Car;
import com.example.autopark.model.Floor;
import com.example.autopark.repository.CarRepo;
import com.example.autopark.repository.FloorRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(ParkingService.class)
public class ParkingServiceTest {

    @MockBean
    private FloorRepo floorRepo;

    @MockBean
    private CarRepo carRepo;

    @Mock
    private Floor floor;

    @Autowired
    private ParkingService parkingService;

    public ParkingServiceTest() {
    }

    @Test
    public void getAvailableFloorTest() throws Exception {
        List<Floor> floors = new ArrayList<>();
        floors.add(new Floor(250, 40000, 1, 10));
        floors.add(new Floor(300, 50000, 2, 15));
        when(floorRepo.findAll()).thenReturn(floors);
        Floor floor = parkingService.getAvailableFloor(new Car(100, 2000));
        Assert.assertEquals(floor.getFloorNumber(), 1);
    }

    @Test
    public void getRemainingCapacityTest() throws Exception {
        List<Floor> floors = new ArrayList<>();
        floors.add(new Floor(250, 400, 1, 10));
        when(floorRepo.findAll()).thenReturn(floors);
        Floor floor = floors.get(0);
        Car car = new Car(100,200);
        parkingService.parkCar(car);
        int remainingCapacity = floor.getRemainingCapacity();
        Assert.assertEquals(remainingCapacity, 200);
    }

}
