package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExamTest {

    private Exam exam;

    @BeforeEach
    void setUp() {
        List<Spell> spells = new ArrayList<>();
        spells.add(new Spell("Lumos"));
        spells.add(new Spell("Nox"));
        exam = new Exam(spells);
    }

    @Test
    void passFalseOtherwise() {
        Student student = new Student("Ali", "Balova", 2);
        student.learnSpell(new Spell("Lumos"));
        assertFalse(exam.pass(student));
    }
    @Test
    void passTrueIfAllSpellsKnown() {
        Student student = new Student("Ali", "Balova", 2);
        student.learnSpell(new Spell("Lumos"));
        student.learnSpell(new Spell("Nox"));
        assertTrue(exam.pass(student));
    }


    @Test
    void passFails() {
        Student student = null;
        //assertThrows(IllegalArgumentException.class, exam.pass(student));
    }

    @Test
    void evaluate() {
    }
}