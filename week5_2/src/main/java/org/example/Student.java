package org.example;

import java.util.ArrayList;
import java.util.List;

public class Student {
    public Student(String name, String house, int year) {
        this.name = name;
        this.house = house;
        this.year = year;
    }

    String name;
    String house;
    int year;
    List<Spell> spellsLearned = new ArrayList<>();

    /**
     * @param spell spell to learn
     * @return true if spell is learnt false otherwise
     * requires: spell != null && !knowsSpell(spell)
     * effects: Adds spell to spellsLearned if it is valid
     */

    public boolean learnSpell(Spell spell){
        if(spell != null && !knowsSpell(spell)){
            spellsLearned.add(spell);
            System.out.println("Spell learnt!");
            return true;
        }
        System.out.println("Spell noot learnt!");

        return false;
    }

    /**
     * @param spell spell to learn
     * @return true if spell is known, false otherwise
     * requires spell != null
     * effects returns spellsLearned contains spell or not
     */
    public boolean knowsSpell(Spell spell){
        return spellsLearned.contains(spell);
    }


}
