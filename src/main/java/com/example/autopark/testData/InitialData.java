package com.example.autopark.testData;

import com.example.autopark.model.Floor;
import com.example.autopark.repository.FloorRepo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class InitialData implements InitializingBean {
    private final FloorRepo floorRepo;

    public InitialData(FloorRepo floorRepo) {
        this.floorRepo = floorRepo;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        floorRepo.save(new Floor(1,
                20, 400, 1, 4
        ));
        floorRepo.save(new Floor(2,
                40, 500, 2,
                4));
    }
}
