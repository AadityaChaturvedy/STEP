package Homework;

class Light {
    private int brightness;
    private String color;

    public Light() {
        this(0, "White");
        System.out.println("Light() called");
    }

    public Light(int brightness) {
        this(brightness, "White");
        System.out.println("Light(int) called");
    }

    public Light(int brightness, String color) {
        this.brightness = brightness;
        this.color = color;
        System.out.println("Light(int, String) called");
    }
}

class LED extends Light {
    private int power;

    public LED() {
        this(5);
        System.out.println("LED() called");
    }

    public LED(int power) {
        super(power * 10, "Blue");
        this.power = power;
        System.out.println("LED(int) called");
    }

    public LED(int power, int brightness) {
        super(brightness, "Green");
        this.power = power;
        System.out.println("LED(int, int) called");
    }

    public static void main(String[] args) {
        System.out.println("Test Light constructors:");
        new Light();
        new Light(10);
        new Light(20, "Red");

        System.out.println("\nTest LED constructors:");
        new LED();
        new LED(7);
        new LED(3, 40);
    }
}