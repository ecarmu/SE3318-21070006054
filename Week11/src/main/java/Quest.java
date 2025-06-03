import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base class representing a quest in Middle-Earth.
 */
public abstract class Quest {

    /** Type of the quest (e.g., Rescue, Battle). */
    private String type;

    /** Difficulty level (1 to 10). */
    private int difficulty;

    /** List of participating characters' names. */
    private List<String> participants;

    /**
     * Constructs a Quest with given type and difficulty.
     *
     * @param type       Type of the quest.
     * @param difficulty Difficulty level.
     */
    public Quest(final String type, final int difficulty) {
        this.type = type;
        this.difficulty = difficulty;
        this.participants = new ArrayList<String>();
    }

    /**
     * Gets the type of the quest.
     *
     * @return type of the quest.
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the difficulty of the quest.
     *
     * @return difficulty level.
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * Adds a participant to the quest.
     *
     * @param characterName Name of character.
     */
    public void addParticipant(final String characterName) {
        participants.add(characterName);
    }

    /**
     * Gets the list of participants.
     *
     * @return list of participant names.
     */
    public List<String> getParticipants() {
        return participants;
    }

    /**
     * Abstract method to determine quest success based on character.
     *
     * @param character Character undertaking quest.
     * @return true if quest succeeded, false otherwise.
     */
    public abstract boolean attempt(final Character character);

    /**
     * Executes the quest for a given character, adds to participants.
     *
     * @param character Character undertaking the quest.
     * @return true if succeeded, false otherwise.
     */
    public boolean execute(final Character character) {
        addParticipant(character.getName());
        return attempt(character);
    }
}
