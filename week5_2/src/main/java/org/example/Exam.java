package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Exam {
    List<Spell> spells = new ArrayList<>();

    public Exam(List<Spell> spells) {
        this.spells = spells;
    }

    /**
     * @param student student to enter the exam
     * @return true if student passes, false if student fails
     * requires: student != null
     * effects: student ends up passing or failing the exam
     */
    public boolean pass(Student student){
        if(student != null)
            return new HashSet<>(spells).equals(new HashSet<>(student.spellsLearned));
        return false;
    }

    /**
     * @param student student to enter the exam
     * @return true if student eligible to pass, false if student isnt eligible to pass
     * requires: student != null
     * effects: student ends up being eligible to pass or fail an exam
     */
    public boolean evaluate(Student student){
        return pass(student);
    }
}
