package org.example.pattern.creational;

import lombok.ToString;

enum CarType {
    SPORTS_CAR,
    SEDAN,
    MINI_TRUCK
}

@ToString
abstract class Car {
    protected String make;
    protected String model;
    protected String fuelType;
    protected boolean isAutoTransmission;

    public Car(String make, String model, String fuelType, boolean isAutoTransmission) {
        this.make = make;
        this.model = model;
        this.fuelType = fuelType;
        this.isAutoTransmission = isAutoTransmission;
    }

    public abstract void start_engine();
    public abstract void stop_engine();

    public String toString() {
        return "Make: " + this.make + " AND " +
                "Model: " + this.model + " AND " +
                "FuelType: " + this.fuelType + " AND " +
                "Transmission " + (this.isAutoTransmission ? "Auto" : "Manual");
    }
}

class SportsCar extends Car {

    public SportsCar() {
        super("Ferrari", "F8 Tributo", "Petrol", false);
        System.out.println("Creating a Sports Car");
    }

    @Override
    public void start_engine() {
        System.out.println("Sports Car: Starting engine");
    }

    @Override
    public void stop_engine() {
        System.out.println("Sports Car: Stopping engine");
    }

    public String toString() {
        return "Created a Sports car " + super.toString();
    }
}

class Sedan extends Car {

    public Sedan() {
        super("Honda", "City", "Diesel", true);
        System.out.println("Creating a Sedan Car");
    }

    @Override
    public void start_engine() {
        System.out.println("Sedan Car: Starting engine");
    }

    @Override
    public void stop_engine() {
        System.out.println("Sedan Car: Stopping engine");
    }

    public String toString() {
        return "Created a Sedan car " + super.toString();
    }
}

@ToString
class MiniTruck extends Car {

    public MiniTruck() {
        super("Honda", "City", "Diesel", true);
        System.out.println("Creating a MiniTruck Car");
    }

    @Override
    public void start_engine() {
        System.out.println("MiniTruck: Starting engine");
    }

    @Override
    public void stop_engine() {
        System.out.println("MiniTruck: Stopping engine");
    }

    public String toString() {
        return "Created a MiniTruck " + super.toString();
    }
}

class CarFactory {

    public static Car getCar(CarType type) {
        return switch (type) {
            case SPORTS_CAR -> new SportsCar();
            case SEDAN -> new Sedan();
            case MINI_TRUCK -> new MiniTruck();
        };
    }
}

public class FactoryPattern {

    public static void main(String[] args) {
        Car sportsCar = CarFactory.getCar(CarType.SPORTS_CAR);
        System.out.println(sportsCar);
        sportsCar.start_engine();
        sportsCar.stop_engine();

        Car sedan = CarFactory.getCar(CarType.SEDAN);
        System.out.println(sedan);
        sedan.start_engine();
        sedan.stop_engine();

        Car minTruck = CarFactory.getCar(CarType.MINI_TRUCK);
        System.out.println(minTruck);
        minTruck.start_engine();
        minTruck.stop_engine();
    }
}
