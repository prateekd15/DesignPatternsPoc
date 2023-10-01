package org.example.pattern.creational;

import lombok.Setter;
import lombok.ToString;

interface Prototype {
    Prototype clone();
}

@Setter
@ToString
class Helicopter implements Prototype {

    private String model;
    private int maxSpeed;
    private int passengerCapacity;
    private double fuelCapacity;

    public Helicopter(String model, int maxSpeed, int passengerCapacity, double fuelCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.passengerCapacity = passengerCapacity;
        this.fuelCapacity = fuelCapacity;
    }

    public Helicopter() {
    }

    @Override
    public Helicopter clone() {
        Helicopter helicopter = new Helicopter();
        helicopter.model = model;
        helicopter.maxSpeed = maxSpeed;
        helicopter.passengerCapacity = passengerCapacity;
        helicopter.fuelCapacity = fuelCapacity;
        return helicopter;
    }
}

public class PrototypePattern {
    public static void main(String[] args) {
        Helicopter helicopter = new Helicopter("H15", 120, 6, 750.0);
        System.out.println("Helicopter object created from scratch: " + helicopter);
        Helicopter anotherHelicopter = helicopter.clone();
        anotherHelicopter.setModel("H13");
        anotherHelicopter.setMaxSpeed(100);
        System.out.println("Cloned Helicopter object: " + anotherHelicopter);
    }
}
