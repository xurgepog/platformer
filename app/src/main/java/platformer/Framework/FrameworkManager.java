package platformer.Framework;

import platformer.Game;

public class FrameworkManager {

    private static FrameworkManager instance; // singleton

    private Game game;

    private ConfigManager configManager;
    private PhysicsManager physicsManager;
    private Renderer renderer;
    private InputManager inputManager;

    private FrameworkManager(Game game) {
        this.game = game;
    }

    private void setupManagers() {
         // create framework instances
         configManager = new ConfigManager();
         physicsManager = new PhysicsManager();
         renderer = new Renderer(2); // remove scalefactor input?? -> unless have the default passed in 
         inputManager = new InputManager();
 
         // setup interdependencies

         // 1. use configManager to get default values?
         // 2. get default values from game? - or should this all be contained in the first step

         // temp setup for testing
         configManager.setupInterdependencies();
    }

    // create and get singleton
    public static FrameworkManager createFrameworkManager(Game game) {
        if (instance == null) {
            instance = new FrameworkManager(game);
            instance.setupManagers();
        }
        else {
            throw new IllegalStateException("FrameworkManager has already been created!");
        }
        return instance;
    }

    public static FrameworkManager getFrameworkManager() {
        if (instance == null) {
            throw new IllegalStateException("FrameworkManager has not been created yet!"); // are these exceptions pointless? - look into what makes a useful one
        }
        return instance;
    }

    // getter for game instance
    public Game getGame() {
        return game;
    }

    // getters for managers
    public ConfigManager getConfigManager() {
        return configManager;
    }
    public PhysicsManager getPhysicsManager() {
        return physicsManager;
    }
    public Renderer getRenderer() {
        return renderer;
    }
    public InputManager getInputManager() {
        return inputManager;
    }
}