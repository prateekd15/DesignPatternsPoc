package org.example.pattern.structural;

interface EngineType {
    public void start_engine();
    public void refuel();
}

class PetrolEngine implements EngineType {

    @Override
    public void start_engine() {
        System.out.println("Starting the Petrol engine");
    }

    @Override
    public void refuel() {
        System.out.println("Refuelling Petrol");
    }
}


class EVEngine implements EngineType {

    @Override
    public void start_engine() {
        System.out.println("Starting the EV engine");
    }

    @Override
    public void refuel() {
        System.out.println("Recharging using an electronic charger");
    }
}

abstract class Car {
    protected String make;
    protected String model;
    protected boolean isAutoTransmission;
    protected EngineType engineType;

    public Car(String make, String model, boolean isAutoTransmission, EngineType engineType) {
        this.make = make;
        this.model = model;
        this.engineType = engineType;
        this.isAutoTransmission = isAutoTransmission;
    }

    public abstract void drive();

    public abstract void honk();

    public abstract void applyBreaks();

    public String toString() {
        return "Make: " + this.make + " AND " +
                "Model: " + this.model + " AND " +
                "Transmission " + (this.isAutoTransmission ? "Auto" : "Manual");
    }
}

class SportsCar extends Car {

    public SportsCar(EngineType engineType) {
        super("Ferrari", "F8 Tributo", false, engineType);
        System.out.println("Creating a Sports Car");
    }


    @Override
    public void drive() {
        engineType.start_engine();
        System.out.println("Accelerating the Sports Car");
        engineType.refuel();
        System.out.println("Accelerating the Sports Car");
    }

    @Override
    public void honk() {
        System.out.println("Sports car: Honk!");
    }

    @Override
    public void applyBreaks() {
        System.out.println("Sports car: Applied breaks");
    }

    public String toString() {
        return "Created a Sports car " + super.toString();
    }
}

class Sedan extends Car {

    public Sedan(EngineType engineType) {
        super("Honda", "City", true, engineType);
        System.out.println("Creating a Sedan");
    }


    @Override
    public void drive() {
        engineType.start_engine();
        System.out.println("Accelerating the Sedan");
        engineType.refuel();
        System.out.println("Accelerating the Sedan");
    }

    @Override
    public void honk() {
        System.out.println("Sedan: Honk!");
    }

    @Override
    public void applyBreaks() {
        System.out.println("Sedan: Applied breaks");
    }

    public String toString() {
        return "Created a Sedan " + super.toString();
    }
}

public class BridgePattern {

    public static void main(String[] args) {
        Car sportsCar = new SportsCar(new EVEngine());
        sportsCar.drive();
        sportsCar.honk();
        sportsCar.applyBreaks();

        Car sedan = new Sedan(new PetrolEngine());
        sedan.drive();
        sedan.honk();
        sedan.applyBreaks();
    }
}
