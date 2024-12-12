package platformer;

import processing.core.PApplet;

import java.awt.*; // used for getting user screen dimensions

public class App extends PApplet {

    @Override
    public void settings() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // size(screenWidth, screenHeight, P2D); // set the size of the window
        fullScreen();
        System.out.println(screenWidth);
        System.out.println(screenHeight);
    }

    // initialize variables or game state
    @Override
    public void setup() {
        frameRate(60);
    }

    @Override
    public void draw() {
        background(16, 194, 109); // black background
    }

    // close window when key is pressed
    @Override
    public void keyPressed() {
        if (key == 'q' || key == 'Q') {  // press 'Q' to quit
            exit();  // cose the window
        }
    }

    public static void main(String[] args) {
        PApplet.main("platformer.App");
    }
}
