package Practice;

public class GameBattle {
    // Basic attack for [damage] points!
    public void attack(int damage) {
        System.out.println("Basic attack for " + damage + " points!");
    }

    // Attacking with [weapon] for [damage] points!
    public void attack(int damage, String weapon) {
        System.out.println("Attacking with " + weapon + " for " + damage + " points!");
    }

    // CRITICAL HIT or regular attack
    public void attack(int damage, String weapon, boolean isCritical) {
        if (isCritical) {
            System.out.println("CRITICAL HIT! " + weapon + " deals " + (damage * 2) + " points!");
        } else {
            attack(damage, weapon);
        }
    }

    // Team attack with [teammate names] for [damage * team size] total damage!
    public void attack(int damage, String[] teammates) {
        System.out.print("Team attack with ");
        for (int i = 0; i < teammates.length; i++) {
            System.out.print(teammates[i]);
            if (i < teammates.length - 1) System.out.print(", ");
        }
        System.out.println(" for " + (damage * teammates.length) + " total damage!");
    }

    public static void main(String[] args) {
        GameBattle battle = new GameBattle();
        battle.attack(50); // Basic attack
        battle.attack(75, "Sword"); // Sword attack
        battle.attack(60, "Bow", true); // Critical bow attack
        String[] teammates = { "Alice", "Bob" };
        battle.attack(40, teammates); // Team attack
    }
}