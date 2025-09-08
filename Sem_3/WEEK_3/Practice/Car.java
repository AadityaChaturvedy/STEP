public class Car { 
    // Instance variables (attributes)
    private String brand;
    private String model;
    private int year;
    private String color;
    private boolean isRunning;

    // Constructor to initialize all attributes
    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false; // default: engine off
    }

    // startEngine() - sets isRunning to true, prints message
    public void startEngine() {
        isRunning = true;
        System.out.println(brand + " " + model + " engine started.");
    }

    // stopEngine() - sets isRunning to false, prints message
    public void stopEngine() {
        isRunning = false;
        System.out.println(brand + " " + model + " engine stopped.");
    }

    // displayInfo() - prints all car information
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Is Running: " + isRunning);
    }

    // getAge() - returns current year minus car year
    public int getAge() {
        int currentYear = java.time.Year.now().getValue();
        return currentYear - year;
    }

    public static void main(String[] args) { 
        // Create 3 different Car objects with different attributes
        Car car1 = new Car("Toyota", "Corolla", 2015, "Red");
        Car car2 = new Car("Honda", "Civic", 2020, "Blue");
        Car car3 = new Car("Ford", "Mustang", 2018, "Black");

        // Demonstrate calling methods on each object
        car1.displayInfo();
        car1.startEngine();
        System.out.println("Car age: " + car1.getAge());
        car1.stopEngine();

        System.out.println();

        car2.displayInfo();
        car2.startEngine();
        System.out.println("Car age: " + car2.getAge());
        car2.stopEngine();

        System.out.println();

        car3.displayInfo();
        car3.startEngine();
        System.out.println("Car age: " + car3.getAge());
        car3.stopEngine();

        // Each object maintains its own state (attributes and engine status)
        // This is similar to real-world cars: each car has its own brand, model, color, year, and engine status.
        // Actions on one car do not affect the others.
    }
}
