package com.example.autopark.service;


import com.example.autopark.model.Car;
import com.example.autopark.model.Floor;
import com.example.autopark.repository.FloorRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
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
        Car car = null;
        when(floorRepo.findAll()).thenReturn(null);
        Floor floor = parkingService.getAvailableFloor(car);
        verify(floor);
    }
}
