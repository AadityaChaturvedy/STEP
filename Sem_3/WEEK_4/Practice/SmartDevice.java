public class SmartDevice {
    private String deviceName;
    private String location;
    private boolean isOnline;
    private double powerConsumption;
    private String[] connectedDevices;
    private int connectionCount;

    // Constructor with parameter names matching field names
    public SmartDevice(String deviceName, String location, boolean isOnline, double powerConsumption) {
        this.deviceName = deviceName;  // using this for disambiguation
        this.location = location;
        this.isOnline = isOnline;
        this.powerConsumption = powerConsumption;

        this.connectedDevices = new String[5]; // Initialize array of size 5
        this.connectionCount = 0;
    }

    // Method using this for parameter disambiguation
    public void updateLocation(String location) {
        this.location = location; // disambiguation
        System.out.println(this.deviceName + " moved to " + this.location);
    }

    public void updatePowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption; // disambiguation
        System.out.println("Power consumption updated for " + this.deviceName);
    }

    // Method returning this for chaining
    public SmartDevice setOnline(boolean isOnline) {
        this.isOnline = isOnline;
        return this;
    }

    public SmartDevice connectToDevice(String deviceName) {
        if (this.connectionCount < this.connectedDevices.length) {
            this.connectedDevices[this.connectionCount] = deviceName;
            this.connectionCount++;
            System.out.println(this.deviceName + " connected to " + deviceName);
        } else {
            System.out.println("Max connections reached for " + this.deviceName);
        }
        return this; // Enable chaining
    }

    public SmartDevice rename(String deviceName) {
        String oldName = this.deviceName;
        this.deviceName = deviceName;
        System.out.println("Device renamed from " + oldName + " to " + this.deviceName);
        return this;
    }

    public void displayDeviceInfo() {
        System.out.println("\n=== " + this.deviceName + " INFO ===");
        System.out.println("Location: " + this.location);
        System.out.println("Status: " + (this.isOnline ? "Online" : "Offline"));
        System.out.println("Power: " + this.powerConsumption + "W");
        System.out.println("Connections: " + this.connectionCount);
        for (int i = 0; i < this.connectionCount; i++) {
            System.out.println(" -> " + this.connectedDevices[i]);
        }
    }

    // Method that calls other methods using this
    public void performInitialSetup() {
        this.setOnline(true);
        System.out.println(this.deviceName + " initial setup completed");
    }

    public static void main(String[] args) {
        System.out.println("=== SMART HOME DEVICE NETWORK ===");

        // Create devices with parameter names matching fields
        SmartDevice device1 = new SmartDevice("Living Room Speaker", "Living Room", false, 15.5);
        SmartDevice device2 = new SmartDevice("Smart TV", "Bedroom", true, 120.0);

        // Demonstrate parameter disambiguation & chaining
        device1.performInitialSetup();
        device1.updateLocation("Dining Room");
        device1.updatePowerConsumption(18.0);

        // Method chaining example
        device1.setOnline(true)
               .connectToDevice("Alexa")
               .connectToDevice("Smart Light")
               .rename("Kitchen Hub");

        device2.setOnline(true)
               .connectToDevice("Soundbar")
               .connectToDevice("Game Console");

        // Display info
        device1.displayDeviceInfo();
        device2.displayDeviceInfo();
    }
}
