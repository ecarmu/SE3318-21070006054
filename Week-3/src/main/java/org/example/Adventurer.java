package org.example;

public class Adventurer extends Character implements Joinable{
    Race race;

    public Adventurer(String name, Race race) {
        this.name = name;
        this.race = race;
    }

    @Override
    public void joinQuest(Quest quest) {
        quest.adventurers.add(this);
    }
}
