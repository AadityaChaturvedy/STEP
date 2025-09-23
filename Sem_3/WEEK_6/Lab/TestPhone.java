package Lab;

class Phone {
    protected String brand;
    protected String model;
    
    public Phone(String brand, String model) {
        System.out.println("Phone constructor called");
        this.brand = brand;
        this.model = model;
    }
}

class SmartPhone extends Phone {
    protected String operatingSystem;
    
    public SmartPhone(String brand, String model, String operatingSystem) {
        super(brand, model);  // calls parent constructor
        System.out.println("SmartPhone constructor called");
        this.operatingSystem = operatingSystem;
    }
}

public class TestPhone {
    public static void main(String[] args) {
        SmartPhone sp = new SmartPhone("Apple", "iPhone 14", "iOS");
    }
}

