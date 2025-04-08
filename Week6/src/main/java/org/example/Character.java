package org.example;

public abstract class Character {

    protected String name;

    protected int level;



    public Character(String name, int level) {

        this.name = name;

        this.level = level;

    }



    public abstract void speak();

}

