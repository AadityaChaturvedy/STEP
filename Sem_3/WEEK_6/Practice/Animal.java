// Base class: Animal
public class Animal {
    protected String species;
    protected String habitat;
    protected int lifespan;
    protected boolean isWildlife;

    public Animal(String species, String habitat, int lifespan, boolean isWildlife) {
        this.species = species;
        this.habitat = habitat;
        this.lifespan = lifespan;
        this.isWildlife = isWildlife;
        System.out.println("Animal constructor: Creating " + species);
    }

    public void eat() {
        System.out.println("Animal is eating");
    }

    public void sleep() {
        System.out.println("Animal is sleeping");
    }

    public void move() {
        System.out.println("Animal is moving");
    }

    public String getAnimalInfo() {
        return String.format("Species: %s, Habitat: %s, Lifespan: %d, Wildlife: %b",
                species, habitat, lifespan, isWildlife);
    }
}

// Intermediate class: Mammal
class Mammal extends Animal {
    protected String furColor;
    protected boolean hasWarmBlood;
    protected int gestationPeriod;

    public Mammal(String species, String habitat, int lifespan, boolean isWildlife,
                  String furColor, int gestationPeriod) {
        super(species, habitat, lifespan, isWildlife);
        this.furColor = furColor;
        this.gestationPeriod = gestationPeriod;
        this.hasWarmBlood = true; // Always true for mammals
        System.out.println("Mammal constructor: Adding mammal traits");
    }

    @Override
    public void move() {
        super.move();
        System.out.println("Mammal is walking/running");
    }

    public void nurse() {
        System.out.println("Mammal is nursing offspring");
    }

    public void regulateTemperature() {
        System.out.println("Maintaining body temperature");
    }
}

// Specific class: Dog
class Dog extends Mammal {
    private String breed;
    private boolean isDomesticated;
    private int loyaltyLevel; // 1-10
    private String favoriteActivity;

    // Constructor 1: Basic dog
    public Dog(String breed) {
        // Default values for super
        super("Canine", "Domestic", 12, false, "Varied", 63);
        this.breed = breed;
        this.isDomesticated = true;
        this.loyaltyLevel = 7;
        this.favoriteActivity = "Playing fetch";
        System.out.println("Dog constructor: Creating " + breed + " dog (basic)");
    }

    // Constructor 2: Detailed dog
    public Dog(String species, String habitat, int lifespan, boolean isWildlife,
               String furColor, int gestationPeriod,
               String breed, boolean isDomesticated, int loyaltyLevel, String favoriteActivity) {
        super(species, habitat, lifespan, isWildlife, furColor, gestationPeriod);
        this.breed = breed;
        this.isDomesticated = isDomesticated;
        this.loyaltyLevel = loyaltyLevel;
        this.favoriteActivity = favoriteActivity;
        System.out.println("Dog constructor: Creating " + breed + " dog (detailed)");
    }

    // Constructor 3: Copy constructor
    public Dog(Dog other) {
        this(other.species, other.habitat, other.lifespan, other.isWildlife,
             other.furColor, other.gestationPeriod,
             other.breed, other.isDomesticated, other.loyaltyLevel, other.favoriteActivity);
        System.out.println("Dog constructor: Copying dog " + other.breed);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Dog is wagging tail while eating");
    }

    @Override
    public void move() {
        System.out.println("Dog is running and playing");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping in doghouse");
    }

    public void bark() {
        System.out.println("Woof! Woof!");
    }

    public void fetch() {
        System.out.println("Dog is fetching the ball");
    }

    public void showLoyalty() {
        System.out.println("Dog's loyalty level: " + loyaltyLevel + "/10");
    }

    // Calls methods from all three levels
    public void demonstrateInheritance() {
        eat();                  // Dog-level eat
        sleep();                // Dog-level sleep
        move();                 // Dog-level move
        nurse();                // Mammal-level method
        regulateTemperature();  // Mammal-level method
        bark();                 // Dog-level method
        fetch();                // Dog-level method
        System.out.println(getAnimalInfo()); // Animal-level method
    }

    // Expose some inherited fields for demonstration
    public void printInheritedFields() {
        System.out.println("Species: " + species);
        System.out.println("Habitat: " + habitat);
        System.out.println("Lifespan: " + lifespan);
        System.out.println("Wildlife: " + isWildlife);
        System.out.println("FurColor: " + furColor);
        System.out.println("GestationPeriod: " + gestationPeriod);
        System.out.println("HasWarmBlood: " + hasWarmBlood);
        System.out.println("Breed: " + breed);
        System.out.println("Domesticated: " + isDomesticated);
        System.out.println("LoyaltyLevel: " + loyaltyLevel);
        System.out.println("FavoriteActivity: " + favoriteActivity);
    }
}

// Main method: Test all requirements
class MultilevelInheritanceDemo {
    public static void main(String[] args) {
        System.out.println("== Constructor Chaining: Basic Dog ==");
        Dog dog1 = new Dog("Labrador");

        System.out.println("\n== Constructor Chaining: Detailed Dog ==");
        Dog dog2 = new Dog(
            "Canine", "Domestic", 15, false,
            "Golden", 65,
            "Golden Retriever", true, 10, "Swimming"
        );

        System.out.println("\n== Constructor Chaining: Copy Dog ==");
        Dog dog3 = new Dog(dog2);

        System.out.println("\n== Method Overriding Across Levels ==");
        dog1.eat();    // Should show animal and dog eat behaviors
        dog1.move();   // Should show dog move behavior only
        dog1.sleep();  // Should show dog sleep behavior

        System.out.println("\n== Demonstrate Inheritance Chain ==");
        dog2.demonstrateInheritance();

        System.out.println("\n== Access Inherited Members ==");
        dog2.printInheritedFields();

        System.out.println("\n== IS-A Relationship Checks ==");
        System.out.println("dog1 instanceof Animal: " + (dog1 instanceof Animal));
        System.out.println("dog1 instanceof Mammal: " + (dog1 instanceof Mammal));
        System.out.println("dog1 instanceof Dog: " + (dog1 instanceof Dog));

        System.out.println("\n== Multiple Initialization Paths ==");
        Dog dog4 = new Dog("Bulldog");
        Dog dog5 = new Dog("Canine", "Farm", 10, true, "White", 62, "Sheepdog", false, 6, "Herding sheep");
    }
}
