package org.example;

public class Main {

    public static void main(String[] args) {

        Mage mage = new Mage("Gandalf", 12);

        Warrior warrior = new Warrior("Conan", 9);

        Enemy enemy = new Enemy("Goblin King", 10);



        mage.speak();

        warrior.speak();

        enemy.speak();



        mage.castSpell("Fireball");

        warrior.attack();



        QuestBoard board = new QuestBoard();

        board.assignQuest(mage, "Rescue the villagers");

        board.assignQuest(warrior, "Defend the kingdom");



        BattleManager bm = new BattleManager();

        bm.battle(mage, enemy);    // Mage vs Enemy

        bm.battle(warrior, enemy); // Warrior vs Enemy

    }

}


