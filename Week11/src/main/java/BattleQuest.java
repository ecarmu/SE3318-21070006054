/**
 * Class representing a Battle quest.
 */
public class BattleQuest extends Quest {

    /**
     * Constructs a BattleQuest with given difficulty.
     *
     * @param difficulty Difficulty level of battle.
     */
    public BattleQuest(final int difficulty) {
        super("Battle", difficulty);
    }

    /**
     * Battle quests succeed based on character's combat ability.
     *
     * @param character Character undertaking the quest.
     * @return true if succeeded, false otherwise.
     */
    @Override
    public boolean attempt(final Character character) {
        return character.undertakeQuest(this);
    }
}
