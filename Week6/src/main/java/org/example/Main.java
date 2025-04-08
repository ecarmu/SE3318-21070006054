package org.example;

public class Main {

    public static void main(String[] args) {

        Hero hero = new Hero("Aragon", 10);

        Enemy enemy = new Enemy("Orc Lord", 8);



        hero.speak();

        enemy.speak();



        QuestBoard board = new QuestBoard();

        board.assignQuest(hero, "Defeat the Orc Lord");



        BattleManager bm = new BattleManager();

        bm.battle(hero, enemy);

    }

}