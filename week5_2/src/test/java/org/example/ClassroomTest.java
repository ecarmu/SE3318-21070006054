package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassroomTest {

    private Classroom classroom;

    @BeforeEach
    void setUp() {
        classroom = new Classroom();
    }

    @Test
    void addValidStudent() {
        Student student = new Student("Hermione", "Gryffindor", 3);
        assertTrue(classroom.addStudent(student));
    }

    @Test
    void addNullStudentShouldFail() {
        assertThrows(IllegalArgumentException.class, () -> classroom.addStudent(null));
    }

    @Test
    void findStudent() {
        Student student = new Student("Ron", "Gryffindor", 3);
        classroom.addStudent(student);
        assertEquals(student, classroom.findStudent(student));
    }

    @Test
    void findStudentBySpell() {
        Student student = new Student("Draco", "Slytherin", 2);
        Spell spell = new Spell("Crucio");
        student.learnSpell(spell);
        classroom.addStudent(student);
        assertEquals(student, classroom.findStudentBySpell(spell));
    }

    @Test
    void getStudentsByHouseSorting() {
        Student student1 = new Student("Zach", "Hufflepuff", 3);
        Student student2 = new Student("Anna", "Hufflepuff", 3);
        classroom.addStudent(student1);
        classroom.addStudent(student2);
        List<Student> list = classroom.getStudentsByHouse("Hufflepuff");
        assertEquals("Anna", list.get(0).name);
        assertEquals("Zach", list.get(1).name);
    }
}