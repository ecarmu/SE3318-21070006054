# Game Character System



## Overview



This project models a simple game system involving heroes, enemies, quests, and battles.



### Classes and Interface



- **Character (abstract)**: Base class with `name`, `level`, and an abstract `speak()` method.

- **Hero (extends Character, implements Questable)**: Represents a playable character who can accept quests.

- **Enemy (extends Character)**: Represents a game enemy.

- **Questable (interface)**: Defines method `acceptQuest(String questName)`.

- **QuestBoard**: Assigns quests to any character that implements `Questable`.

- **BattleManager**: Simulates a battle between a Hero and an Enemy.
