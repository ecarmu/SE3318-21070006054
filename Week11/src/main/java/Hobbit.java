import java.util.Random;

/**
 * Class representing a Hobbit character. Hobbits are less likely to succeed in combat quests but excel in stealth.
 */
public class Hobbit extends Character {

    private static final Random RANDOM = new Random();

    /**
     * Constructs a Hobbit with given properties.
     *
     * @param name            Name of the hobbit.
     * @param age             Age of the hobbit.
     * @param uniqueAttribute Unique attribute like favorite food.
     */
    public Hobbit(final String name, final int age, final String uniqueAttribute) {
        super(name, "Hobbit", age, uniqueAttribute);
    }

    /**
     * Hobbits undertake quests with lower success rate for battles.
     *
     * @param quest Quest to undertake.
     * @return true if succeeded, false otherwise.
     */
    @Override
    public boolean undertakeQuest(final Quest quest) {
        int baseSuccess = quest.getDifficulty() * 10;
        if ("Battle".equals(quest.getType())) {
            baseSuccess -= 30; // Hobbits are not strong fighters.
        }
        int roll = RANDOM.nextInt(100);
        return roll < baseSuccess;
    }
}
