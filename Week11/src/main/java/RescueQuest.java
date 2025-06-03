/**
 * Class representing a Rescue quest.
 */
public class RescueQuest extends Quest {

    /**
     * Constructs a RescueQuest with given difficulty.
     *
     * @param difficulty Difficulty level of rescue.
     */
    public RescueQuest(final int difficulty) {
        super("Rescue", difficulty);
    }

    /**
     * Rescue quests succeed based on character attributes.
     *
     * @param character Character undertaking the quest.
     * @return true if succeeded, false otherwise.
     */
    @Override
    public boolean attempt(final Character character) {
        // Delegate to character's undertake logic
        return character.undertakeQuest(this);
    }
}
