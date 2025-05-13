package org.example;


import java.util.Objects;

/*
 * CHANGES & VIOLATIONS FIXED:
 * - Renamed from `Character` → `CharacterAbstract` to satisfy the “Abstract” suffix rule (TypeName).
 * - Added Javadoc on class and all public methods (JavadocType, JavadocMethod).
 * - Broke up multi-statement lines, fixed whitespace (WhitespaceAfter, WhitespaceAround).
 * - Enforced null/blank checks in constructor (ParameterName, IllegalArgumentException).
 * - Removed any underscores in method names (MethodName).
 */

/**
 * Abstract base class for all characters in the battle game.
 */
public abstract class CharacterAbstract {
    /** The character's name (non-null, non-empty). */
    protected final String name;
    /** Current health points (≥ 0). */
    protected int health;
    /** Base attack power (≥ 0). */
    protected int attackPower;

    /**
     * @param name         character name
     * @param health       initial health points
     * @param attackPower  base attack power
     * @requires           name non-null, non-blank; health ≥ 0; attackPower ≥ 0
     * @effects            initializes name, health, and attackPower fields
     * @throws NullPointerException     if name is null
     * @throws IllegalArgumentException if name is blank or health/attackPower < 0
     */
    public CharacterAbstract(String name, int health, int attackPower) {
        this.name = Objects.requireNonNull(name, "name must not be null");
        if (name.isBlank()) {
            throw new IllegalArgumentException("name must not be blank");
        }
        if (health < 0 || attackPower < 0) {
            throw new IllegalArgumentException("health and attackPower must be ≥ 0");
        }
        this.health = health;
        this.attackPower = attackPower;
    }

    /**
     * @return the character's name
     */
    public String getName() {
        return name;
    }

    /**
     * Inflicts damage on this character by subtracting from health.
     *
     * @param damage damage to apply (must be ≥ 0)
     * @requires      damage ≥ 0
     * @effects       health is reduced by damage, but not below zero
     * @throws IllegalArgumentException if damage < 0
     */
    public void receiveDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("damage must be non-negative");
        }
        health = Math.max(0, health - damage);
    }

    /**
     * @return true if health ≤ 0, false otherwise
     */
    public boolean isDefeated() {
        return health <= 0;
    }

    /**
     * Executes this character's special attack against an opponent.
     *
     * @param opponent the target of the special attack (non-null, not defeated)
     * @requires         opponent non-null and not defeated
     * @effects          opponent.receiveDamage(...) according to subclass logic
     * @throws NullPointerException if opponent is null
     */
    public abstract void specialAttack(CharacterAbstract opponent);

    /**
     * @return the current health value
     */
    public int getHealth() {
        return health;
    }

    /**
     * @return the base attack power
     */
    public int getAttackPower() {
        return attackPower;
    }
}