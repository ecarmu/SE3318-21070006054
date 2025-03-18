package org.example;

public class Mentor extends Character{
    String title;

    public Mentor(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public void guide(Adventurer adventurer){
        System.out.println(adventurer.name + "... başarabilirsin!!");
    }
}
