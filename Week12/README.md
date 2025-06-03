# Loop Control Maven Project

## Overview

This project demonstrates proper and improper use of loops in Java, enforcing Checkstyle rules related to:
- **VariableDeclarationUsageDistance**
- **EmptyBlock**
- **ModifiedControlVariable**

### Structure

- `src/main/java`:
    - `LoopControl.java`: Methods showing correct and incorrect loop practices.
    - `ExampleUsage.java`: Practical examples using loops on data structures.
    - `App.java`: Main class that runs and demonstrates all methods.
- `src/test/java`:
    - `SmokeTest.java`: JUnit tests verifying core functionality.
- `pom.xml`: Maven configuration with Checkstyle plugin enabled.
- `checkstyle.xml`: Checkstyle configuration defining rules for loops and basic style.
- `README.md`: This file.

## How to Build and Test

1. Run Checkstyle (should pass with no violations except the intentional ModifiedControlVariable violation in `modifyIndexIncorrectly` if `failOnViolation` is enabled):
   ```bash
   mvn checkstyle:check
