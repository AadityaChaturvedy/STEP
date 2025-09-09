import java.util.*;

class VirtualPet {
    // Fields
    private final String petId;
    private String petName, species;
    private int age, happiness, health;
    private String evolutionStage;
    private boolean isGhost;

    // Static fields
    static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder"};
    static int totalPetsCreated = 0;

    // Main constructor
    public VirtualPet(String name, String species, int age, int happiness, int health, String stage) {
        this.petId = generatePetId();
        this.petName = name;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.evolutionStage = stage;
        this.isGhost = false;
        totalPetsCreated++;
    }

    // Default constructor: mysterious egg
    public VirtualPet() {
        this("Unknown", randomSpecies(), 0, 50, 50, EVOLUTION_STAGES[0]);
    }

    // Constructor with name only
    public VirtualPet(String name) {
        this(name, randomSpecies(), 1, 60, 60, EVOLUTION_STAGES[1]);
    }

    // Constructor with name and species
    public VirtualPet(String name, String species) {
        this(name, species, 2, 70, 70, EVOLUTION_STAGES[2]);
    }

    // Static helper for ID generation
    private static String generatePetId() {
        return UUID.randomUUID().toString();
    }

    // Random species generator
    private static String randomSpecies() {
        String[] speciesList = {"Dragon", "Phoenix", "Unicorn", "Griffin"};
        return speciesList[new Random().nextInt(speciesList.length)];
    }

    // Methods
    public void feedPet() {
        if (!isGhost) health += 10;
    }

    public void playWithPet() {
        if (!isGhost) happiness += 10;
    }

    public void healPet() {
        if (!isGhost) health += 15;
    }

    public void simulateDay() {
        if (isGhost) return;
        age++;
        happiness -= new Random().nextInt(5);
        health -= new Random().nextInt(10);
        if (health <= 0) {
            isGhost = true;
            species = "Ghost";
            evolutionStage = "Ghost";
        } else {
            evolvePet();
        }
    }

    public void evolvePet() {
        if (isGhost) return;
        if (age >= 0 && age < 2) evolutionStage = EVOLUTION_STAGES[1];
        else if (age < 4) evolutionStage = EVOLUTION_STAGES[2];
        else if (age < 6) evolutionStage = EVOLUTION_STAGES[3];
        else if (age < 8) evolutionStage = EVOLUTION_STAGES[4];
        else evolutionStage = EVOLUTION_STAGES[5];
    }

    public String getPetStatus() {
        return petName + " [" + species + "] - Stage: " + evolutionStage + ", Age: " + age +
               ", Happiness: " + happiness + ", Health: " + health + (isGhost ? " (GHOST)" : "");
    }
}

public class VirtualPetSimulator {
    public static void main(String[] args) {
        List<VirtualPet> daycare = new ArrayList<>();
        daycare.add(new VirtualPet());
        daycare.add(new VirtualPet("Fluffy"));
        daycare.add(new VirtualPet("Sparky", "Dragon"));
        daycare.add(new VirtualPet("Luna", "Phoenix", 3, 80, 90, "Child"));

        for (int day = 1; day <= 5; day++) {
            System.out.println("Day " + day + " Simulation:");
            for (VirtualPet pet : daycare) {
                pet.simulateDay();
                System.out.println(pet.getPetStatus());
            }
            System.out.println("----");
        }
    }
}
