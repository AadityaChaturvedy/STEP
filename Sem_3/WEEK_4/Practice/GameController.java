public class GameController {
    // Instance variables
    private String controllerBrand;
    private String connectionType;
    private boolean hasVibration;
    private int batteryLevel;
    private double sensitivity;

    // Default constructor - creates standard gaming setup
    public GameController() {
        this.controllerBrand = "GenericPad";
        this.connectionType = "USB";
        this.hasVibration = true;
        this.batteryLevel = 100;
        this.sensitivity = 1.0;
    }

    // Parameterized constructor for custom configuration
    public GameController(String controllerBrand, String connectionType,
                          boolean hasVibration, int batteryLevel, double sensitivity) {
        this.controllerBrand = controllerBrand;
        this.connectionType = connectionType;
        this.hasVibration = hasVibration;

        // Validate battery level (0-100)
        if (batteryLevel >= 0 && batteryLevel <= 100) {
            this.batteryLevel = batteryLevel;
        } else {
            System.out.println("Invalid battery level! Setting to 100.");
            this.batteryLevel = 100;
        }

        // Validate sensitivity (0.1-3.0)
        if (sensitivity >= 0.1 && sensitivity <= 3.0) {
            this.sensitivity = sensitivity;
        } else {
            System.out.println("Invalid sensitivity! Setting to 1.0.");
            this.sensitivity = 1.0;
        }
    }

    // Two-parameter convenience constructor
    public GameController(String brand, String connectionType) {
        this.controllerBrand = brand;
        this.connectionType = connectionType;
        this.hasVibration = true;  // default
        this.batteryLevel = 100;   // default
        this.sensitivity = 1.0;    // default
    }

    // Methods to test functionality
    public void calibrateController() {
        System.out.println("Calibrating " + controllerBrand + " controller...");
    }

    public void displayConfiguration() {
        System.out.println("Controller Brand: " + controllerBrand);
        System.out.println("Connection Type: " + connectionType);
        System.out.println("Vibration: " + (hasVibration ? "Enabled" : "Disabled"));
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Sensitivity: " + sensitivity);
        System.out.println("----------------------------------");
    }

    public void testVibration() {
        if (hasVibration) {
            System.out.println("*BUZZ* Vibration test successful!");
        } else {
            System.out.println("Vibration disabled on this controller.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== GAMING CONTROLLER SETUP ===");

        // Controller with default constructor
        GameController controller1 = new GameController();

        // Controller with full parameterized constructor
        GameController controller2 = new GameController("ProGamer", "Bluetooth", false, 80, 2.5);

        // Controller with convenience constructor
        GameController controller3 = new GameController("ElitePad", "Wireless");

        // Test all methods on each controller
        System.out.println("\n--- Controller 1 (Default) ---");
        controller1.displayConfiguration();
        controller1.calibrateController();
        controller1.testVibration();

        System.out.println("\n--- Controller 2 (Custom) ---");
        controller2.displayConfiguration();
        controller2.calibrateController();
        controller2.testVibration();

        System.out.println("\n--- Controller 3 (Convenience) ---");
        controller3.displayConfiguration();
        controller3.calibrateController();
        controller3.testVibration();

        // Compare different configurations
        System.out.println("\nComparison Complete: All controllers configured successfully.");
    }
}
