import java.util.Random;

/**
 * Class representing a Wizard character. Wizards use magic to influence quests.
 */
public class Wizard extends Character {

    private static final Random RANDOM = new Random();

    /**
     * Constructs a Wizard with given properties.
     *
     * @param name            Name of the wizard.
     * @param age             Age of the wizard.
     * @param uniqueAttribute Unique attribute like staff.
     */
    public Wizard(final String name, final int age, final String uniqueAttribute) {
        super(name, "Wizard", age, uniqueAttribute);
    }

    /**
     * Wizards can boost success by magic for any quest.
     *
     * @param quest Quest to undertake.
     * @return true if succeeded, false otherwise.
     */
    @Override
    public boolean undertakeQuest(final Quest quest) {
        int baseSuccess = quest.getDifficulty() * 20;
        if ("Rescue".equals(quest.getType())) {
            baseSuccess += 10; // Magical assistance.
        }
        int roll = RANDOM.nextInt(100);
        return roll < baseSuccess;
    }
}
