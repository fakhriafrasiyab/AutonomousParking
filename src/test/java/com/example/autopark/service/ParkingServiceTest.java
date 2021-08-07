package com.example.autopark.service;


import com.example.autopark.model.Car;
import com.example.autopark.model.Floor;
import com.example.autopark.repository.FloorRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(ParkingService.class)
public class ParkingServiceTest {

    @MockBean
    private final FloorRepo floorRepo;

    @InjectMocks
    private ParkingService parkingService;

    public ParkingServiceTest(FloorRepo floorRepo) {
        this.floorRepo = floorRepo;
    }

    @Test
    public void getAvailableFloorTest() {
        List<Floor> floors = new ArrayList<>();
        floors.add(new Floor(250, 40000, 1, 10));
        floors.add(new Floor(300, 50000, 2, 15));
        when(floorRepo.findAll()).thenReturn(floors);

        Floor floor = parkingService.getAvailableFloor(new Car(1, 100, 2000));

        Assert.assertNotNull(floor);
    }
}
