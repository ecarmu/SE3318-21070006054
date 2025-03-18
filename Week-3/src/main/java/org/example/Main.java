package org.example;

public class Main {
    public static void main(String[] args) {
        Adventurer a1 = new Adventurer("Frodo Baggins", Race.Dwarf);
        Adventurer a2 = new Adventurer("Legolas", Race.Elf);
        Adventurer a3 = new Adventurer("Aragorn", Race.Man);
        Adventurer a4 = new Adventurer("Gimli", Race.Hobbit);

        Quest q1 = new Quest("Destroy the One Ring", Difficulty.MEDIUM);
        Quest q2 = new Quest("”Defend Helm’s Deep", Difficulty.HARD);

        Mentor m1 = new Mentor("Gandalf", "the Grey");

        q1.assignMentor(m1);
        q2.assignMentor(m1);

        a1.joinQuest(q1);
        a1.joinQuest(q2);

        a2.joinQuest(q1);

        a3.joinQuest(q2);

        a4.joinQuest(q1);
        a4.joinQuest(q2);

        q1.listAdventurers();
        q2.listAdventurers();


    }
}
