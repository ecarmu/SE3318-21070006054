package org.example;

import java.util.ArrayList;

public class Quest  {
    String name;

    public Quest(String name, Difficulty difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    public Quest(Quest quest){
        quest.mentor = mentor;
        quest.name = name;
        quest.difficulty = difficulty;
    }

    Difficulty difficulty;
    Mentor mentor;
    ArrayList<Adventurer> adventurers = new ArrayList<>();

    public void listAdventurers(){
        System.out.print("\nHere are adventurers:");
        for(Adventurer adventurer : adventurers){
            System.out.print(" " + adventurer.name);
        }
    }

    public void assignMentor(Mentor mentor){
        this.mentor = mentor;
    }
}
