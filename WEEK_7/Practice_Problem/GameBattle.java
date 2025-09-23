
public class GameBattle {

    // Basic attack
    public void attack(int damage) {
        System.out.println("Basic attack for " + damage + " points!");
    }

    // Attack with weapon
    public void attack(int damage, String weapon) {
        System.out.println("Attacking with " + weapon + " for " + damage + " points!");
    }

    // Critical attack
    public void attack(int damage, String weapon, boolean isCritical) {
        if (isCritical) {
            System.out.println("CRITICAL HIT! " + weapon + " deals " + (damage * 2) + " points!");
        } else {
            attack(damage, weapon);
        }
    }

    // Team attack
    public void attack(int damage, String[] teammates) {
        int totalDamage = damage * teammates.length;
        String names = String.join(", ", teammates);
        System.out.println("Team attack with " + names + " for " + totalDamage + " total damage!");
    }

    public static void main(String[] args) {
        GameBattle gb = new GameBattle();
        gb.attack(50); // Basic attack
        gb.attack(75, "Sword"); // Weapon attack
        gb.attack(60, "Bow", true); // Critical attack
        gb.attack(40, new String[]{"Alice", "Bob"}); // Team attack
    }
}

