package org.example;

public class BattleManager {

    public void battle(Hero hero, Enemy enemy) {

        System.out.println("Battle begins between " + hero.name + " and " + enemy.name + "!");



        if (hero.level >= enemy.level) {

            System.out.println(hero.name + " wins the battle!");

        } else {

            System.out.println(enemy.name + " wins the battle!");

        }

    }

}

