abstract class Vehicle {
    private String brand;
    private String model;
    private String fuelType;
    private int maxSpeed;
    protected int fuelLevel;

    Vehicle(String brand, String model, String fuelType, int maxSpeed) {
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
        this.maxSpeed = maxSpeed;
        this.fuelLevel = 50;
    }

    abstract void start();
    abstract void stop();

    void drive() {
        if (fuelLevel > 0) {
            fuelLevel -= 10;
            System.out.println(brand + " is moving... Fuel left: " + fuelLevel);
        } else {
            System.out.println("Out of fuel!");
        }
    }

    void refuel(int amount) {
        fuelLevel += amount;
        System.out.println("Refueled: " + amount + " | Total Fuel: " + fuelLevel);
    }

    void displayInfo() {
        System.out.println("\nVehicle: " + brand + " " + model);
        System.out.println("Fuel: " + fuelType);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

class Car extends Vehicle {

    Car() {
        super("Honda", "City", "Diesel", 180);
    }

    void start() {
        System.out.println("Car engine starts with button ignition.");
    }

    void stop() {
        System.out.println("Car engine stops.");
    }
}

class Bike extends Vehicle {

    Bike() {
        super("KTM", "Duke 200", "Petrol", 140);
    }

    void start() {
        System.out.println("Bike starts with self-start.");
    }

    void stop() {
        System.out.println("Bike engine stops.");
    }
}

public class Main {
    public static void main(String[] args) {

        Vehicle car = new Car();
        Vehicle bike = new Bike();

        // Car simulation
        car.start();
        car.displayInfo();
        car.drive();
        car.refuel(20);
        car.stop();

        // Bike simulation
        bike.start();
        bike.displayInfo();
        bike.drive();
        bike.refuel(10);
        bike.stop();
    }
}