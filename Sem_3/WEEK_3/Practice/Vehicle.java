public class Vehicle { 
    // Protected instance variables
    protected String make;
    protected String model;
    protected int year;
    protected double fuelLevel;

    // Constructor
    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }

    // Common methods
    public void startVehicle() {
        System.out.println(make + " " + model + " started.");
    }

    public void stopVehicle() {
        System.out.println(make + " " + model + " stopped.");
    }

    public void refuel(double amount) {
        fuelLevel += amount;
        System.out.println(make + " " + model + " refueled by " + amount + " liters.");
    }

    public void displayVehicleInfo() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Fuel Level: " + fuelLevel + " liters");
    }

    // Subclasses for different vehicle types
    static class Car extends Vehicle {
        public Car(String make, String model, int year, double fuelLevel) {
            super(make, model, year, fuelLevel);
        }
        @Override
        public void startVehicle() {
            System.out.println("Car " + make + " " + model + " started.");
        }
    }

    static class Truck extends Vehicle {
        public Truck(String make, String model, int year, double fuelLevel) {
            super(make, model, year, fuelLevel);
        }
        @Override
        public void startVehicle() {
            System.out.println("Truck " + make + " " + model + " started.");
        }
    }

    static class Motorcycle extends Vehicle {
        public Motorcycle(String make, String model, int year, double fuelLevel) {
            super(make, model, year, fuelLevel);
        }
        @Override
        public void startVehicle() {
            System.out.println("Motorcycle " + make + " " + model + " started.");
        }
    }

    public static void main(String[] args) { 
        // Create different types of vehicles
        Vehicle car = new Car("Toyota", "Corolla", 2020, 40);
        Vehicle truck = new Truck("Ford", "F-150", 2018, 80);
        Vehicle motorcycle = new Motorcycle("Honda", "CBR", 2022, 15);

        // Show how the same Vehicle class can be reused
        Vehicle[] vehicles = {car, truck, motorcycle};

        // Demonstrate polymorphic behavior
        for (Vehicle v : vehicles) {
            v.startVehicle();
            v.refuel(10);
            v.displayVehicleInfo();
            v.stopVehicle();
            System.out.println();
        }

        // How does this show reusability?
        // - The Vehicle class provides a common structure and behavior for all vehicle types.
        // - Subclasses extend Vehicle and can override methods for specific behavior.

        // How could this be extended for new vehicle types?
        // - Simply create a new subclass (e.g., Bus, Van) that extends Vehicle.

        // Benefits over writing separate classes:
        // - Code reuse, easier maintenance, and consistent interface for all vehicles.
        // - Polymorphism allows treating all vehicles uniformly.
    } 
}