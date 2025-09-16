import java.util.Objects;
import java.util.UUID;

public class VirtualPetSystem {

    // ---------------- IMMUTABLE CLASS ----------------
    public static final class PetSpecies {
        private final String speciesName;
        private final String[] evolutionStages;
        private final int maxLifespan;
        private final String habitat;

        public PetSpecies(String speciesName, String[] evolutionStages, int maxLifespan, String habitat) {
            if (speciesName == null || speciesName.isBlank())
                throw new IllegalArgumentException("Species name cannot be empty");
            if (evolutionStages == null || evolutionStages.length == 0)
                throw new IllegalArgumentException("Species must have at least one stage");
            if (maxLifespan <= 0) throw new IllegalArgumentException("Invalid lifespan");
            if (habitat == null || habitat.isBlank())
                throw new IllegalArgumentException("Habitat cannot be empty");

            this.speciesName = speciesName;
            this.evolutionStages = evolutionStages.clone(); // defensive copy
            this.maxLifespan = maxLifespan;
            this.habitat = habitat;
        }

        public String getSpeciesName() { return speciesName; }
        public String[] getEvolutionStages() { return evolutionStages.clone(); }
        public int getMaxLifespan() { return maxLifespan; }
        public String getHabitat() { return habitat; }

        @Override
        public String toString() {
            return speciesName + " (Habitat: " + habitat + ")";
        }
    }

    // ---------------- VIRTUAL PET CLASS ----------------
    public static class VirtualPet {
        // Immutable core
        private final String petId;
        private final PetSpecies species;
        private final long birthTimestamp;

        // Mutable controlled state
        private String petName;
        private int age, happiness, health;

        // Access levels
        protected static final String[] DEFAULT_EVOLUTION_STAGES = {"Egg", "Young", "Adult", "Elder"};
        static final int MAX_HAPPINESS = 100, MAX_HEALTH = 100;
        public static final String PET_SYSTEM_VERSION = "2.0";

        // Constructors with chaining
        public VirtualPet() {
            this("Defaulty", new PetSpecies("Generic", DEFAULT_EVOLUTION_STAGES, 100, "Land"),
                    0, 50, 50);
        }

        public VirtualPet(String name) {
            this(name, new PetSpecies("Generic", DEFAULT_EVOLUTION_STAGES, 100, "Land"),
                    0, 50, 50);
        }

        public VirtualPet(String name, PetSpecies species) {
            this(name, species, 0, 50, 50);
        }

        public VirtualPet(String name, PetSpecies species, int age, int happiness, int health) {
            if (name == null || name.isBlank()) throw new IllegalArgumentException("Name required");
            this.petId = generatePetId();
            this.species = Objects.requireNonNull(species);
            this.birthTimestamp = System.currentTimeMillis();

            this.petName = name;
            setAge(age);
            setHappiness(happiness);
            setHealth(health);
        }

        // JavaBean getters/setters
        public String getPetName() { return petName; }
        public void setPetName(String petName) { this.petName = petName; }

        public int getAge() { return age; }
        public void setAge(int age) { this.age = Math.max(0, age); }

        public int getHappiness() { return happiness; }
        public void setHappiness(int happiness) { this.happiness = validateStat(happiness); }

        public int getHealth() { return health; }
        public void setHealth(int health) { this.health = validateStat(health); }

        // Public methods
        public void feedPet(String foodType) {
            modifyHealth(calculateFoodBonus(foodType));
        }

        public void playWithPet(String gameType) {
            modifyHappiness(calculateGameEffect(gameType));
        }

        // Protected (internal helpers)
        protected int calculateFoodBonus(String foodType) {
            return foodType.equalsIgnoreCase("fruit") ? 10 : 5;
        }

        protected int calculateGameEffect(String gameType) {
            return gameType.equalsIgnoreCase("fetch") ? 15 : 8;
        }

        // Private (core logic)
        private void modifyHappiness(int delta) {
            this.happiness = Math.min(MAX_HAPPINESS, this.happiness + delta);
            checkEvolution();
        }

        private void modifyHealth(int delta) {
            this.health = Math.min(MAX_HEALTH, this.health + delta);
        }

        private void updateEvolutionStage() {
            // Evolution logic placeholder
        }

        private void checkEvolution() {
            if (happiness > 80 && age > 5) updateEvolutionStage();
        }

        private int validateStat(int value) {
            return Math.max(0, Math.min(100, value));
        }

        private String generatePetId() {
            return UUID.randomUUID().toString();
        }

        // Package-private
        String getInternalState() {
            return "ID: " + petId + " Name: " + petName +
                   " H: " + happiness + " Health: " + health;
        }

        @Override
        public String toString() {
            return petName + " [" + species + "] Age: " + age + " Happiness: " + happiness;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof VirtualPet)) return false;
            VirtualPet v = (VirtualPet) o;
            return petId.equals(v.petId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(petId);
        }
    }

    // ---------------- SPECIALIZED PETS ----------------
    public static class DragonPet {
        private final String dragonType;
        private final String breathWeapon;
        private final VirtualPet basePet;

        public DragonPet(String name, String dragonType, String breathWeapon) {
            this.dragonType = dragonType;
            this.breathWeapon = breathWeapon;
            this.basePet = new VirtualPet(name, new PetSpecies("Dragon",
                    new String[]{"Wyrmling", "Young", "Adult", "Ancient"}, 500, "Caves"));
        }

        public VirtualPet getBasePet() { return basePet; }
        public String getDragonType() { return dragonType; }
        public String getBreathWeapon() { return breathWeapon; }
    }

    public static class RobotPet {
        private boolean needsCharging;
        private int batteryLevel;
        private final VirtualPet basePet;

        public RobotPet(String name) {
            this.needsCharging = false;
            this.batteryLevel = 100;
            this.basePet = new VirtualPet(name, new PetSpecies("Robot",
                    new String[]{"Prototype", "Advanced", "AI Core"}, 9999, "Laboratory"));
        }

        public void chargeBattery() {
            this.batteryLevel = 100;
            this.needsCharging = false;
        }

        public int getBatteryLevel() { return batteryLevel; }
        public boolean isNeedsCharging() { return needsCharging; }
        public VirtualPet getBasePet() { return basePet; }
    }

    // ---------------- DEMO MAIN ----------------
    public static void main(String[] args) {
        // Default VirtualPet
        VirtualPet pet1 = new VirtualPet("Buddy");
        System.out.println("Created pet: " + pet1);

        // Play and feed
        pet1.playWithPet("fetch");
        pet1.feedPet("fruit");
        System.out.println("After play & feed: " + pet1);

        // DragonPet
        DragonPet draco = new DragonPet("Draco", "Fire Dragon", "Fire Breath");
        System.out.println("Dragon: " + draco.getBasePet() +
                " Type=" + draco.getDragonType() + " Weapon=" + draco.getBreathWeapon());

        // RobotPet
        RobotPet robo = new RobotPet("Robo-X");
        System.out.println("Robot: " + robo.getBasePet() +
                " Battery=" + robo.getBatteryLevel());
        robo.chargeBattery();
        System.out.println("After charging: Battery=" + robo.getBatteryLevel());
    }
}
