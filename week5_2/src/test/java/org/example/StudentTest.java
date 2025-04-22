package org.example;

import org.example.Spell;
import org.example.Student;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student("Harry", "Gryffindor", 2);
    }

    @Test
    void learnValidSpell() {
        Spell spell = new Spell("Expelliarmus");
        assertTrue(student.learnSpell(spell));
        assertTrue(student.knowsSpell(spell));
    }

    @Test
    void learnNullSpellShouldFail() {
        assertThrows(IllegalArgumentException.class, () -> student.learnSpell(null));
    }

    @Test
    void learnDuplicateSpellShouldNotDuplicate() {
        Spell spell = new Spell("Lumos");
        assertTrue(student.learnSpell(spell));
        assertFalse(student.learnSpell(spell));
    }

    @Test
    void knowsSpellCorrectness() {
        Spell spell = new Spell("Alohomora");
        Spell spell2 = new Spell("Avada Kedavra");
        student.learnSpell(spell);
        assertTrue(student.knowsSpell(spell));
        assertFalse(student.knowsSpell(spell2));
    }
}