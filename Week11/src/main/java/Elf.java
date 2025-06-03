import java.util.Random;

/**
 * Class representing an Elf character. Elves excel at ranged combat and magic.
 */
public class Elf extends Character {

    private static final Random RANDOM = new Random();

    /**
     * Constructs an Elf with given properties.
     *
     * @param name            Name of the elf.
     * @param age             Age of the elf.
     * @param uniqueAttribute Unique attribute like bow quality.
     */
    public Elf(final String name, final int age, final String uniqueAttribute) {
        super(name, "Elf", age, uniqueAttribute);
    }

    /**
     * Elves have high success in both battle and rescue quests.
     *
     * @param quest Quest to undertake.
     * @return true if succeeded, false otherwise.
     */
    @Override
    public boolean undertakeQuest(final Quest quest) {
        int baseSuccess = quest.getDifficulty() * 15;
        int roll = RANDOM.nextInt(100);
        return roll < baseSuccess;
    }
}
