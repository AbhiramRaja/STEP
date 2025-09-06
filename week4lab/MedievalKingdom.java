import java.util.*;

abstract class MagicalStructure {
    protected String structureName;
    protected int magicPower;
    protected String location;
    protected boolean isActive;

    public MagicalStructure() {
        this("Unknown", 10, "Mysterious Land", true);
    }

    public MagicalStructure(String structureName) {
        this(structureName, 20, "Enchanted Plains", true);
    }

    public MagicalStructure(String structureName, int magicPower) {
        this(structureName, magicPower, "Ancient Valley", true);
    }

    public MagicalStructure(String structureName, int magicPower, String location, boolean isActive) {
        this.structureName = structureName;
        this.magicPower = magicPower;
        this.location = location;
        this.isActive = isActive;
    }

    public abstract void castMagicSpell();
}

class WizardTower extends MagicalStructure {
    private int spellCapacity;
    private String[] knownSpells;

    public WizardTower() {
        this("Wizard Tower", 50, "Arcane Peak", true, 3, new String[]{"Fireball", "Shield"});
    }

    public WizardTower(String name, int capacity) {
        this(name, 70, "Crystal Hill", true, capacity, new String[]{"Lightning"});
    }

    public WizardTower(String name, int magicPower, String loc, boolean active, int spellCapacity, String[] knownSpells) {
        super(name, magicPower, loc, active);
        this.spellCapacity = spellCapacity;
        this.knownSpells = knownSpells;
    }

    public void castMagicSpell() {
        System.out.println(structureName + " casts a powerful spell!");
    }
}

class EnchantedCastle extends MagicalStructure {
    private int defenseRating;
    private boolean hasDrawbridge;

    public EnchantedCastle() {
        this("Enchanted Castle", 40, "Royal Grounds", true, 100, true);
    }

    public EnchantedCastle(String name, int defenseRating) {
        this(name, 60, "Sacred Lands", true, defenseRating, false);
    }

    public EnchantedCastle(String name, int magicPower, String loc, boolean active, int defenseRating, boolean hasDrawbridge) {
        super(name, magicPower, loc, active);
        this.defenseRating = defenseRating;
        this.hasDrawbridge = hasDrawbridge;
    }

    public void castMagicSpell() {
        System.out.println(structureName + " strengthens defenses with magic!");
    }
}

class MysticLibrary extends MagicalStructure {
    private int bookCount;
    private String ancientLanguage;

    public MysticLibrary() {
        this("Mystic Library", 30, "Silent Woods", true, 1000, "Elder Tongue");
    }

    public MysticLibrary(String name, int bookCount) {
        this(name, 40, "Hidden Forest", true, bookCount, "Unknown");
    }

    public MysticLibrary(String name, int magicPower, String loc, boolean active, int bookCount, String language) {
        super(name, magicPower, loc, active);
        this.bookCount = bookCount;
        this.ancientLanguage = language;
    }

    public void castMagicSpell() {
        System.out.println(structureName + " reveals ancient knowledge!");
    }
}

class DragonLair extends MagicalStructure {
    private String dragonType;
    private int treasureValue;

    public DragonLair() {
        this("Dragon Lair", 80, "Volcanic Mountain", true, "Fire Dragon", 5000);
    }

    public DragonLair(String name, String dragonType) {
        this(name, 90, "Cave of Doom", true, dragonType, 3000);
    }

    public DragonLair(String name, int magicPower, String loc, boolean active, String dragonType, int treasureValue) {
        super(name, magicPower, loc, active);
        this.dragonType = dragonType;
        this.treasureValue = treasureValue;
    }

    public void castMagicSpell() {
        System.out.println(structureName + " unleashes dragon fury!");
    }
}

class KingdomManager {
    public static boolean canStructuresInteract(MagicalStructure s1, MagicalStructure s2) {
        return (s1 instanceof WizardTower && s2 instanceof MysticLibrary) ||
               (s1 instanceof EnchantedCastle && s2 instanceof DragonLair);
    }

    public static String performMagicBattle(MagicalStructure attacker, MagicalStructure defender) {
        return attacker.magicPower > defender.magicPower ? attacker.structureName + " wins!" : defender.structureName + " prevails!";
    }

    public static int calculateKingdomMagicPower(MagicalStructure[] structures) {
        int total = 0;
        for (MagicalStructure s : structures) {
            total += s.magicPower;
        }
        return total;
    }
}

public class MedievalKingdom {
    public static void main(String[] args) {
        WizardTower t1 = new WizardTower();
        EnchantedCastle c1 = new EnchantedCastle();
        MysticLibrary l1 = new MysticLibrary();
        DragonLair d1 = new DragonLair();

        t1.castMagicSpell();
        c1.castMagicSpell();
        l1.castMagicSpell();
        d1.castMagicSpell();

        MagicalStructure[] kingdom = {t1, c1, l1, d1};
        System.out.println("Total Magic Power: " + KingdomManager.calculateKingdomMagicPower(kingdom));
        System.out.println("Interaction possible: " + KingdomManager.canStructuresInteract(t1, l1));
        System.out.println("Battle Result: " + KingdomManager.performMagicBattle(d1, c1));
    }
}
