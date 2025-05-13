package org.example;

public class Warrior extends CharacterAbstract {

    private boolean blockNext = false;

    /**
     * @param name        character name
     * @param health      initial health
     * @param attackPower base attack power
     * @requires           inherited constructor preconditions
     * @effects            constructs a Warrior with given stats
     */
    public Warrior(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    /**
     * Special attack: powerful slash dealing attackPower + 5 damage.
     *
     * @param opponent the target opponent (non-null, not defeated)
     * @requires         opponent non-null and not defeated
     * @effects          opponent.receiveDamage(attackPower + 5)
     */
    @Override
    public void specialAttack(CharacterAbstract opponent) {
        opponent.receiveDamage(attackPower + 5);
    }

    /**
     * Defends by blocking full damage once (no health loss).
     *
     * @requires           object fully constructed
     * @effects            next incoming attack is blocked (stub implementation)
     */
    /**
     * Defends by blocking the next incoming attack entirely.
     *
     * @requires           this object fully constructed
     * @effects            next call to receiveDamage(int) will be ignored
     */
    public void defend() {
        this.blockNext = true;
    }

    /**
     * Overrides base receiveDamage to honor the one-time block.
     *
     * @param damage incoming damage (≥ 0)
     * @requires      damage ≥ 0
     * @effects       if blockNext is true, damage is ignored and blockNext reset;
     *                otherwise, health reduced by damage
     * @throws IllegalArgumentException if damage < 0
     */
    @Override
    public void receiveDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("damage must be non-negative");
        }
        if (blockNext) {
            blockNext = false;  // consume the block
            return;             // no health lost
        }
        super.receiveDamage(damage);
    }
}
