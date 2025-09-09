public class AudioMixer {
    private String mixerModel;
    private int numberOfChannels;
    private boolean hasBluetoothConnectivity;
    private double maxVolumeDecibels;
    private String[] connectedDevices;
    private int deviceCount;

    // No-argument constructor using this() chaining
    public AudioMixer() {
        this("StandardMix-8", 8, false); // calling three-parameter constructor
        System.out.println("No-argument constructor executed.");
    }

    // Two-parameter constructor using this() chaining
    public AudioMixer(String mixerModel, int numberOfChannels) {
        this(mixerModel, numberOfChannels, false); // calling three-parameter constructor
        System.out.println("Two-parameter constructor executed.");
    }

    // Three-parameter constructor using this() chaining
    public AudioMixer(String mixerModel, int numberOfChannels, boolean hasBluetoothConnectivity) {
        this(mixerModel, numberOfChannels, hasBluetoothConnectivity, 120.0); // calling main constructor
        System.out.println("Three-parameter constructor executed.");
    }

    // Main constructor - all parameters
    public AudioMixer(String mixerModel, int numberOfChannels,
                      boolean hasBluetoothConnectivity, double maxVolumeDecibels) {
        this.mixerModel = mixerModel;
        this.numberOfChannels = numberOfChannels;
        this.hasBluetoothConnectivity = hasBluetoothConnectivity;
        this.maxVolumeDecibels = maxVolumeDecibels;

        // Initialize connectedDevices array based on numberOfChannels
        this.connectedDevices = new String[numberOfChannels];
        this.deviceCount = 0;

        System.out.println("Main constructor executed for " + mixerModel);
    }

    public void connectDevice(String deviceName) {
        if (deviceCount < connectedDevices.length) {
            connectedDevices[deviceCount] = deviceName;
            deviceCount++;
            System.out.println("Connected: " + deviceName);
        } else {
            System.out.println("All channels occupied!");
        }
    }

    public void displayMixerStatus() {
        System.out.println("\n=== " + mixerModel + " STATUS ===");
        System.out.println("Channels: " + numberOfChannels);
        System.out.println("Bluetooth: " + (hasBluetoothConnectivity ? "Enabled" : "Disabled"));
        System.out.println("Max Volume: " + maxVolumeDecibels + " dB");
        System.out.println("Connected Devices: " + deviceCount + "/" + numberOfChannels);

        for (int i = 0; i < deviceCount; i++) {
            System.out.println(" Channel " + (i + 1) + ": " + connectedDevices[i]);
        }
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("=== MUSIC STUDIO SETUP ===");

        // Create mixer using no-argument constructor
        AudioMixer mixer1 = new AudioMixer();

        // Create mixer using two-parameter constructor
        AudioMixer mixer2 = new AudioMixer("BassBoost-12", 12);

        // Create mixer using three-parameter constructor
        AudioMixer mixer3 = new AudioMixer("ProMix-16", 16, true);

        // Create mixer using full constructor
        AudioMixer mixer4 = new AudioMixer("UltraMix-24", 24, true, 150.0);

        // Connect different devices to each mixer
        mixer1.connectDevice("Guitar");
        mixer1.connectDevice("Microphone");

        mixer2.connectDevice("Keyboard");
        mixer2.connectDevice("Drums");

        mixer3.connectDevice("DJ Console");
        mixer3.connectDevice("Laptop");

        mixer4.connectDevice("Synthesizer");
        mixer4.connectDevice("Mixer Pad");
        mixer4.connectDevice("Effects Unit");

        // Display status of all mixers
        mixer1.displayMixerStatus();
        mixer2.displayMixerStatus();
        mixer3.displayMixerStatus();
        mixer4.displayMixerStatus();

        // Comment on constructor chaining execution order
        System.out.println("\nNOTE: Constructor chaining starts from the called constructor to the main constructor, then returns back.");
    }
}
