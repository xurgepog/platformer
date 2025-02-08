package platformer.Framework;

import platformer.Game;

public class FrameworkManager {

    private static FrameworkManager instance; // singleton

    private Game game;

    private ConfigManager configManager;
    private PlayerController playerController;
    private Renderer renderer;
    private InputManager inputManager;

    private FrameworkManager(Game game) {
        this.game = game;
    }

    // create and get singleton
    public static FrameworkManager createFrameworkManager(Game game) {
        if (instance == null) {
            instance = new FrameworkManager(game);
            instance.setupManagers();
        }
        return instance;
    }

    private void setupManagers() {
        // create framework instances
        configManager = new ConfigManager();
        playerController = new PlayerController();
        renderer = new Renderer();
        inputManager = new InputManager();
        
        configManager.setupInterdependencies();
   }

    public static FrameworkManager getFrameworkManager() {
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
    public PlayerController getplayerController() {
        return playerController;
    }
    public Renderer getRenderer() {
        return renderer;
    }
    public InputManager getInputManager() {
        return inputManager;
    }
}