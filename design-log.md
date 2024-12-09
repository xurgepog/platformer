# [08-12-2024] Day 1: Initial Setup

- **Project Setup**: Initialized a new Java project using Gradle.
    - Used the Gradle initialization wizard to create a basic structure.
    - Chose Gradle as the build tool for easy dependency management and flexibility.
    - Have used the Gradle once before during university studies
  
- **Game Concept**: Goal is to create platformer game with physics.
    - Main features planned include some amount **basic physics mechanics**.
    - Still deciding on the specifics of the platformer (e.g., character abilities, level design, etc.).
    - Long-term goal is to incorporate more complex physics (e.g., gravity, collisions) and projectiles (e.g., shooting or thrown objects).

- **Next Steps**:
    - Brainstorm the core mechanics of the platformer (e.g., character movement, environment, etc.).
    - Set up Processing framework

# [09-12-2024] Day 2: Further Planning and Setup

- **Game Concept**: Brainstorming Ideas.
    - Considering creating a rage game, focusing on a core mechanic that's simple to grasp but challenging to master.
    - The key question: How can I design a platformer where skill is crucial for success?
    - An idea: In order to beat a level you need to complete it faster than the current average time.
    - This mechanic would lead to increasingly faster times, adding a dynamic challenge that evolves with player progress.
    - Crucial that the game includes a movement system with a high skill ceiling that is rewarding to master and make being stuck on a level feel somewhat worthwhile.
    - To balance this, there needs to be some element of unpredictability, so levels don't become too frustrating or seemingly impossible.
    - A system could be implemented where players can't return to a level until their time drops below the new average. This ensures the average time remains reasonable.
    - The number of levels will require careful consideration: too many and it will feel impossible to finish, too little and everyone will beat it.
    - Once beaten all levels add name to list with cumalitive time, to rewards compeletion?
    - Kinda getting too specific now lol. Will further explore specifics later. More important to investigate potential core mechanics.

- **Project Setup**: Framework Initialization and Organization.
    - Set up the basic structure for the project using the Processing framework, including the *draw*, *setup*, and *settings* functions.
    - Organised Gradle folders and files so that Processing actually runs.

- **Next Steps**:
    - Consider possibility of posting game to steam. Do I need to set anything up now to avoid mess in the long run.
    - Continue to brainstorm the core mechanics or the game, specifically the movement / skill aspect.
    - Look into how to setup project so it works on multiple screen types (fps and dimensions).
    - Think of other important things to consider to ensure development goes smoothly.
    - Issue: Currently can't move window or hit X sometimes.