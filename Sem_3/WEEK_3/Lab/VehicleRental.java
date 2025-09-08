class Vehicle {
    private String vehicleId;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean isAvailable;
    private int totalRentalDays; // rental history for this vehicle

    private static int totalVehicles = 0;
    private static double totalRevenue = 0;
    private static String companyName = "";
    private static int rentalDays = 0;
    private static int vehicleCounter = 1;

    public Vehicle(String brand, String model, double rentPerDay) {
        this.vehicleId = generateVehicleId();
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        this.totalRentalDays = 0;
        totalVehicles++;
    }

    private static String generateVehicleId() {
        String id = String.format("V%03d", vehicleCounter);
        vehicleCounter++;
        return id;
    }

    public boolean rentVehicle(int days) {
        if (isAvailable && days > 0) {
            double rent = calculateRent(days);
            isAvailable = false;
            totalRentalDays += days;
            rentalDays += days;
            System.out.println(brand + " " + model + " rented for " + days + " days. Rent: " + rent);
            return true;
        }
        System.out.println("Vehicle " + vehicleId + " is not available for rent.");
        return false;
    }

    public void returnVehicle() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println(brand + " " + model + " returned and is now available.");
        } else {
            System.out.println("Vehicle " + vehicleId + " was not rented.");
        }
    }

    public double calculateRent(int days) {
        double rent = rentPerDay * days;
        totalRevenue += rent;
        return rent;
    }

    public void displayVehicleInfo() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Rent Per Day: " + rentPerDay);
        System.out.println("Available: " + isAvailable);
        System.out.println("Total Rental Days: " + totalRentalDays);
        System.out.println("---------------------------");
    }

    // Static methods
    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static double getAverageRentPerDay() {
        if (rentalDays == 0) return 0;
        return totalRevenue / rentalDays;
    }

    public static void displayCompanyStats() {
        System.out.println("Company Name: " + companyName);
        System.out.println("Total Vehicles: " + totalVehicles);
        System.out.println("Total Revenue: " + totalRevenue);
        System.out.println("Total Rental Days: " + rentalDays);
        System.out.println("Average Rent Per Day: " + getAverageRentPerDay());
        System.out.println("===========================");
    }
}

public class VehicleRental {
    public static void main(String[] args) {
        Vehicle.setCompanyName("Speedy Rentals");

        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Vehicle("Toyota", "Camry", 50);
        vehicles[1] = new Vehicle("Honda", "Civic", 40);
        vehicles[2] = new Vehicle("Ford", "Focus", 45);

        // Rent vehicles
        vehicles[0].rentVehicle(3);
        vehicles[1].rentVehicle(2);
        vehicles[2].rentVehicle(5);

        // Try renting an already rented vehicle
        vehicles[0].rentVehicle(2);

        // Return vehicles
        vehicles[0].returnVehicle();
        vehicles[0].rentVehicle(2);

        // Display vehicle info
        for (Vehicle v : vehicles) {
            v.displayVehicleInfo();
        }

        // Display company stats (static members)
        Vehicle.displayCompanyStats();
    }
}