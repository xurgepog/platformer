# Platformer Game Framework

## Overview
This project is the foundational framework for a platformer game, designed with expandability and flexibility in mind. The primary goal is to establish a solid base for a platformer, allowing for smooth player movement, interactions with the environment, and the easy addition of new mechanics in the future.

While the game is still in the early stages, the focus is on building a modular system that will later incorporate more advanced features such as enemy mechanics, power-ups, and dynamic world interactions. The goal is to create a platformer that can evolve and grow over time.

## How To Use Current Version

Before running the project, make sure you have the following dependencies installed:
1. Java Development Kit (JDK) – Ensure you have JDK 8 or later installed. You can verify this by running:
```bash
java -version
```
2. Gradle – You need Gradle installed to build and run the project. If you don't have it installed, follow the instructions on the [Gradle installation page](https://gradle.org/install/).

Once the dependencies are in place, follow these steps:
1. After pulling the repository, navigate to the `app` directory.
2. Run the following command in the terminal:
``` bash
gradle run
```

This will start the application! If you find the window too big or small locate the `Game.java` file and modify the `scaleFactor` variable within `settings()` to suit your needs.

## More Depth
This framework is built to create a platformer game that will feature the following core mechanics:
* **Player Movement:** Implementing smooth and responsive player movement, including features like dashing and basic jump mechanics.
* **Tile System:** Establishing an initial tile system for platform interaction. This system will eventually support various tile types (e.g., platforms, hazards, etc.) and allow for dynamic interactions with the player.
* **Expandable Setup:** The project is structured to easily add new mechanics, such as power-ups, enemies, or environmental interactions, without requiring major overhauls to the existing codebase.

The current version includes basic player movement and a simple tile system, but future updates will introduce additional platforming elements like enemies, collectible items, and more intricate level design.

## Future Plans
The project is planned to evolve and expand over time with the addition of:
* **Complex Player Mechanics:** Features such as double-jumping, wall jumping, dashing, and other platforming elements will be added to enhance the gameplay.
* **Interactive Tiles:** More advanced tile interactions will be introduced, such as moving platforms, hazards, or tiles that change based on player actions.
* **Enemies and Obstacles:** The framework will eventually support enemy AI, platforming challenges, and dynamic environmental obstacles.
* **Level Design:** Support for building more complex levels with varied difficulty, integrating all the mechanics into cohesive, playable stages.

This system is being designed to allow for these features to be seamlessly integrated as the game grows, ensuring the project remains flexible and easy to modify.