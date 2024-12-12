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

# [10-12-2024] Day 3: Brainstorming mechanics

- **Project Setup**: 
    - Explored the Steamworks SDK, but it's not necessary for now. 
    - Played around with obtaining the user's screen size and scaling the window accordingly. 
    - I’ll investigate this further once objects and movement are in place to evaluate the effects of scaling.

- **Game Concept**: Further brainstorming
    - Considering making the game centered around traversing a tower.
    - Each floor would represent a percentile rank. For example, to clear the first floor, the player must be in the top 90%.
    - Potentially include a system where players can buy power-ups, making the game easier for them but harder for others due to lowering the average time.
    - With this decreasing percentile system, important that people do not get hardstuck.
    - Possibly allow players to "rebirth" for money, making the next run easier but preventing them from increasing their average completion time.
    - Maybe lean towards strategy, that is to beat a floor you need to manage good economy, and only take the abilities needed to continue, along with a lot of options such as power ups or weapons. 
    - This provides a high skill ceiling, but also some level or RNG. 
    - An example of something similar in action is the game *TFT*
    - Considering the option for players to collaborate in some way. I’m also toying with the idea of starting with a top-down view for the first stage, then transitioning into a platformer as the game progresses. Though, I might be overcomplicating things—just exploring ideas for now.
    - Like the idea of augments, some to encourage team work where as others aim to destroy it.
    - I think I am going overboard. This is my first project, keep it simple.
    - Focus on creating a platformer with the average time mechanic, where levels are fixed and there’s no randomness. Potentially convey some deeper message. 
    - I may dial it back and focus on the core idea: beating the average time on each level.
    - Include different difficulty levels: Easy (allows a slower completion time), Medium (beat it once), and Hard (requires revisiting levels to improve your average time).

# [11-12-2024] Day 4: Honing Idea

- **Project Setup**:
    - Began considering possibility of how to keep the main App.java file clean, didn't make much progress.

- **Game Concept**:
    - Since this is my first side project, I don't want to take too long, afterall March is intership time and need to make resume look good lol.
    - Will keep ideas from here in mind for later however, so don't go stealing them if you see this.
    - Want a simple goal, that can later be returned to and expanded into a full release if I feel like it.
    - I like the idea of a *Jump King* style rage game. Simple mechanic, expandable (i.e. encourages good OOP principles), and wouldn't take too long.
    - Played *The End Is Nigh* ages ago, I remember it having simple movement. See how it makes something simple fun.
    - Seems to just be really difficult, but consistent and easy retry attempts.
    - Perhps try thinking of ways to limit player. For example, can't stop running. Similar to idea of having to beat certain time.

# [13-12-2024] Day 5: Finalising Idea

- **Game Concept**:
    - Taking too long to get a polished idea for a side project, certainly over thinking it.
    - From research: *"As long as you don't use graphics, characters, story, music, sound effects, etc. from other games, you can even sell it. Game mechanics can't be copyrighted."*
    - Further research seems to back this app.
    - With this in mind, I might try and recreate the *Celeste* mechanics. There is a lot of interesting physics to be explored. 

- **Planning Documentation**:
    - Since I am new to creating well documented solo projects, will plan how to plan here.
    - Images that is part of my planning (e.g. UML diagrams, physics calculations on paper) will be placed in a folder and referenced to in this log. [View images folder here](images/).
    - I will also continue improving previous logs visually as I learn more about the Markdown Language. This is why previous sections my have changes on later days.
    - Important to break down idea into smaller parts in order to effectively tackle with OOP.
    - Since the game is very movement based will start by breaking that down.
    - To ensure planning for each mechanic can be revised and expanded over multiple days, will do so in a seperate directory of Markdown files and directories. [View mechanics folder here](../mechanics/).
    - I'm planning to break down each mechanic three times. The first will be a directory (e.g. movement), then the next a file (e.g. basics), the the final the contents of that file (e.g. gravity, jumping)
    - Each file will include: The mechanics required to complete the mechanic, a breakdown how to implement each (e.g. jumping requires gravity and stopping on floor collision), the psuedocode for implementation.
    - Keywords for breakdown: trigger (e.g. pressing spacebar), behaviour (what is actually occuring, e.g. applied velocity upwards), constraints (whenever mechanic is not allowed), interactions (if mechanic interacts with another).
    - Will most likely have to update mechanic planning format later, but for now will see how this suffices.

- **Mechanics Development**: 
    - Began planning the basic movement mechanics. That is left and right movement, jumping, gravity.