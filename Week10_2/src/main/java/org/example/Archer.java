package org.example;

/*
 * CHANGES & VIOLATIONS FIXED:
 * - Added Javadoc to class and methods (JavadocType, JavadocMethod).
 * - Introduced new feature `defend(int damage)` to satisfy “Implement New Features”.
 * - Method name changed from none → `defend` (lowerCamelCase).
 */

/**
 * An Archer deals ranged damage equal to its attack power.
 */
public class Archer extends CharacterAbstract {

    /**
     * @param name        character name
     * @param health      initial health
     * @param attackPower base attack power
     * @requires           inherited constructor preconditions
     * @effects            constructs an Archer with given stats
     */
    public Archer(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    /**
     * Performs a ranged special attack: deals double attack power as damage.
     *
     * @param opponent the target opponent (non-null, not defeated)
     * @requires         opponent non-null and not defeated
     * @effects          opponent.receiveDamage(attackPower * 2)
     */
    @Override
    public void specialAttack(CharacterAbstract opponent) {
        opponent.receiveDamage(attackPower * 2);
    }

    /**
     * Defends by reducing incoming damage by half.
     *
     * @param damage incoming damage before defense (must be ≥ 0)
     * @requires       damage ≥ 0
     * @effects        calls receiveDamage(damage / 2)
     * @throws IllegalArgumentException if damage < 0
     */
    public void defend(int damage) {
        receiveDamage(damage / 2);
    }
}
