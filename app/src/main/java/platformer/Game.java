package platformer;

import processing.core.PApplet;
import processing.data.JSONObject;

// import java.awt.Dimension;  // used for getting user screen dimensions
// import java.awt.Toolkit;

public class Game extends PApplet {

    private Player player;
    private PhysicsHandler physicsHandler;
    private InputHandler inputHandler;
    private Renderer renderer;
    private ConfigManager configManager;

    private int frameRate;
    private int[] backRGB;
    private int[] objectRGB;

    // screen stuff
    private final int BASE_WIDTH = 640;
    private final int BASE_HEIGHT = 360;
    private int scaleFactor;
    // private int gameWidth, gameHeight; // size of game without borders
    // private int horiBorder, vertBorder;

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
        scaleFactor = 2;
        size(BASE_WIDTH * scaleFactor, BASE_HEIGHT * scaleFactor, JAVA2D); // set the size of the window
    }

    // initialize variables or game state
    @Override
    public void setup() {
        player = new Player(400, 300, 100);
        
        float gravity = 3f;
        physicsHandler = new PhysicsHandler(gravity);
        physicsHandler.addObject(player);
        
        inputHandler = new InputHandler();

        frameRate = 60; // default frameRate;
        frameRate(frameRate);
        
        backRGB = new int[]{190, 227, 219}; // '89B0AE'
        objectRGB = new int[]{137, 176, 174}; // 'BEE3DB'

        renderer = new Renderer();
        configManager = new ConfigManager(this, "src/main/resources/config/config.json");
        configManager.loadLevel(renderer, 0);
        // surface.setSize(1200, 600);
    }

    @Override
    public void keyPressed() {
        inputHandler.keyPressed(key);
    }

    @Override
    public void keyReleased() {
        inputHandler.keyReleased(key);
    }

    @Override
    public void draw() {
        background(backRGB[0], backRGB[1], backRGB[2]);
        fill(objectRGB[0], objectRGB[1], objectRGB[2]);
        rect(0, BASE_HEIGHT*scaleFactor - 100, BASE_WIDTH*scaleFactor - 100, 20);

        float deltaTime = 1.0f / frameRate;
        physicsHandler.update(deltaTime);

        player.draw(this); // add a renderer later?

        renderer.drawLevel(this);

        if (inputHandler.isKeyPressed('a')) { // handle within inputHandler? - handle in level class later? - when created, for now this is fine
            player.moveLeft();
        }
        if (inputHandler.isKeyPressed('d')) {
            player.moveRight();
        }
        if (inputHandler.isKeyPressed('q')) {
            exit();
        }
    }

    public static void main(String[] args) {
        PApplet.main("platformer.Game");
    }
}
