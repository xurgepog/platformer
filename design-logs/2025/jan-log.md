
# [04-01-2025] Day 16: New Year, On Holidays
- **New Year Mentions**:
  - Happy New Year!
  - Had a bit of a break due to celebrating and focusing on *LeetCode*.
  - Currently on a plane so there is no internet, however, will do as much as I can, and plan for what I can't.

- **To Research**: Once I have internet.
  - Consider having all objects nearby returned without a tiles system. This will allow a centralised method.
  - Look into how other games manage hitboxes and calculating what is being touched. 
  - Research how max velocity is calculated. This will allows different interaction when the player travels through different mediums (e.g. water).
  - Don't want it to ruin fun momentum tricks when added however.
  - Need to see how games make the camera follow the player. Think this must be done through moving all tiles, but maybe there is an easier way built into **Processing**.
  - Look into OOP principles, since I think my framework code is a bit messy when considering encapsulation.

# [06-01-2025] Day 17: Researching Previous Mentions
- **Research**:
  - Look into what was previously mentioned.
  - Most the solutions were what I was already thinking.
  - Will keep the grid system. Considering adding another 2D array for the entities, used to see all within a certain radius.
  - To stop player falling through the ground need to check where they will be after applying velocity, not where they are now.
  - To allow entities to be spawned via the level text files, will need to increase the text file size to allow for more variation of inputs. Will try 2x2 for each tile.
  - Considering making it easy to change the size representation, increase I want to go to 3x3 later.

- **To Do**: Step by step.
  - Beginning to lack some motivation.
  - I think I just need to clearly set out what I plan on doing.
  - First I want to get basics physics polished in *PhysicsManager*. This includes properly implementing hitboxes.
  - Then I will encapsulate better, look through managers and decide what needs to be done.
  - I will make it so the camera follows the player.
  - Increase size of level text files.
  - Remove any magic numbers.
  - Add entities.
  - Polish framework with basic movement and physisc.
  - Add more complex movement such as dashes.

- **Polishing PhysicsManager**:
  - Changing order of logic. Will add basic physics first then check the new location for what is within hitbox
  - Will introduce forces.
    - Force from gravity = mass * acceleration of gravity
    - Drag force = 0.5f * density (of the fluid) * dragCoefficient (dependent on shape) * area (cross section) * vel.y squared
    - Will update *PhysicsObject* to allow these variables.
  - To assist in these calculations, will change current and future float values to doubles.
  - In order to better calculate cross section area

- **Honing Game Idea**: Physics appreciation game.
  - Maybe lean more towards accurate physics than gameplay.
  - Could give player a grappling hook and implement it using pendulum physics.
  - This would require being able to calculate drag at different angles I believe.
  - I imagine drag can be broken into x and y components as all forces can (if I remember correctly... it's been 2 years ok).
  - More physics to include: collisions, torque, buoyancy, static and kinetic friction, pressure, energy conservation, centripedal and centrifugal forces.
    - This list can be made more extensive later.
    - Will probably aim to get a finished framework with some basic forces before adding all of those listed here even.
    - Want to complete two side projects by end of Feb after all.
    - Can return to this project later.
  - Might try and go for a rain world asthetic.
  - Also want objects to be able to fall on angles. This may take some thought to manage.

- **Formatting Logs**: Improvements.
  - Went back and formatted previous logs a bit better from the previous week.
  - Noticed some things may be worth researching a bit more as I was doing so.
  - Will try and format logs better as I go from now on to ensure both a better workflow and easier understanding of what I was saying previously.
  - I think I should choose a specific goal and work on that for a day, because pre-formatting the logs are very messy and all over the place.
  - I believe this is impacting my efficiency, and due to working on such a variety of things at once, not everything I do is being logged.
  - Also added *jan-log.md* which this text is in currently. Forgot to do so orginally.

# [07-01-2025] Day 18: Minor changes, big impacts
- **Idea Comments**:
  - Not sure if I should fully commit to the physics simulator.
  - I like the idea of using real world equations in the game. But, anything that can be simplified should be I think.
  - I have a plan on encorporating it in a later project.
  - Also might not have any entities, nor have camera follow the player.
  - Instead do screen by screen.

- **Today's Goal**:
  - I know I previously mentioned step by step what I want to do, but going into more detail on how to finish *PhysicsManager*.
  - Want to get all the different attributes to be added to *PhysicsObject* that were required by forces mentioned in previous day.
  - If *Player* is the only *PhysicsObject* don't need the class.
  - Might keep it, want to try and have blocks fall etc.
  - Will return doubles back to floats, do not require that much precicion.
  - Added boolean array that checks which sides of physics object is blocked, stopping movement in that direction.
  - Changed *onGround* to *touched* to hold this array in each object.
  - By included mass to *PhsycicsObject*, can allow things to fly, while also being blocked.
  - Give up on idea to calculate next position. Instead if would caclulate in ground, move to appropriate spot.
  - Removing mass and drag calculations. Unnecessary for my simple platformer.
  

- **To Do**:
  - Make the array of tiles not hold strings, but objects. Each object will have the reference name, and if its physical or interactable, etc.
  - Change image getter to have better variables names.
  - Fix touching calculation, remember drawn from top left.

- **To Improve Next Time**:
  - Use stubs more. That is, code a single part with set numbers. Don't tackle it all at once.
  - Don't try to make a module perfect straight away. It is ok to be messy. Once the module works, refine it.
  - Add and commit more. I guess have a clearer goal for the day. Complete the goal / module, then commit it.

# [08-01-2025] Day 19: Polishing
- **What to do now...**:
  - Not going to lie, it is a lot of work to create something like this from scratch.
  - Been having complex ideas that I am too scared to implement.
  - Not sure if I should just try anyway.
  - Will complete everything I said first. Then choose what to do from there based on my confidence.

- **Coding**:
  - Made it so *TouchingPos* returns the actual pixel of the tile being touched, rather than the tile position.
  - Added *dimensions* to *TouchingData* so that the size of the hitbox used is returned as well.
  - Used *dimensions* to set player back onto block touching. That is stoped phasing through blocks at high speeds.

# [09-01-2025] Day 20: Basic Collision and Movement Near Completion
- **Collision**:
  - I think it seems more natural to let the play phase partway through a block when approaching it from the side.
  - Can add an animation to make it look normal.
  - Will potentially add this after all basics are done.
  - Need to consider phasing through blocks when dashes are added.
  - Made it so that if a block is considered below or above object, is not considered for blocking.
  - Depending on which direction currently going, push out opposite to which ever axis is fastest.
  - Need to make it so if tile is on very edge of object it is not considered above or below.

- **Movement**:
  - Playing with max y velocity before gravity stops being added. This way it doesn't force a max speed, but stops natural acceleration past a certain point.
  - Need to make jump reset once leaving the ground. Other wise can stack jumps.
  - Time to add dash! For now use 'm' to dash. Will just add velocity in current direction.
  - Can press both jump and dash at once to go super far. Prioritise dash maybe.
  - Didn't work. Issue is adding to velocity rather than setting it. Want momentum though.
  - Maybe dash increases speed to set amount. If any faster already does nothing.
  - Might be good enough for now.
  - Dashing feels not that impactful when done sideways. This is because of the friction applied.
  - Think I will make dash last a certain amount of time.
  - To implement I think I will need to make *physicsObject* have an update function.
  - For now will call the function in *PhysicsManager*. May centralise all updates later.

- **Framework Manager**:
  - Now that I am beginning to development movement, need to start considering where the user inputs are going to be actually handled.
  - That is, what tells the player to jump when 'w' is pressed.
  - If the framework had a manager, like previously discussed and discarded, could pass the input handler into physics objects.
  - Then from here the object could check for itself.
  - Just did some research and due to the interdependencies between my Managers, it is a good idea to add a framework manager.
  - Added *FrameworkManager* class. Name could be subject to change.

# [11-01-2025] Day 20: Implementing Framework Mangager
- **Framework Manager Creation Ideas**:
  - Maybe make the manager hold public instances of each of managers.
  - If I make the instances protected and static does this mean only things in the *Framework* folder can access them.
  - Feels a bit unprotected. Essentially have four global instance that can be handled from anywhere, since with no instance, all methods must be static as well.
  - Research indicates that a *singleton* might be a good fit.
  - A *singleton* is a class that has a single instance, and stores itself in a static variable.
  - Is still global, but can limit access of methods through protected access modifier.
  - Is done by constructing the instance in a static function, but having a private constructor so it can not be initialised directly.
  - Means that main instance can be held in *Game*, but only other files in the framework can access and modify the important parts.
  - Can use a static function to return the static instance so that it can be renamed as wanted for code cleanliness.
  - Also means that instance can be made private, and that a constructor can be used.
  - Need to think if it is better to have protected attributes, or their associated setters and getters be protected.
  - Will use protected getters, private attributes.
  - Now want to fix the managers impacted by these changes, and have a set format for handling interdependencies between managers.
  - Want to limit parameters required by manager constructors.
  - Potentially remove need for game by having an instance stored.
  - Could have all game requiring function calls be done in *FrameworkManager*. Similar to the kernel passing its system calls to the OS. 

- **Framework Mananger Progress**: Listing what has actually occurerd (not ideas)
  - Made *Framework* manager a *singleton*. Uses protected functions to only allow other managers to access important data.
  - Will use private variables with protected getters.
  - Added getters for each of the managers.

# [12-01-2025] Day 20: Making Framework Manager Functional
- **Framework Manager Progress**:
  - Hold *Game* instance in the *Framework Manager*, and pass it to the required functions directly using a getter.
  - Created a *createFrameworkManager* function that sets up the *Game* instance, and removes need for *Game* to call the getter.
  - If getter is called prior to creation, throw some exception. (Look up exception types when internet)
  - If creation is called more than once, throw an exception.
  - Will use *IllegalStateException*.
  - Now *Game* is only accessible through this manager and the *Game* file itself!
  - Changed manager getters to public so that they are accessible to *Game*.
  - Made it so managers are initialised after instance is.
  - Created temp interdepencies functions for testing purposes. Will clean up how the managers connect to one another later.
  - Works!

- **Other Ideas**:
  - Maybe split *PhysicsManagers* update function up for clearer code? Right now a lot of code all in one function.
  - Look at other files and see if any other functions suffer from this same fault.
  - Need to look into what makes a useful exception. Ones implemented today might not be useful, and want to know for future exception usage.
  - Fix up interdependencies code.
  - Will make it so that all functions called are written below the one calling it.

- **To Do**:
  - Look at all previous ideas from previous days an bunch them here.
  - Add an update function to *physicsObjects* that do allow for unique behaviours each frame besides falling.
  - Complete players update function.
  - Polish players dash.
  - Make camera follow player. If not near edge of tiles.

# [14-01-2025] Day 21: Planning
- **Settings ideas**:
  - Maybe move default values into *settings.json*, then layout the settings as user and dev accessible.
  - Split up user settings into categories like *audio*, *visual*, etc.
  - Figure out how to split dev settings up when more are added. Thinking what manager requires what values, or what they relate to, e.g. physics.
  - Need to consider what else to add to settings. Look up when internet is available, what should be in the main config.
  - Since everything could be considered a setting. Maybe leave dev / default values in config?
  - Figure out later.

- **Documentation**:
  - Filled out basics.md file in mechanics / movement folder with headings of future things to add.
  - Added more than needed, just put all ideas, so organise later.
  - Will make it so the folder does not just contain mechanics, but rather includes all finalised decisions, breaking down what each framework does etc.

- **Mechanics ideas**:
  - Add different friction based on tile being touched.
  - Can make it so friction is applied based on direction of block. This will allow sliding down walls.
  - When implementing camera movement, make it lag a bit behind the player. Looks smoother.
  - Based on distance from player speed up.
  - Will have to move all the tiles since no actual camera movement in *Processing* I believe.
  - Will check before I begin implementing however.
  - If everything has to move relative to camera, just calculate where camera is compared to player and where to player is, then subtract it off everything.

- **Framework Manager**:
  - Consider adding a *loadDefaults* function in *ConfigManager* to replace temporary one.
  - Maybe add some kind of interface for managers.

- Look into enums and other class types, just as a reminder for what they do.
- May need them later.

# [21-01-2025] Day 22:
- **Personal Notes**:
  - Had a bit of a break due to being pretty sick.
  - Still am sick which is pretty annoying, but need to lock in.
  - Goal is to finish the framework of the game before the end of Febuary.
  - This is along side creating a resume and polishing school projects, so there is lots to do.

- **Player Movement**: Dashing
  - Today I just want to finish the players dash.
  - The idea is to make it apply a set velocity for a certain amount of time.
  - If player collides with wall, stop collision early.
  - Need a way to disable forces while dashing. Would help for other physics objects that want to float.
  - Perhaps force a forces array onto *phyicsObjects* that holds all the forces that are to be applied to that specific object.
  - Potentially allow collision to be ignored as well.
  - Right now just implementing it as a boolean array, will implement a format that is clearer later.
  - Dash works. Diagonals are way too strong. Also since turning of forces when jumping, player will levitate while dashing.
  - Need to make it that players movement is set to 0 before dash. 
  - Could ruin momentum, but works for now.

- **Next Steps**:
  - Start animating character movement.
  - Look at last two days for framework improvements that need to be implemented.

# [22-01-2025] Day 23: Previous Tasks
- **Gathering previous jobs to do**: Will tick off as completed.
  - Animate character.
  - Split up functions in framework.
  - Remove useless exceptions.
  - Fix interdependencies code.
  - Order functions so they are in order of being called.
  - Make camera follow player.
  - Polish player update function and dash.
  - Make it so only certain tile types are flagged as physical.
  - Make boolean arrays clearer as to what each index is holding.  *X*
  - Add menu and level loader.
  - Remove constants.
  - Organise config files.

- **Make Boolean Arrays Clear**:
  - Renamed *forces* to *activeForces*.
  - Instead of a boolean array, try a hashmap with keys being strings with force type and value being boolean.
  - Will leave *touched* as a boolean arary.


# [23-01-2025] Day 24: Small Progess to Previous
- **Organise Config Files**:
  - Need to decide what is going to be stored in each of the config files.
  - Will try and create a basic layout in each, even if data is not going to be used yet.
  - In *levels.json* adding a *tiles* jsonObject. Inside will hold *image-refs* (originally called references) and *attributes*.
  - *attributes* will hold jsonArrays, and for now just incudes *solid* (object stops player movement), and *damage* (kills player on touch). 

- **Fix Interdependencies Code**:
  - Interdependencies extend outside the framework. Player requires setup as well.
  - Seems that all interdependencies come from the need to access config details.

- Issue found when holding 'w' and falling off left edge. Try and identify cause then fix.

# [25-01-2025] Day 25: Planning and Config Layout Complete
- **Planning Mechanics**:
  - Want to make the levels look like labs.
  - Add dash reset crystals, bounce pads, velocity flippers, blocks that extend dash, ground that speeds up, water that can be swam in, spikes.
  - Maybe add entity array into renderer and make physics objects have a size attribute. This means moveable boxes and other moving entities can exist.
  - Constantly check if physicsObjects are touching, if so stop their movement.
  - Add a *phyicsObject* attribute in *levels.json*. Will add a box object when ready to test this idea.
  - This means that physicsObjects will have to have their own class. Maybe also create classes for tiles.

- **Staying Motivated**:
  - Holy I have a lot left to do lol.
  - I think to stay motivated with this much work I need to set clear goals. Luckily I have to previous tasks set out well.
  - Will create a TODO file and put everything there for clarity.
  - Just need to pick what to do each day and commit to it.
  - Today I will no matter what complete organising the config files.

- **Organising Config Files**:
  - **config.json**:
    - Will simplify by forcing all config files to be in the same folder.
    - Now config folder is given in *ConfigManager*.
    - Removed *paths* and everything within.
    - Now config file names are given in *config-files* jsonObject.
    - Other required paths are given in *other-paths* jsonObject.
    - Added *level-layouts-dir* to *other-paths* along with pre-existing *images-dir*.
    - Readded *paths* and reverted *ConfigManager* changes.
    - Added *resources* directory and *config* directory to *directories* object.
    - Removed *-dir* from end of directories.
    - Changed *default-values* to physics.
    - Added *debug* jsonObject along with *show-hitboxes* and *enable-logs* booleans.
    - Removed *resources* directory. Will use full paths.
  - **settings.json**:
    - Removed *dev* and *user* sections along with all *dev* values. These will only be present in config.json for now on.
    - Added a *controls* section that has all the buttons that are currently being used (wasd and m).
  - **levels.json**:
    - Added *id* for easy referencing to levels.
    - Moved *levelsLocations* to *config.json*.
  - **save.json**:
    - Added: *current-level*, *completed-levels* jsonArray, *stats* jsonObject which holds: *total-playtime*, *deaths*, *kills*.
    - Added *current-checkpoint* jsonArray which saves the x and y position of the last touched checkpoint.

  - This should be enough for now. Kind of gives me a roadmap to work on as well.
  - Will have to fix configManager now. Will do so while working on interdependencies setup.

- **Framework Fixing**: making code run after json changes.
  - Start by fixing *ConfigManager* after change config json files.
  - Will remove *getConfig* function.
  - Added files and directories to global variables (or whatever class accessible function are called).
  - Maybe make two level files, one has all the tiles that won't need to ever be reset on death or level reload. The other has anything that can be destroyed.
  - This can be implemented later.
  - Made physicsValue to be sent to *physicsManager* a hashMap rather than each being sent individually.
  - Moved *TILE_SIZE* to *Game*. Will add a getter for other managers to use.
  - Added *scaleFactor* getter to *Game*.
  - Works now.
  - Want to remove exceptions in *FrameworkManager*. I want to use exceptions in placed possible for player to access.

**Polishing Framework**:
  - Removed *getPngName* function from *ConfigManager*.

**Considering Advanced Tiles**:
  - Want to make it so tiles are objects.
  - I also want renderer to hold a list of tiles that can move outside of fixed grid.
  - Will want to introduce a tile interface.
  - This will hold the size of the tile along with its attributes.
  - Need to consider how I going to differentiate between the tiles. By class, by an attribute?

- Probabaly should stop listing every single change. Just write what I am aiming to achieve over all.

# [26-01-2025] Day 26: The Decision
- **Considering Advanced Tiles**:
  - Need to consider how I want to implement water and pushable boxes.
  - From here the rest should become clear.
  - Do I want the game to revolve around the player, or allow other entities to interact with one another.
  - I think I want them to interact. Consider how the player is coded currently. Want to treat the player as a tile in a way.
  - Think about how the player is stopped currently. It is done in *PhysicsManager*. How will it change if logic is stored in the tiles themselves.
  - Will be mostly the same, but the interaction logic between the player and the ground will be handled in the ground tile class.
  - I will create a *box* class as a *physicsObject* and see what currently happens.
  - First thing I notice when trying to do this, is that magic numbers are used for player spawn currently. Will make spawns handled in a single spot.
  - Seems that I should handle spawning and adding objects to *PhysicsManager* through *Renderer*.
  - A possible future issue. If every moveable object is constantly considering where the other moveable objects are it will be pretty slow.
  - Maybe check using nearby things in the grid.

**The Decision**: Spoiler, no more advanced tiles.
  - I think the advanced tile idea should not be done.
  - I feel that I should change the systems I have to have to player be the only *physicsObject* as well.
  - The reason for this decision is that my future game idea that is very physics heavy will allow me to explore treating all objects as physics objects idea.
  - So to avoid doing the same thing twice, and improve the scenarios I've encountered as a progammer, will do a player is the only physics object framework.

**Player Focused Framework Implementation**:
  - Player will be only thing that is impacted by forces. This means it is the only *physicsObject*.
  - This does mean a lot of what I have introduced has been useless, but we persevere nonetheless.
  - Will make *PhysicsManager* more of the place where the logic behind player interactions with different types of tiles is completed.
  - This means the player can be created within *PhysicsManager* and there is no more point to *PhysicsObject*.
  - Will commit now before these changes however in case I choose to revert.
  - Time to change it to work!
  - Need to consider how to choose where player will spawn, and how levels are loaded.
  - When load level is called in *ConfigManager* it is what is drawing everything onto the screen.
  - Somehow when this is done it needs to read the config and create the player then.
  - Might change *PhysicsManager* to *PlayerInteractions*?
  - Need to consider where player related movement will be handled. In *PhysicsHandler*, in *Player*?
  - Will need to resize spawn png to be square and probably try and make it 16 x 16.

# [27-01-2025] Day 27: Player Focused Framework Continued
- **Player Focused Framework Continued**:
  - What will be handled in *Player* and what will be handled in *PhysicsManager*.
  - *Player* will hold what it does now, which is all the movement mechanics. *PhysicsManager* will handle all interactions.
  - This includes key presses.
  - Renamed *PhysicsManager* to *PlayerController*.

- **Some thoughts**: not important to progress
  - I'm now having doubts about this new system.
  - Maybe look into design patterns or whatever it is called and go hard on them.
  - So when asked in an interview the point of this side project I can say to utilise git in a similar fashion to a workplace environment, and design patterns.
  - Also wanted to work on a project myself.
  - This means, I will touch of my inkball to use interfaces and those systems more.

# [28-01-2025] Day 27: Might take a little break
- Really am considering going back and implementing the tile system.
- Want to just have some time off to think about it.