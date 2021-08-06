package com.example.autopark.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ParkingArea {
    @Id
    int id;
    @OneToMany
    List<Floor> floors;

    public ParkingArea(List<Floor> floors) {
        this.floors = floors;
    }

    public ParkingArea() {

    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
