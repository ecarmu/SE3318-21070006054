# The Lord of the Rings Maven Project

## Overview

This project simulates basic operations within the Lord of the Rings universe, including characters, locations, and quests. It enforces coding standards via Checkstyle.

## Structure

- `src/main/java`: All Java classes under the default package.
    - `Character.java`
    - `Hobbit.java`
    - `Elf.java`
    - `Wizard.java`
    - `Location.java`
    - `MiddleEarthMap.java`
    - `Quest.java`
    - `RescueQuest.java`
    - `BattleQuest.java`
- `src/test/java`: Smoke tests for basic functionality.
    - `SmokeTest.java`
- `pom.xml`: Maven configuration with Checkstyle plugin.
- `checkstyle.xml`: Checkstyle configuration enforcing Javadoc, naming conventions, indentation, and other rules.

## How to Build and Test

1. Run Checkstyle:
   ```bash
   mvn checkstyle:check
