import java.util.*;

class Driver {
    private String driverId;
    private String driverName;
    private String licenseType;
    private Vehicle assignedVehicle;
    private int totalTrips;

    public Driver(String driverId, String driverName, String licenseType) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.licenseType = licenseType;
        this.assignedVehicle = null;
        this.totalTrips = 0;
    }

    public String getDriverId() { return driverId; }
    public String getDriverName() { return driverName; }
    public String getLicenseType() { return licenseType; }
    public Vehicle getAssignedVehicle() { return assignedVehicle; }
    public int getTotalTrips() { return totalTrips; }

    public void assignVehicle(Vehicle v) {
        assignedVehicle = v;
        System.out.println(driverName + " assigned to vehicle " + v.getVehicleId());
    }

    public void completeTrip() {
        totalTrips++;
    }
}

abstract class Vehicle {
    protected String vehicleId;
    protected String brand;
    protected String model;
    protected int year;
    protected double mileage;
    protected String fuelType;
    protected String currentStatus; // Available, In Service, Under Maintenance
    protected Driver driver;
    protected double maintenanceCost;
    protected double fuelConsumed;

    // Static variables
    public static int totalVehicles = 0;
    public static double fleetValue = 0.0;
    public static String companyName = "TransFleet Corp";
    public static double totalFuelConsumption = 0.0;

    public Vehicle(String vehicleId, String brand, String model, int year, double mileage, String fuelType, double value) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.fuelType = fuelType;
        this.currentStatus = "Available";
        this.driver = null;
        this.maintenanceCost = 0.0;
        this.fuelConsumed = 0.0;
        totalVehicles++;
        fleetValue += value;
    }

    public String getVehicleId() { return vehicleId; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getMileage() { return mileage; }
    public String getFuelType() { return fuelType; }
    public String getCurrentStatus() { return currentStatus; }
    public Driver getDriver() { return driver; }
    public double getMaintenanceCost() { return maintenanceCost; }
    public double getFuelConsumed() { return fuelConsumed; }

    public void assignDriver(Driver d) {
        driver = d;
        d.assignVehicle(this);
    }

    public void scheduleMaintenance(double cost) {
        currentStatus = "Under Maintenance";
        maintenanceCost += cost;
        System.out.println("Maintenance scheduled for " + vehicleId + ". Cost: $" + cost);
    }

    public abstract double calculateRunningCost();

    public void updateMileage(double km, double fuelUsed) {
        mileage += km;
        fuelConsumed += fuelUsed;
        totalFuelConsumption += fuelUsed;
        currentStatus = "Available";
        if (driver != null) driver.completeTrip();
    }

    public boolean checkServiceDue() {
        // Service due every 10,000 km
        return mileage % 10000 < 500;
    }

    public void displayVehicle() {
        System.out.printf("%-8s %-10s %-10s %-6d %-10.1f %-8s %-15s\n",
            vehicleId, brand, model, year, mileage, fuelType, currentStatus);
    }

    // Static methods
    public static double getFleetUtilization(Vehicle[] vehicles) {
        int inUse = 0;
        for (Vehicle v : vehicles) {
            if (v.getCurrentStatus().equals("Available") && v.getDriver() != null) inUse++;
        }
        return vehicles.length == 0 ? 0 : inUse * 100.0 / vehicles.length;
    }

    public static double calculateTotalMaintenanceCost(Vehicle[] vehicles) {
        double total = 0;
        for (Vehicle v : vehicles) total += v.getMaintenanceCost();
        return total;
    }

    public static Vehicle[] getVehiclesByType(Vehicle[] vehicles, String type) {
        List<Vehicle> list = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (type.equalsIgnoreCase("Car") && v instanceof Car) list.add(v);
            else if (type.equalsIgnoreCase("Bus") && v instanceof Bus) list.add(v);
            else if (type.equalsIgnoreCase("Truck") && v instanceof Truck) list.add(v);
        }
        return list.toArray(new Vehicle[0]);
    }
}

class Car extends Vehicle {
    private int seatingCapacity;

    public Car(String vehicleId, String brand, String model, int year, double mileage, String fuelType, double value, int seatingCapacity) {
        super(vehicleId, brand, model, year, mileage, fuelType, value);
        this.seatingCapacity = seatingCapacity;
    }

    public int getSeatingCapacity() { return seatingCapacity; }

    @Override
    public double calculateRunningCost() {
        // Example: $0.2 per km + maintenance
        return mileage * 0.2 + maintenanceCost;
    }
}

class Bus extends Vehicle {
    private int seatingCapacity;

    public Bus(String vehicleId, String brand, String model, int year, double mileage, String fuelType, double value, int seatingCapacity) {
        super(vehicleId, brand, model, year, mileage, fuelType, value);
        this.seatingCapacity = seatingCapacity;
    }

    public int getSeatingCapacity() { return seatingCapacity; }

    @Override
    public double calculateRunningCost() {
        // Example: $0.5 per km + maintenance
        return mileage * 0.5 + maintenanceCost;
    }
}

class Truck extends Vehicle {
    private double loadCapacity; // in tons

    public Truck(String vehicleId, String brand, String model, int year, double mileage, String fuelType, double value, double loadCapacity) {
        super(vehicleId, brand, model, year, mileage, fuelType, value);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() { return loadCapacity; }

    @Override
    public double calculateRunningCost() {
        // Example: $0.7 per km + maintenance
        return mileage * 0.7 + maintenanceCost;
    }
}

public class FleetManagementSystem {
    public static void main(String[] args) {
        // Sample vehicles
        Vehicle[] vehicles = new Vehicle[6];
        vehicles[0] = new Car("V001", "Toyota", "Corolla", 2020, 12000, "Petrol", 18000, 5);
        vehicles[1] = new Bus("V002", "Mercedes", "Sprinter", 2019, 25000, "Diesel", 55000, 30);
        vehicles[2] = new Truck("V003", "Volvo", "FH", 2018, 40000, "Diesel", 75000, 15);
        vehicles[3] = new Car("V004", "Honda", "Civic", 2021, 8000, "Petrol", 20000, 5);
        vehicles[4] = new Bus("V005", "Scania", "Citywide", 2022, 15000, "Diesel", 60000, 40);
        vehicles[5] = new Truck("V006", "MAN", "TGX", 2020, 22000, "Diesel", 70000, 18);

        // Sample drivers
        Driver[] drivers = new Driver[3];
        drivers[0] = new Driver("D001", "Alice", "Car");
        drivers[1] = new Driver("D002", "Bob", "Bus");
        drivers[2] = new Driver("D003", "Charlie", "Truck");

        // Assign drivers
        vehicles[0].assignDriver(drivers[0]);
        vehicles[1].assignDriver(drivers[1]);
        vehicles[2].assignDriver(drivers[2]);

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- " + Vehicle.companyName + " Fleet Menu ---");
            System.out.println("1. Display all vehicles");
            System.out.println("2. Assign driver to vehicle");
            System.out.println("3. Schedule maintenance");
            System.out.println("4. Update mileage & fuel after trip");
            System.out.println("5. Check service due");
            System.out.println("6. Fleet utilization report");
            System.out.println("7. Total maintenance cost");
            System.out.println("8. Get vehicles by type");
            System.out.println("9. Display driver info");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.printf("%-8s %-10s %-10s %-6s %-10s %-8s %-15s\n",
                        "VehID", "Brand", "Model", "Year", "Mileage", "Fuel", "Status");
                    for (Vehicle v : vehicles) v.displayVehicle();
                    break;
                case 2:
                    System.out.print("Enter vehicle ID: ");
                    String vid = sc.nextLine();
                    Vehicle v = null;
                    for (Vehicle veh : vehicles) if (veh.getVehicleId().equalsIgnoreCase(vid)) v = veh;
                    if (v == null) { System.out.println("Vehicle not found."); break; }
                    System.out.print("Enter driver name: ");
                    String dname = sc.nextLine();
                    Driver d = null;
                    for (Driver dr : drivers) if (dr.getDriverName().equalsIgnoreCase(dname)) d = dr;
                    if (d == null) { System.out.println("Driver not found."); break; }
                    v.assignDriver(d);
                    break;
                case 3:
                    System.out.print("Enter vehicle ID: ");
                    vid = sc.nextLine();
                    v = null;
                    for (Vehicle veh : vehicles) if (veh.getVehicleId().equalsIgnoreCase(vid)) v = veh;
                    if (v == null) { System.out.println("Vehicle not found."); break; }
                    System.out.print("Enter maintenance cost: ");
                    double cost = sc.nextDouble();
                    sc.nextLine();
                    v.scheduleMaintenance(cost);
                    break;
                case 4:
                    System.out.print("Enter vehicle ID: ");
                    vid = sc.nextLine();
                    v = null;
                    for (Vehicle veh : vehicles) if (veh.getVehicleId().equalsIgnoreCase(vid)) v = veh;
                    if (v == null) { System.out.println("Vehicle not found."); break; }
                    System.out.print("Enter km driven: ");
                    double km = sc.nextDouble();
                    System.out.print("Enter fuel used (liters): ");
                    double fuel = sc.nextDouble();
                    sc.nextLine();
                    v.updateMileage(km, fuel);
                    System.out.println("Trip updated.");
                    break;
                case 5:
                    System.out.print("Enter vehicle ID: ");
                    vid = sc.nextLine();
                    v = null;
                    for (Vehicle veh : vehicles) if (veh.getVehicleId().equalsIgnoreCase(vid)) v = veh;
                    if (v == null) { System.out.println("Vehicle not found."); break; }
                    System.out.println("Service Due: " + (v.checkServiceDue() ? "Yes" : "No"));
                    break;
                case 6:
                    double util = Vehicle.getFleetUtilization(vehicles);
                    System.out.printf("Fleet Utilization: %.2f%%\n", util);
                    break;
                case 7:
                    double maint = Vehicle.calculateTotalMaintenanceCost(vehicles);
                    System.out.printf("Total Maintenance Cost: $%.2f\n", maint);
                    break;
                case 8:
                    System.out.print("Enter vehicle type (Car/Bus/Truck): ");
                    String type = sc.nextLine();
                    Vehicle[] vt = Vehicle.getVehiclesByType(vehicles, type);
                    System.out.printf("Vehicles of type %s:\n", type);
                    for (Vehicle veh : vt) veh.displayVehicle();
                    break;
                case 9:
                    System.out.print("Enter driver name: ");
                    dname = sc.nextLine();
                    d = null;
                    for (Driver dr : drivers) if (dr.getDriverName().equalsIgnoreCase(dname)) d = dr;
                    if (d == null) { System.out.println("Driver not found."); break; }
                    System.out.printf("Driver: %s | License: %s | Assigned Vehicle: %s | Total Trips: %d\n",
                        d.getDriverName(), d.getLicenseType(),
                        d.getAssignedVehicle() != null ? d.getAssignedVehicle().getVehicleId() : "None",
                        d.getTotalTrips());
                    break;
                case 0:
                    System.out.println("Exiting system.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        sc.close();
    }
}