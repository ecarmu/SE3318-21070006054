package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Ali", "Balçova", 2003);
        Student s2 = new Student("Ahmet", "Bornova", 2006);
        Student s3 = new Student("Veli", "Konak", 2000);

        Spell sp1 = new Spell("Yıldırım");
        Spell sp2 = new Spell("Yılışma");
        Spell sp3 = new Spell("Sertlik");

        s1.learnSpell(sp1);
        s1.learnSpell(sp2);

        s2.learnSpell(sp1);
        s2.learnSpell(sp3);

        s3.learnSpell(sp2);
        s1.learnSpell(sp3);

        List<Spell> spells = new ArrayList<>();
        spells.add(sp1);
        spells.add(sp2);
        spells.add(sp3);

        Spellbook spellbook = new Spellbook(spells);

        spellbook.allSpells = spellbook.getSpellsByPrefix("Yıl");

        Exam exam = new Exam(spells);
        if(exam.pass(s1))
            System.out.println(s1.name + " had passed exam!!!");
        else
            System.out.println(s1.name + " had failed exam!!!");

    }
}