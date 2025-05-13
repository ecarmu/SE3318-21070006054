import static org.junit.jupiter.api.Assertions.*;

import org.example.Archer;
import org.example.Game;
import org.example.Mage;
import org.example.Warrior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * SMOKE TESTS COVER:
 * - specialAttack behavior
 * - defend() for Archer and Warrior
 * - boost() for Mage
 * - full game flow
 */

/**
 * Smoke tests for Character-related functionality.
 */
public class SmokeTest {
    private Archer archer;
    private Mage mage;
    private Warrior warrior;

    @BeforeEach
    public void setUp() {
        archer  = new Archer("Legolas", 100, 10);
        mage    = new Mage("Gandalf",  80,  12);
        warrior = new Warrior("Conan", 120, 15);
    }

    /**
     * @requires   archer and warrior fully constructed
     * @effects    tests that Archer.specialAttack deals 2× attackPower damage
     */
    @Test
    public void testArcherSpecialAttack() {
        warrior.receiveDamage(0); // reset if needed
        archer.specialAttack(warrior);
        assertEquals(120 - 20, warrior.getHealth());
    }

    /**
     * @requires   warrior and archer fully constructed
     * @effects    tests that Archer.defend halves incoming damage
     */
    @Test
    public void testArcherDefend() {
        archer.defend(30);
        assertEquals(100 - 15, archer.getHealth());
    }

    /**
     * @requires   mage and warrior fully constructed
     * @effects    tests that Mage.specialAttack deals 1.5× attackPower damage
     */
    @Test
    public void testMageSpecialAttack() {
        int before = warrior.getHealth();
        mage.specialAttack(warrior);
        assertEquals(before - (int)(12 * 1.5), warrior.getHealth());
    }

    /**
     * @requires   mage fully constructed
     * @effects    tests that Mage.boost does not throw and increases attackPower by 10
     */
    @Test
    public void testMageBoost() {
        int before = mage.getAttackPower();
        mage.boost();
        assertEquals(before + 10, mage.getAttackPower());
    }

    /**
     * @requires   warrior fully constructed
     * @effects    tests that Warrior.defend blocks all damage (health unchanged)
     */
    @Test
    public void testWarriorDefend() {
        warrior.defend();
        warrior.receiveDamage(50);
        assertEquals(120, warrior.getHealth());
    }

    /**
     * @requires   all characters fully constructed
     * @effects    tests a full round-robin: battle to a winner
     */
    @Test
    public void testGameFlow() {
        Game game = new Game(archer, mage);
        while (game.getWinner() == null) {
            game.round();
        }
        assertNotNull(game.getWinner());
    }
}