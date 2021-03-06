package com.example.autopark.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int ceilingHeight;
    int weightCapacity;
    int floorNumber;
    int pricePerMinute;
    @OneToMany(cascade = CascadeType.ALL)
    List<Car> cars = new ArrayList<>();

    public Floor(int ceilingHeight, int weightCapacity, int floorNumber, int pricePerMinute) {
        this.ceilingHeight = ceilingHeight;
        this.weightCapacity = weightCapacity;
        this.floorNumber = floorNumber;
        this.pricePerMinute = pricePerMinute;
    }

    public Floor(int id, int ceilingHeight, int weightCapacity, int floorNumber, int pricePerMinute, List<Car> cars) {
        this.id = id;
        this.ceilingHeight = ceilingHeight;
        this.weightCapacity = weightCapacity;
        this.floorNumber = floorNumber;
        this.pricePerMinute = pricePerMinute;
        this.cars = cars;
    }

    public Floor() {

    }

    public int getRemainingCapacity() {
        if (cars == null) {
            return weightCapacity;
        } else {
            return weightCapacity - cars.stream().map(c -> c.getWeight()).reduce(0, (i, j) -> i + j);
        }
    }

    public int getCeilingHeight() {
        return ceilingHeight;
    }

    public void setCeilingHeight(int ceilingHeight) {
        this.ceilingHeight = ceilingHeight;
    }

    public int getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(int weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPricePerMinute() {
        return pricePerMinute;
    }

    public void setPricePerMinute(int pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "id=" + id +
                ", ceilingHeight=" + ceilingHeight +
                ", weightCapacity=" + weightCapacity +
                ", floorNumber=" + floorNumber +
                ", pricePerMinute=" + pricePerMinute +
                ", cars=" + cars +
                '}';
    }
}
