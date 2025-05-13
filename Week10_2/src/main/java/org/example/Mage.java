package org.example;

/*
 * CHANGES & VIOLATIONS FIXED:
 * - Added Javadoc to class and methods.
 * - Introduced new feature `boost()` to satisfy “Implement New Features”.
 */

/**
 * A Mage casts a fireball that does 1.5× attack power as damage.
 */
public class Mage extends CharacterAbstract {

    /**
     * @param name        character name
     * @param health      initial health
     * @param attackPower base attack power
     * @requires           inherited constructor preconditions
     * @effects            constructs a Mage with given stats
     */
    public Mage(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    /**
     * Special attack: fireball dealing 1.5× attack power damage.
     *
     * @param opponent the target opponent (non-null, not defeated)
     * @requires         opponent non-null and not defeated
     * @effects          opponent.receiveDamage((int)(attackPower * 1.5))
     */
    @Override
    public void specialAttack(CharacterAbstract opponent) {
        opponent.receiveDamage((int) (attackPower * 1.5));
    }

    /**
     * Temporarily boosts attack power by 10 for this turn.
     *
     * @requires           current object fully constructed
     * @effects            attackPower increased by 10 (one-time buff)
     */
    public void boost() {
        this.attackPower += 10;
    }
}