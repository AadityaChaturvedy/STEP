import java.util.*;

public class MedievalKingdomSystem {

    // ---------------- IMMUTABLE CONFIG ----------------
    public static final class KingdomConfig {
        private final String kingdomName;
        private final int foundingYear;
        private final String[] allowedStructureTypes;
        private final Map<String, Integer> resourceLimits;

        private KingdomConfig(String kingdomName, int foundingYear,
                              String[] allowedStructureTypes, Map<String, Integer> resourceLimits) {
            if (kingdomName == null || kingdomName.isBlank())
                throw new IllegalArgumentException("Kingdom name cannot be empty");
            if (foundingYear <= 0) throw new IllegalArgumentException("Invalid founding year");
            if (allowedStructureTypes == null || allowedStructureTypes.length == 0)
                throw new IllegalArgumentException("At least one structure type required");
            if (resourceLimits == null || resourceLimits.isEmpty())
                throw new IllegalArgumentException("Resource limits required");

            this.kingdomName = kingdomName;
            this.foundingYear = foundingYear;
            this.allowedStructureTypes = allowedStructureTypes.clone(); // defensive copy
            this.resourceLimits = new HashMap<>(resourceLimits);
        }

        // Factory methods
        public static KingdomConfig createDefaultKingdom() {
            return new KingdomConfig("Avaloria", 1023,
                    new String[]{"WizardTower", "EnchantedCastle", "MysticLibrary", "DragonLair"},
                    Map.of("Gold", 10000, "Food", 5000, "Mana", 2000));
        }

        public static KingdomConfig createFromTemplate(String type) {
            if ("small".equalsIgnoreCase(type)) {
                return new KingdomConfig("Tinyshire", 1100,
                        new String[]{"WizardTower", "Castle"},
                        Map.of("Gold", 2000, "Food", 1000, "Mana", 500));
            } else if ("large".equalsIgnoreCase(type)) {
                return new KingdomConfig("Grandoria", 900,
                        new String[]{"WizardTower", "EnchantedCastle", "MysticLibrary", "DragonLair"},
                        Map.of("Gold", 50000, "Food", 20000, "Mana", 10000));
            }
            return createDefaultKingdom();
        }

        public String getKingdomName() { return kingdomName; }
        public int getFoundingYear() { return foundingYear; }
        public String[] getAllowedStructureTypes() { return allowedStructureTypes.clone(); }
        public Map<String, Integer> getResourceLimits() { return new HashMap<>(resourceLimits); }

        @Override
        public String toString() {
            return kingdomName + " (Founded: " + foundingYear + ")";
        }
    }

    // ---------------- BASE STRUCTURE ----------------
    public static class MagicalStructure {
        private final String structureId;
        private final long constructionTimestamp;
        private final String structureName;
        private final String location;

        private int magicPower;
        private boolean isActive;
        private String currentMaintainer;

        static final int MIN_MAGIC_POWER = 0, MAX_MAGIC_POWER = 1000;
        public static final String MAGIC_SYSTEM_VERSION = "3.0";

        // Constructor chaining
        public MagicalStructure(String name, String location) {
            this(name, location, 100, true);
        }

        public MagicalStructure(String name, String location, int power) {
            this(name, location, power, true);
        }

        public MagicalStructure(String name, String location, int power, boolean active) {
            if (name == null || name.isBlank()) throw new IllegalArgumentException("Name required");
            if (location == null || location.isBlank()) throw new IllegalArgumentException("Location required");
            if (power < MIN_MAGIC_POWER || power > MAX_MAGIC_POWER)
                throw new IllegalArgumentException("Invalid magic power");

            this.structureId = UUID.randomUUID().toString();
            this.constructionTimestamp = System.currentTimeMillis();
            this.structureName = name;
            this.location = location;
            this.magicPower = power;
            this.isActive = active;
            this.currentMaintainer = "Unknown";
        }

        // JavaBean compliance
        public String getStructureName() { return structureName; }
        public String getLocation() { return location; }
        public int getMagicPower() { return magicPower; }
        public void setMagicPower(int power) {
            this.magicPower = Math.max(MIN_MAGIC_POWER, Math.min(MAX_MAGIC_POWER, power));
        }
        public boolean isActive() { return isActive; }
        public void setActive(boolean active) { this.isActive = active; }
        public String getCurrentMaintainer() { return currentMaintainer; }
        public void setCurrentMaintainer(String maintainer) { this.currentMaintainer = maintainer; }

        @Override
        public String toString() {
            return structureName + " @ " + location + " (Power: " + magicPower + ")";
        }
    }

    // ---------------- SPECIALIZED STRUCTURES ----------------
    public static class WizardTower {
        private final int maxSpellCapacity;
        private List<String> knownSpells;
        private String currentWizard;
        private final MagicalStructure base;

        // Constructor variations
        public WizardTower(String name, String location) {
            this(name, location, 50, new ArrayList<>(), "Vacant");
        }
        public WizardTower(String name, String location, List<String> spells) {
            this(name, location, 200, spells, "Archmage");
        }
        public WizardTower(String name, String location, int capacity, List<String> spells, String wizard) {
            this.maxSpellCapacity = capacity;
            this.knownSpells = new ArrayList<>(spells);
            this.currentWizard = wizard;
            this.base = new MagicalStructure(name, location);
        }

        public String getCurrentWizard() { return currentWizard; }
        public List<String> getKnownSpells() { return new ArrayList<>(knownSpells); }
        public MagicalStructure getBase() { return base; }

        @Override
        public String toString() {
            return "WizardTower of " + currentWizard + " Spells=" + knownSpells;
        }
    }

    public static class EnchantedCastle {
        private final String castleType;
        private int defenseRating;
        private boolean hasDrawbridge;
        private final MagicalStructure base;

        public EnchantedCastle(String name, String location) {
            this(name, location, "Fort", 100, true);
        }
        public EnchantedCastle(String name, String location, String type) {
            this(name, location, type, 200, true);
        }
        public EnchantedCastle(String name, String location, String type, int defense, boolean drawbridge) {
            this.castleType = type;
            this.defenseRating = defense;
            this.hasDrawbridge = drawbridge;
            this.base = new MagicalStructure(name, location);
        }

        @Override
        public String toString() {
            return "Castle[" + castleType + "] Defense=" + defenseRating + " Drawbridge=" + hasDrawbridge;
        }
    }

    public static class MysticLibrary {
        private final Map<String, String> bookCollection;
        private int knowledgeLevel;
        private final MagicalStructure base;

        public MysticLibrary(String name, String location) {
            this(name, location, Map.of("Book1","Basics"), 50);
        }
        public MysticLibrary(String name, String location, Map<String,String> books, int level) {
            this.bookCollection = new HashMap<>(books);
            this.knowledgeLevel = level;
            this.base = new MagicalStructure(name, location);
        }

        @Override
        public String toString() {
            return "Library Knowledge=" + knowledgeLevel + " Books=" + bookCollection.size();
        }
    }

    public static class DragonLair {
        private final String dragonType;
        private long treasureValue;
        private int territorialRadius;
        private final MagicalStructure base;

        public DragonLair(String type) {
            this(type, "Hidden Valley", 1000, 50);
        }
        public DragonLair(String type, String location, long treasure, int radius) {
            this.dragonType = type;
            this.treasureValue = treasure;
            this.territorialRadius = radius;
            this.base = new MagicalStructure(type + " Lair", location);
        }

        @Override
        public String toString() {
            return dragonType + " Lair Treasure=" + treasureValue + " Radius=" + territorialRadius;
        }
    }

    // ---------------- MANAGER ----------------
    public static class KingdomManager {
        private final List<Object> structures = new ArrayList<>();
        private final KingdomConfig config;

        public KingdomManager(KingdomConfig config) {
            this.config = config;
        }

        public void addStructure(Object s) { structures.add(s); }

        public static boolean canStructuresInteract(Object s1, Object s2) {
            return (s1 instanceof WizardTower && s2 instanceof MysticLibrary) ||
                   (s1 instanceof DragonLair && s2 instanceof EnchantedCastle);
        }

        public static String performMagicBattle(Object attacker, Object defender) {
            if (attacker instanceof WizardTower && defender instanceof DragonLair) {
                return "Wizard Tower casts spells on Dragon!";
            } else if (attacker instanceof DragonLair && defender instanceof EnchantedCastle) {
                return "Dragon attacks Castle!";
            }
            return "No effect.";
        }

        public static int calculateKingdomPower(Object[] structures) {
            int total = 0;
            for (Object s : structures) {
                if (s instanceof WizardTower) total += 200;
                else if (s instanceof EnchantedCastle) total += 300;
                else if (s instanceof MysticLibrary) total += 150;
                else if (s instanceof DragonLair) total += 500;
            }
            return total;
        }

        private String determineStructureCategory(Object structure) {
            if (structure instanceof WizardTower) return "Wizard Tower";
            if (structure instanceof EnchantedCastle) return "Castle";
            if (structure instanceof MysticLibrary) return "Library";
            if (structure instanceof DragonLair) return "Dragon Lair";
            return "Unknown";
        }

        @Override
        public String toString() {
            return "Kingdom " + config.getKingdomName() + " with " + structures.size() + " structures.";
        }
    }

    // ---------------- DEMO MAIN ----------------
    public static void main(String[] args) {
        KingdomConfig config = KingdomConfig.createDefaultKingdom();
        KingdomManager manager = new KingdomManager(config);

        WizardTower tower = new WizardTower("Highspire", "North Hill", List.of("Fireball","Shield"));
        EnchantedCastle castle = new EnchantedCastle("Stonekeep", "Central Plains", "Royal");
        MysticLibrary library = new MysticLibrary("Arcana", "East Wing");
        DragonLair lair = new DragonLair("Fire Dragon");

        manager.addStructure(tower);
        manager.addStructure(castle);
        manager.addStructure(library);
        manager.addStructure(lair);

        System.out.println(manager);
        System.out.println(tower);
        System.out.println(castle);
        System.out.println(library);
        System.out.println(lair);

        System.out.println("Interaction? " + KingdomManager.canStructuresInteract(tower, library));
        System.out.println("Battle: " + KingdomManager.performMagicBattle(tower, lair));
        System.out.println("Total Kingdom Power: " +
                KingdomManager.calculateKingdomPower(new Object[]{tower, castle, library, lair}));
    }
}
