package platformer;

import processing.core.PApplet;

// import java.awt.*; // used for getting user screen dimensions

public class App extends PApplet {

    private Player player;
    private PhysicsHandler physicsHandler;
    private InputHandler inputHandler;

    private int frameRate;
    private int[] backgroundRGB;

    private final int SCREEN_WIDTH = 640;
    private final int SCREEN_HEIGHT = 360;

    @Override
    public void settings() {
        /*
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        fullScreen();
        System.out.println(screenWidth);
        System.out.println(screenHeight);
        */

        size(SCREEN_WIDTH, SCREEN_HEIGHT, JAVA2D); // set the size of the window
    }

    // initialize variables or game state
    @Override
    public void setup() {
        player = new Player(400, 300, 2);
        physicsHandler = new PhysicsHandler();
        physicsHandler.addObject(player);
        inputHandler = new InputHandler();

        frameRate = 60; // default frameRate;
        frameRate(frameRate);
        backgroundRGB = new int[]{190, 227, 219}; // 'BEE3DB'
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
        background(backgroundRGB[0], backgroundRGB[1], backgroundRGB[2]);

        float deltaTime = 1.0f / frameRate;
        physicsHandler.update(deltaTime);

        player.draw(this); // add a renderer later?

        if (inputHandler.isKeyPressed('a')) { // handle within inputHandler? - handle in level class later? - when created, for now this is fine
            player.moveLeft();
        }
        if (inputHandler.isKeyPressed('d')) {
            player.moveRight();
        }
    }

    public static void main(String[] args) {
        PApplet.main("platformer.App");
    }
}
