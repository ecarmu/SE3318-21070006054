/**
 * Abstract base class representing a character in the Lord of the Rings universe.
 * Each character has a name, race, age, and a unique attribute.
 */
public abstract class Character {

    /** Name of the character. */
    private String name;

    /** Race of the character (e.g., Hobbit, Elf, Human). */
    private String race;

    /** Age of the character in years. */
    private int age;

    /** Unique attribute (e.g., weapon or title). */
    private String uniqueAttribute;

    /**
     * Constructs a Character with given properties.
     *
     * @param name            Name of the character.
     * @param race            Race of the character.
     * @param age             Age of the character.
     * @param uniqueAttribute Unique attribute like weapon or title.
     */
    public Character(final String name, final String race, final int age, final String uniqueAttribute) {
        this.name = name;
        this.race = race;
        this.age = age;
        this.uniqueAttribute = uniqueAttribute;
    }

    /**
     * Gets the name of the character.
     *
     * @return name of the character.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the race of the character.
     *
     * @return race of the character.
     */
    public String getRace() {
        return race;
    }

    /**
     * Gets the age of the character.
     *
     * @return age of the character.
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets the unique attribute of the character.
     *
     * @return unique attribute of the character.
     */
    public String getUniqueAttribute() {
        return uniqueAttribute;
    }

    /**
     * Characters can undertake quests. Implementation depends on subclass.
     *
     * @param quest Quest to undertake.
     * @return true if quest succeeded, false otherwise.
     */
    public abstract boolean undertakeQuest(final Quest quest);
}
