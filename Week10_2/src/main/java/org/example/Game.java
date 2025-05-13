package org.example;

import java.util.Objects;

/*
 * CHANGES & VIOLATIONS FIXED:
 * - Added Javadoc to class and methods.
 * - Ensured no Checkstyle violations in formatting or naming.
 */

/**
 * Orchestrates a turn-based battle between two characters.
 */
public class Game {

    private final CharacterAbstract playerOne;
    private final CharacterAbstract playerTwo;

    /**
     * @param playerOne first combatant (non-null)
     * @param playerTwo second combatant (non-null)
     * @requires         neither player is null
     * @throws NullPointerException if either is null
     * @effects           initializes the game with two players
     */
    public Game(CharacterAbstract playerOne, CharacterAbstract playerTwo) {
        this.playerOne = Objects.requireNonNull(playerOne, "playerOne");
        this.playerTwo = Objects.requireNonNull(playerTwo, "playerTwo");
    }

    /**
     * Runs one round: each specialAttacks the other.
     *
     * @requires           both players non-defeated
     * @effects            playerOne.specialAttack(playerTwo);
     *                    if playerTwo survives, playerTwo.specialAttack(playerOne);
     */
    public void round() {
        playerOne.specialAttack(playerTwo);
        if (!playerTwo.isDefeated()) {
            playerTwo.specialAttack(playerOne);
        }
    }

    /**
     * @return the winner (non-null) if one is defeated, or null if both still standing
     */
    public CharacterAbstract getWinner() {
        if (playerOne.isDefeated() && !playerTwo.isDefeated()) {
            return playerTwo;
        } else if (playerTwo.isDefeated() && !playerOne.isDefeated()) {
            return playerOne;
        }
        return null;
    }
}
