package Lab;

import java.util.*;

final class KingdomConfig {
    private final String kingdomName;
    private final int foundingYear;
    private final String[] allowedTypes;
    private final Map<String, Integer> resourceLimits;

    public KingdomConfig(String n, int y, String[] t, Map<String, Integer> rl) {
        if (n == null || t == null || t.length == 0 || rl == null) throw new IllegalArgumentException();
        kingdomName = n;
        foundingYear = y;
        allowedTypes = t.clone();
        resourceLimits = new HashMap<>(rl);
    }
    public String getKingdomName() { return kingdomName; }
    public int getFoundingYear() { return foundingYear; }
    public String[] getAllowedStructureTypes() { return allowedTypes.clone(); }
    public Map<String, Integer> getResourceLimits() { return new HashMap<>(resourceLimits); }
}

class MagicalStructure {
    private final String id, name, loc;
    private final long ts;
    private int magicPower;
    private boolean isActive;
    private String maintainer;
    static final int MIN_MAGIC_POWER = 0, MAX_MAGIC_POWER = 1000;
    public static final String MAGIC_SYSTEM_VERSION = "3.0";

    public MagicalStructure(String n, String l) { this(n, l, 50, true); }
    public MagicalStructure(String n, String l, int p) { this(n, l, p, true); }
    public MagicalStructure(String n, String l, int p, boolean a) {
        id = "S" + System.nanoTime();
        name = n;
        loc = l;
        ts = System.currentTimeMillis();
        setMagicPower(p);
        isActive = a;
        maintainer = "None";
    }
    public void setMagicPower(int p) { if (p < MIN_MAGIC_POWER || p > MAX_MAGIC_POWER) throw new IllegalArgumentException(); magicPower = p; }
    public int getMagicPower() { return magicPower; }
    public boolean isActive() { return isActive; }
    public String toString() { return name + "(" + magicPower + ")"; }
}

class WizardTower {
    private final int maxSpellCap;
    private final List<String> knownSpells;
    private final String wizard;
    private final MagicalStructure core;
    public WizardTower(String n, String l) { this(n, l, 5, new ArrayList<>(), "Merlin"); }
    public WizardTower(String n, String l, int cap, List<String> spells, String w) {
        core = new MagicalStructure(n, l);
        maxSpellCap = cap;
        knownSpells = spells;
        wizard = w;
    }
    public String getWizard() { return wizard; }
}

class EnchantedCastle {
    private final String type;
    private int defenseRating;
    private boolean drawbridge;
    private final MagicalStructure core;
    public EnchantedCastle(String t, int d, boolean db, String n, String l) {
        core = new MagicalStructure(n, l);
        type = t;
        defenseRating = d;
        drawbridge = db;
    }
}

class MysticLibrary {
    private final Map<String, String> books;
    private int knowledgeLevel;
    private final MagicalStructure core;
    public MysticLibrary(Map<String, String> b, int k, String n, String l) {
        core = new MagicalStructure(n, l);
        books = b;
        knowledgeLevel = k;
    }
}

class DragonLair {
    private final String dragonType;
    private long treasure;
    private int radius;
    private final MagicalStructure core;
    public DragonLair(String t, long tr, int r, String n, String l) {
        core = new MagicalStructure(n, l);
        dragonType = t;
        treasure = tr;
        radius = r;
    }
}

class KingdomManager {
    private final List<Object> structures = new ArrayList<>();
    private final KingdomConfig config;
    public KingdomManager(KingdomConfig c) { config = c; }
    public void addStructure(Object o) { structures.add(o); }
    public static boolean canStructuresInteract(Object s1, Object s2) {
        return (s1 instanceof WizardTower && s2 instanceof MysticLibrary);
    }
    public static String performMagicBattle(Object a, Object d) {
        return "Winner: " + (a instanceof WizardTower ? "WizardTower" : "Unknown");
    }
    public static int calculateKingdomPower(Object[] arr) {
        int sum = 0;
        for (Object o : arr) if (o instanceof MagicalStructure m) sum += m.getMagicPower();
        return sum;
    }
}

public class MedievalKingdomDemo {
    public static void main(String[] args) {
        KingdomConfig cfg = new KingdomConfig("Camelot", 1100, new String[]{"Tower"}, Map.of("Mana", 10000));
        WizardTower wt = new WizardTower("Ivory Spire", "North Hill");
        MysticLibrary ml = new MysticLibrary(Map.of("Spells", "Ancient Tome"), 5, "Grand Library", "South Wing");
        System.out.println("Kingdom: " + cfg.getKingdomName());
        System.out.println("Can interact: " + KingdomManager.canStructuresInteract(wt, ml));
        System.out.println(KingdomManager.performMagicBattle(wt, ml));
        MagicalStructure cs = new MagicalStructure("Walls", "Main Gate", 70, true);
        System.out.println("Total Power: " + KingdomManager.calculateKingdomPower(new Object[]{wt, cs}));
    }
}