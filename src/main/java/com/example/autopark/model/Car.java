package com.example.autopark.model;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int height;
    int weight;
    @ManyToOne
    Floor floor;

    public Car() {
    }

    public Car(int id, int height, int weight) {
        this.id = id;
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", height=" + height +
                ", weight=" + weight +
                ", floor=" + floor +
                '}';
    }
}
