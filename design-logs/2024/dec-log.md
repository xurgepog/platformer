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

# [16-12-2024] Day 6: Creating Framework
- **Framework Creation**:
    - Will begin to create the main framework whilst implementing the left and right movement.
    - Developed a *Player* class to handle the player's attributes and behavior.
    - Perhaps simplify both the *App* and *Player* classes through the implementation of *InputHandler* and *PhysicsHandler* classes.
        - The *InputHandler* will handle and allow for multiple key presses simlutaneously to be recognised.
        - The *PhysicsHandler* will use any object with physics' position and velocity to update it accordingly.
    - To ensure *PhysicsHandler* can update objects correctly, will develop a *GameObject* class that will define the necessary attributes.
    - Considering the addition of a *Renderer* class later, which will manage sprite loading and drawing all objects that need to be displayed on the screen.

- **Scaling**:
    - Thinking about making my game have pixel graphics.
    - Started looking into what this means for scaling.
    - Aparrently 640 x 360 is best for upsizing to suit common screen resolutions.
    - This is due to integer scaling rather than dynamic.
    - If a screen is not a multiple, add a border maybe so maintain a clear visual.

# [17-12-2024] Day 7: Refining Framework
- **Scaling**: Temporary Decisions
    - When fullscreen the game runs really choppy.
    - Since it is just a side project, the main goal should just be to create a functioning game.
    - Will code at double scale (i.e. 1280 x 720) and draw pixel art at 640 x 360.
    - This means I can later add the ability to change screen size with scaling, but for now will just leave scaleFactor equal to 2.
- **Physics**: Very Basic Implementation
    - Update *PhysicsHandler* to update the physics in a centralised manner.
    - Change *GameObject* class to *PhysicsObject*.
    - Noticing a rectange the same width of the screen will be over 50px longer, same with height. Hopefully this is a just *rect()* issue.
    - Added gravity through *PhysicsHandler*.
    - Made *PhysicsObject* an interface that forces setters and getters for position and velocity.
    - Now want to figure out a way to stop player movement when touching a wall or floor.
- **Config Setup**: Planning
    - For previous code, figured out what tile player was touching based on the level layout text file.
    - This was done in conjunction with a *config.json* file that defined which text file matched which level, along with other details for that level.
    - Will expand on this idea with:
        - *config.json*: points to other config files, and contains other misc.
        - *settings.json*: holds user settings.
        - *save.json*: contains user save data.
        - *levels.json*: level details.
    - Will use *Processing*'s in built JSON reader to get the information in code.
    - May end up needing more than one json file for the levels. For now one will do however.
    - To store these files will set up a *resources/* directory in *src/*. This will hold *config/*, *levels/*, and *assets/* directories.
    - Will create a *configManager* class to handle both the levels and main config.

# [18-12-2024] Day 8: Config and Renderer Planning
- **ConfigManager**:
    - Began working on the *configManager*.
    - Set up basic *config.json* file that points to the other config files.
    - Began working on a *loadLevel()* function that reads from *levels.json* to find text files that contain the level format.
- **Renderer**:
    - To complete above will want to render each of the objects read in the text file. Created a *Renderer* class to do so.
    - Added function to load images to hashmap to be later reference by name without having to load the png again.
    - Need to consider about unloading images to save memory, as well as preloading common assests.

# [19-12-2024] Day 9: Config and Renderer Basics Creation
- **ConfigManager and Renderer**: Completed both in conjunction
    - Want to add a *loadImage()* function to *Renderer* that performs action of drawing the image to the screen.
    - Complete *loadLevel()* basic functionality. It is now able to read the text file specified in *levels.json*, printing it to stdout.
    - The next goal is to interpret each of the symbols. I am not sure if this is a *Renderer* job, or a *configManager* job.
    - For now will leave will code it as a *configManager*.
    - Adding a *references* object to *levels.json* that will assist in translating the letters in the text files to their appropriate png names.
    - Will use a different letter for each type of png, and a different number to differentiate between the types.
    - For now will have references all just look in one file, but later can make the level be able to change the directory.
    - This will allow one levels ground.png look different to anothers.
    - Issue is however, that if ground.png already exists, it will not update it. Will have to tackle this problem after I have confirmed the basics work.
    - Now realised that I will have to store the pngs to load somewhere so it does not have to translate the entire text file each frame.
    - Will store this in *Renderer* using a 2D array called *levelLayout*.
    - Will only store stationary objects in this. Later will have to decide how to keep track of objects that move over time.
    - Finished a basic level text file read, drawing 16 x 16 tiles as requested.

- **Next steps**:
    - Consider how player and other physics objects are to be drawn.
    - Make ground stop floor, walls stop movement, and add a jump.
    - Test feasibility of 16 x 16 tiles currently being used to test. Seems fun to work with, and easy to draw.
    - Create test cases once basic movement is complete.

# [20-12-2024] Day 10: PhysicsHandler Improving
- **PhysicsHandler Progression:**
  - Will try out using *PhysicsHandler* to call for each of the *PhysicsObjects* to be drawn.
  - Each *PhysicsObject* will hold the image reference to be passed to the renderer in the *PhysicsHandler* loop that passes through all the objects.
  - Now need a way to tell if the player is on the ground. For now lookup position of feet, if on ground don't add gravity and set feet level with ground.

# [23-12-2024] Day 11: Implementations and Bugs
- **To Implement**:
  - Want to add ability to jump. I think just make it an instant increase in y velocity. Can only jump when touching ground.
  - Added friction, but it feels off. Right now just dividing the movement.
  - To introduce hitboxes, will add width and height requirement to the *physicsObject* interface.

- **Window Bug**: Currently struggling to fix.
  - I should be able to fit 40 16x16 tiles across the screen, however at a scale factor of 2 can only fit 38
  - When the scale factor is increased to 3, can fit 39. This hints at potentially some margins or something cutting off the right side of the screen.


# [24-12-2024] Day 12: Brief Brainstorm
- **To Implement**:
  - Want all objects inside hitbox to be returned in the *Renderer*'s *typeTouching()* function.
  - All the handlers and managers are getting a bit messy in *Game.java*. Will try to add a *setupManagers* class.

# [26-12-2024] Day 13: Bug Fix!
- Finally fixed the window bug by swapping back to Windows (ironic I know).
- Graphical issue seemed to be caused by remote VSCode being run through WSL.
- Previous progress has felt stunted due to this bug being hard to fix. Didn't document much since nothing was working.

- **Next Steps**: Now that the window is fixed finally.
  - Set up *SetupManagers*. This can wait until some level manager is created. Will be clearer what is required of this *SetupManagers* class then.
  - Code hitboxes, that is, be able to detect all tiles being touched by requested object.
  - Add jumping.
  - Try out adding border to for different screen sizes and resolutions to function. (This can wait for a while, but placing here as a way to remember).

# [27-12-2024] Day 14: Cleaning Up / Refining Files
- **Code Clarity**:
  - I feel as though the framework is becoming a bit undefined.
  - Will attempt to rectify this by polishing and commenting what has already been done.

- **Config Changes**:
  - Set up default values in *config.json* for gravity and friction coefficient.
  - Will setup other managers here, rather than through *SetupManagers*. Will delete that file now.
  - Made it so *ConfigManager* passes appropriate values to other managers in its constructor.
  - The previously mentioned physics values to *PhysicsManager*, and the image folder location to *Renderer* for now.

- **Renderer Changes**:
  - Will try to centralise the *drawImage* calls to *Renderer*. This means removing some current *PhysicsManager* logic.
  - Want to remove *Game* instance being stored in a variable. Feels bad for encapsulation.
  - Want to make it so level sizes do not have to be manually set to function, could be resolved using dynamic arrays.
  - Made it so level layout is stored in an *ArrayList* so that it is dynamic, and no longer needs its size set manually.
  - Changed *typeTouching()* to return the pngName being touched. Still yet to implement hitboxes.
  - Will make it so that hitboxes are directly tied to their PImage. This means it will be handled in *Renderer*.
  - For now that means returning an *ArrayList* of all tiles being touched by image.
  
- **PhysicsManager Changes**:
  - Pretty much removed the dimensions and imageLoc functionalitees and delegated them to other classes.
  - Added a function to take default physics values (gravity and friction coeffecient rn) as single parameters, may have to change to an array param later if larger sets of vaules.

- **Next steps**:
  - Currently falling too far before being stopped. Fix this. Potentially a hitbox issue.
  - Look into doubling the size of level's text files.
  - Add an entities list that holds all non-tile objects to be drawn.
  - Add jumping and other basic movement.

# [28-12-2024] Day 15: Some fixes and some issues
- **Fixes**:
  - Fixed falling through block problem, but feels like an odd fix. <= for y but only < check for x.
  - Realised that will need direction of blocks being touched. So maybe return a second *ArrayList* that holds *PVector*s for the value of the tile.
  - Added a wrapper class in order to return both these *ArrayList*s whilst maintaining type safety.
  
- **To Do:**
  - Might want to also return the images 'hitbox' / dimensions for calculating direction of object being touched.
  - Want it so that things like friction are not applied when holding down run?
  - If falling fast can fall through block a couple of pixels. Need to fix.
  - Maybe on hitting ground realign? Also add a max velocity from gravity alone. Or at least something it approaches.