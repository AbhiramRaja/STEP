import java.util.*;

class VirtualPet {
    private final String petId;
    private String petName;
    private String species;
    private int age;
    private int happiness;
    private int health;
    private String stage;
    private static int totalPetsCreated = 0;
    private static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder"};

    // Default constructor - mysterious egg
    public VirtualPet() {
        this("Unknown", getRandomSpecies(), 0, 50, 50, EVOLUTION_STAGES[0]);
    }

    // Constructor with name only
    public VirtualPet(String petName) {
        this(petName, getRandomSpecies(), 1, 60, 60, EVOLUTION_STAGES[1]);
    }

    // Constructor with name and species
    public VirtualPet(String petName, String species) {
        this(petName, species, 3, 70, 70, EVOLUTION_STAGES[2]);
    }

    // Full constructor
    public VirtualPet(String petName, String species, int age, int happiness, int health, String stage) {
        this.petId = generatePetId();
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.stage = stage;
        totalPetsCreated++;
    }

    private static String getRandomSpecies() {
        String[] speciesList = {"Dragon", "Phoenix", "Unicorn", "Griffin", "Wolf"};
        Random rand = new Random();
        return speciesList[rand.nextInt(speciesList.length)];
    }

    public void evolvePet() {
        if (health <= 0) {
            stage = "Ghost";
            return;
        }
        int index = Math.min(age / 3, EVOLUTION_STAGES.length - 1);
        stage = EVOLUTION_STAGES[index];
    }

    public void feedPet() {
        if (health > 0) {
            health = Math.min(100, health + 10);
        }
    }

    public void playWithPet() {
        if (health > 0) {
            happiness = Math.min(100, happiness + 10);
        }
    }

    public void healPet() {
        if (health > 0) {
            health = Math.min(100, health + 20);
        }
    }

    public void simulateDay() {
        if (health > 0) {
            age++;
            happiness -= 5;
            health -= 5;
            evolvePet();
        }
    }

    public String getPetStatus() {
        return String.format("Pet %s (%s) - Stage: %s | Age: %d | Health: %d | Happiness: %d", petName, species, stage, age, health, happiness);
    }

    public static String generatePetId() {
        return UUID.randomUUID().toString();
    }

    public static int getTotalPetsCreated() {
        return totalPetsCreated;
    }
}

public class VirtualPetSimulator {
    public static void main(String[] args) {
        VirtualPet p1 = new VirtualPet();
        VirtualPet p2 = new VirtualPet("Fluffy");
        VirtualPet p3 = new VirtualPet("Spark", "Phoenix");

        for (int i = 0; i < 5; i++) {
            p1.simulateDay();
            p2.playWithPet();
            p3.feedPet();
            p3.simulateDay();
        }

        System.out.println(p1.getPetStatus());
        System.out.println(p2.getPetStatus());
        System.out.println(p3.getPetStatus());
        System.out.println("Total Pets: " + VirtualPet.getTotalPetsCreated());
    }
}
