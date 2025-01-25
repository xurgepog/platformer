package platformer;

import processing.core.PApplet;

import java.awt.Dimension;  // used for getting user screen dimensions
import java.awt.Toolkit;

import platformer.Framework.ConfigManager;
import platformer.Framework.FrameworkManager;
import platformer.Framework.InputManager;
import platformer.Framework.PhysicsManager;
import platformer.Framework.Renderer;

public class Game extends PApplet {

    // framework
    private FrameworkManager FWMan;

    private ConfigManager configManager;
    private PhysicsManager physicsManager;
    private Renderer renderer;
    private InputManager inputManager;

    // constants
    private final int DEFAULT_FRAMERATE = 60;
    private final int BASE_WIDTH = 640;
    private final int BASE_HEIGHT = 360;
    private final int TILE_SIZE = 16;

    // screen related variables
    private int scaleFactor;
    // private int gameWidth, gameHeight; // size of game without borders
    // private int horiBorder, vertBorder;

    // other stuff - organise later
    private Player player;

    private int frameRate;
    private int[] backRGB;

    @Override
    public void settings() {
        /*
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        //System.out.println(screenWidth);
        //System.out.println(screenHeight);

        // if not 16:9 screen, pick smaller scale factor
        if (screenWidth / BASE_WIDTH <= screenHeight / BASE_HEIGHT)
            scaleFactor = screenWidth / BASE_WIDTH;
        else 
            scaleFactor = screenHeight / BASE_HEIGHT;

        gameWidth = BASE_WIDTH * scaleFactor;
        gameHeight = BASE_HEIGHT * scaleFactor;

        horiBorder = (screenWidth - gameWidth) / 2;
        vertBorder = (screenHeight - gameHeight) / 2;   
        */     
        scaleFactor = 2; // 2 for now, implement non magic number solution later
        size(BASE_WIDTH * scaleFactor, BASE_HEIGHT * scaleFactor, JAVA2D); // set the size of the window
    }

    // initialize variables or game state
    @Override
    public void setup() {
        frameRate = DEFAULT_FRAMERATE;
        frameRate(frameRate);

        // initialise framework
        FWMan = FrameworkManager.createFrameworkManager(this);

        configManager = FWMan.getConfigManager();
        physicsManager = FWMan.getPhysicsManager();
        renderer = FWMan.getRenderer();
        inputManager = FWMan.getInputManager();

        player = new Player(100, 100);
        physicsManager.addObject(player);
        
        
        backRGB = new int[]{190, 227, 219}; // '89B0AE'
        // objectRGB = new int[]{137, 176, 174}; // 'BEE3DB'

        
        configManager.loadLevel(0);
        // surface.setSize(1200, 600);

        // centering window - done last to give surface more time to setup, could look into another fix later
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int)(screenSize.getWidth() - BASE_WIDTH * scaleFactor) / 2;
        int y = (int)(screenSize.getHeight() - BASE_HEIGHT * scaleFactor) / 2;
        surface.setLocation(x, y);
    }

    @Override
    public void keyPressed() {
        inputManager.keyPressed(key);
    }

    @Override
    public void keyReleased() {
        inputManager.keyReleased(key);
    }

    @Override
    public void draw() {
        background(backRGB[0], backRGB[1], backRGB[2]); // replace with image later

        float deltaTime = 1.0f / frameRate;
        physicsManager.update(deltaTime);

        renderer.drawLevel();

        // handle below within inputHandler? - handle in level class later? - when created, for now this is fine
        if (inputManager.isKeyPressed('q')) {
            exit();
        }
        // wasd stuff
        boolean[] wasd = {inputManager.isKeyPressed('w'), inputManager.isKeyPressed('a'), inputManager.isKeyPressed('s'), inputManager.isKeyPressed('d')};
        if (wasd[1]) player.moveLeft();
        if (wasd[3]) player.moveRight();
        
        if (inputManager.isKeyPressed('m')) {
            player.dash(wasd);
        }
        else if (wasd[0]) {
            player.jump();
        }
    }

    // setters and getters
    public int getTileSize() {
        return TILE_SIZE;
    }

    public int getScaleFactor() {
        return scaleFactor;
    }

    public static void main(String[] args) {
        PApplet.main("platformer.Game");
    }
}
