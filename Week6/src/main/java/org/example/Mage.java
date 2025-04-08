package org.example;

public class Mage extends Hero {



    public Mage(String name, int level) {

        super(name, level);

    }



    @Override

    public void speak() {

        System.out.println("I am Mage " + name + ", master of arcane arts!");

    }



    public void castSpell(String spellName) {

        System.out.println(name + " casts " + spellName + "!");

    }

}