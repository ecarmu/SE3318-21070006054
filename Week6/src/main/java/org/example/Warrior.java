package org.example;

public class Warrior extends Hero {



    public Warrior(String name, int level) {

        super(name, level);

    }



    @Override

    public void speak() {

        System.out.println("I am Warrior " + name + ", ready for battle!");

    }



    public void attack() {

        System.out.println(name + " swings their sword mightily!");

    }

}

