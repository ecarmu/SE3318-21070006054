package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class DuelTest {

    private Student harry;
    private Student draco;
    private Spell spell;
    private ByteArrayOutputStream output;

    @BeforeEach
    void setUp() {
        harry = new Student("Harry", "Gryffindor", 2);
        draco = new Student("Draco", "Slytherin", 3);
        spell = new Spell("Expelliarmus");
    }

    @Test
    void startNoOneKnows() {
        Duel duel = new Duel();
        duel.start(harry, draco, spell);
        assertTrue(Objects.equals(output.toString(), "draw"));
    }

    @Test
    void startOnlyOneKnows() {
        Duel duel = new Duel();
        harry.learnSpell(spell);
        duel.start(harry, draco, spell);
        assertTrue(Objects.equals(output.toString(), " is winner!"));
    }

    @Test
    void startBothKnows() {
        Duel duel = new Duel();
        harry.learnSpell(spell);
        draco.learnSpell(spell);
        duel.start(harry, draco, spell);
        assertTrue(Objects.equals(output.toString(), " is winner!"));
    }

    @Test
    void duelWithNullsShouldFailSafely() {
        Spell spell = new Spell("Expelliarmus");
        Duel duel = new Duel();

        assertThrows(IllegalArgumentException.class, () -> duel.start(null,draco, spell));
        assertThrows(IllegalArgumentException.class, () -> duel.start(harry,null, spell));
        assertThrows(IllegalArgumentException.class, () -> duel.start(harry,draco, null));
    }
}