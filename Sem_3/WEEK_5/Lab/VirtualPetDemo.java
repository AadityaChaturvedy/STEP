package Lab;

import java.util.*;

final class PetSpecies {
    private final String name;
    private final String[] stages;
    private final int lifespan;
    private final String habitat;

    public PetSpecies(String n, String[] st, int l, String h) {
        if (n == null || st == null || st.length == 0 || l <= 0 || h == null) throw new IllegalArgumentException();
        name = n; stages = st.clone(); lifespan = l; habitat = h;
    }
    public String getName() { return name; }
    public String[] getStages() { return stages.clone(); }
    public int getLifespan() { return lifespan; }
    public String getHabitat() { return habitat; }
    public String toString() { return name; }
}

class VirtualPet {
    private final String petId;
    private final PetSpecies species;
    private final long birthTimestamp;
    private String petName;
    private int age, happiness, health;
    protected static final String[] DEFAULT_EVOLUTION_STAGES = {"Egg", "Child", "Adult"};
    static final int MAX_HAPPINESS = 100, MAX_HEALTH = 100;
    public static final String PET_SYSTEM_VERSION = "2.0";

    public VirtualPet() {
        this("Pet" + System.nanoTime(), new PetSpecies("Kikko", DEFAULT_EVOLUTION_STAGES, 100, "Forest"),
                System.currentTimeMillis(), "Buddy", 0, 50, 50);
    }
    public VirtualPet(String n) {
        this("Pet" + System.nanoTime(), new PetSpecies("Kikko", DEFAULT_EVOLUTION_STAGES, 100, "Forest"),
                System.currentTimeMillis(), n, 0, 60, 60);
    }
    public VirtualPet(String n, PetSpecies s) {
        this("Pet" + System.nanoTime(), s, System.currentTimeMillis(), n, 0, 70, 70);
    }
    public VirtualPet(String id, PetSpecies s, long bt, String n, int a, int ha, int he) {
        petId = id; species = s; birthTimestamp = bt; setPetName(n); setAge(a); setHappiness(ha); setHealth(he);
    }
    public String getPetName() { return petName; }
    public void setPetName(String n) { if (n == null || n.isEmpty()) throw new IllegalArgumentException(); petName = n; }
    public int getAge() { return age; }
    public void setAge(int a) { if (a < 0) throw new IllegalArgumentException(); age = a; }
    public int getHappiness() { return happiness; }
    public void setHappiness(int h) { happiness = Math.max(0, Math.min(MAX_HAPPINESS, h)); }
    public int getHealth() { return health; }
    public void setHealth(int h) { health = Math.max(0, Math.min(MAX_HEALTH, h)); }
    public void feedPet(String f) { modifyHappiness(10); modifyHealth(5); }
    public void playWithPet(String g) { modifyHappiness(12); }
    protected int calculateFoodBonus(String ft) { return 10; }
    protected int calculateGameEffect(String gt) { return 12; }
    private void modifyHappiness(int d) { setHappiness(happiness + d); }
    private void modifyHealth(int d) { setHealth(health + d); }
    String getInternalState() { return petId + "|" + age + "|" + happiness + "|" + health; }
    public String toString() { return "VirtualPet{" + petId + ", " + species + ", " + petName + ", h=" + happiness + ", he=" + health + "}"; }
}

class DragonPet {
    private final String dragonType, breathWeapon;
    private final VirtualPet core;
    public DragonPet(String t, String w, VirtualPet v) {
        if (t == null || w == null || v == null) throw new IllegalArgumentException();
        dragonType = t; breathWeapon = w; core = v;
    }
    public String getDragonType() { return dragonType; }
    public String getBreathWeapon() { return breathWeapon; }
    public VirtualPet getCore() { return core; }
}

class RobotPet {
    private boolean needsCharging;
    private int batteryLevel;
    private final VirtualPet core;
    public RobotPet(boolean nc, int bl, VirtualPet v) {
        needsCharging = nc; batteryLevel = bl; core = v;
    }
    public boolean isNeedsCharging() { return needsCharging; }
    public int getBatteryLevel() { return batteryLevel; }
    public VirtualPet getCore() { return core; }
}

public class VirtualPetDemo {
    public static void main(String[] args) {
        VirtualPet pet = new VirtualPet("Firry");
        System.out.println(pet);
        pet.feedPet("Berries");
        pet.playWithPet("Fetch");
        System.out.println("After actions: " + pet.getInternalState());
        PetSpecies dragonSpecies = new PetSpecies("Drake", new String[]{"Hatchling", "Wyrm", "Dragon"}, 300, "Cave");
        DragonPet dragon = new DragonPet("Fire", "Flame", new VirtualPet("Blaze", dragonSpecies));
        System.out.println("DragonPet created, type: " + dragon.getDragonType() + ", weapon: " + dragon.getBreathWeapon());
        RobotPet robo = new RobotPet(true, 80, new VirtualPet("Rex"));
        System.out.println("RobotPet needs charging: " + robo.isNeedsCharging() + ", battery=" + robo.getBatteryLevel());
    }
}
