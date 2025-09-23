public class Vehicle {
    // Protected fields for inheritance
    protected String brand;
    protected String model;
    protected int year;
    protected String engineType;

    // Private fields
    private String registrationNumber;
    private boolean isRunning;

    // Default constructor
    public Vehicle() {
        brand = "DefaultBrand";
        model = "DefaultModel";
        year = 2020;
        engineType = "Petrol";
        registrationNumber = generateRegistrationNumber();
        isRunning = false;
        System.out.println("Vehicle default constructor called");
    }

    // Parameterized constructor
    public Vehicle(String brand, String model, int year, String engineType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.registrationNumber = generateRegistrationNumber();
        this.isRunning = false;
        System.out.println("Vehicle parameterized constructor called");
    }

    private String generateRegistrationNumber() {
        // Generates a random registration (Simple method)
        return "REG-" + java.util.UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    // Basic operations
    public void start() {
        isRunning = true;
        System.out.println("Vehicle started");
    }

    public void stop() {
        isRunning = false;
        System.out.println("Vehicle stopped");
    }

    public String getVehicleInfo() {
        return "Brand: " + brand + ", Model: " + model + ", Year: " + year +
               ", EngineType: " + engineType + ", Registration: " + registrationNumber;
    }

    public void displaySpecs() {
        System.out.println("Vehicle Specs:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Engine Type: " + engineType);
        System.out.println("Registration Number: " + registrationNumber);
    }

    // Getter/Setter for registrationNumber
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public boolean isRunning() {
        return isRunning;
    }

    // Main method for demonstration
    public static void main(String[] args) {
        // Create Vehicle using default constructor
        Vehicle v1 = new Vehicle();
        v1.displaySpecs();
        v1.start();
        System.out.println(v1.getVehicleInfo());
        v1.stop();

        // Create Vehicle using parameterized constructor
        Vehicle v2 = new Vehicle("Toyota", "Corolla", 2022, "Hybrid");
        v2.displaySpecs();
        v2.start();
        System.out.println(v2.getVehicleInfo());
        v2.stop();
    }
}