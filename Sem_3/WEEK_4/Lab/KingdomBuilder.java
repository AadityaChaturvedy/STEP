abstract class MagicalStructure {
    String structureName;
    int magicPower;
    String location;
    boolean isActive;

    public MagicalStructure(String name, int power, String location, boolean active) {
        this.structureName = name;
        this.magicPower = power;
        this.location = location;
        this.isActive = active;
    }

    abstract void castMagicSpell();
}

// Wizard Tower
class WizardTower extends MagicalStructure {
    int spellCapacity;
    String[] knownSpells;

    public WizardTower(String name, int power, String location, boolean active, int spellCapacity, String[] spells) {
        super(name, power, location, active);
        this.spellCapacity = spellCapacity;
        this.knownSpells = spells;
    }

    @Override
    void castMagicSpell() {
        System.out.println(structureName + " casts a powerful wizard spell!");
    }
}

// Enchanted Castle
class EnchantedCastle extends MagicalStructure {
    int defenseRating;
    boolean hasDrawbridge;

    public EnchantedCastle(String name, int power, String location, boolean active, int defense, boolean drawbridge) {
        super(name, power, location, active);
        this.defenseRating = defense;
        this.hasDrawbridge = drawbridge;
    }

    @Override
    void castMagicSpell() {
        System.out.println(structureName + " strengthens its defenses with magic!");
    }
}

// Mystic Library
class MysticLibrary extends MagicalStructure {
    int bookCount;
    String ancientLanguage;

    public MysticLibrary(String name, int power, String location, boolean active, int books, String language) {
        super(name, power, location, active);
        this.bookCount = books;
        this.ancientLanguage = language;
    }

    @Override
    void castMagicSpell() {
        System.out.println(structureName + " unlocks ancient knowledge!");
    }
}

// Dragon Lair
class DragonLair extends MagicalStructure {
    String dragonType;
    int treasureValue;

    public DragonLair(String name, int power, String location, boolean active, String dragon, int treasure) {
        super(name, power, location, active);
        this.dragonType = dragon;
        this.treasureValue = treasure;
    }

    @Override
    void castMagicSpell() {
        System.out.println(structureName + " releases dragon fire!");
    }
}

// Kingdom Manager
class KingdomManager {
    public static boolean canStructuresInteract(MagicalStructure s1, MagicalStructure s2) {
        return s1.isActive && s2.isActive;
    }

    public static String performMagicBattle(MagicalStructure attacker, MagicalStructure defender) {
        if (attacker.magicPower > defender.magicPower) {
            return attacker.structureName + " wins!";
        } else if (attacker.magicPower < defender.magicPower) {
            return defender.structureName + " wins!";
        } else {
            return "It's a draw!";
        }
    }

    public static int calculateKingdomMagicPower(MagicalStructure[] structures) {
        int total = 0;
        for (MagicalStructure s : structures) {
            total += s.magicPower;
        }
        return total;
    }
}

public class KingdomBuilder {
    public static void main(String[] args) {
        MagicalStructure tower = new WizardTower("Tower of Wisdom", 120, "Hilltop", true, 5, new String[]{"Fireball", "Shield"});
        MagicalStructure castle = new EnchantedCastle("Royal Fortress", 90, "Valley", true, 200, true);
        MagicalStructure library = new MysticLibrary("Ancient Library", 80, "Forest", true, 500, "Old Tongue");
        MagicalStructure lair = new DragonLair("Crimson Lair", 150, "Mountain", true, "Fire Dragon", 1000);

        MagicalStructure[] kingdom = {tower, castle, library, lair};

        System.out.println("Total Magic Power: " + KingdomManager.calculateKingdomMagicPower(kingdom));
        System.out.println(KingdomManager.performMagicBattle(tower, lair));
    }
}
