package platformer;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import processing.core.PImage;

public class Renderer {

    private int CELLSIZE = 16; // 16 x 16 pixels for now, can make non-constant / dynamic later

    private Game game;
    
    private HashMap<String, PImage> images;
    private String[][] levelLayout;
    private int levelWidth;
    private int levelHeight;

    private int scaleFactor; // add function to update later, when working on settings

    public Renderer(Game game, int scaleFactor) {
        this.game = game;
        images = new HashMap<>();
        this.scaleFactor = scaleFactor;
    }

    public PImage getImage(String imageRef) { // need to think about unloading images to save memory, as well as preloading common assests
        PImage image = images.get(imageRef);
        if (image == null) {
            try {
                image = game.loadImage(URLDecoder.decode(this.getClass().getResource(imageRef +".png").getPath(), StandardCharsets.UTF_8.name()));
                images.put(imageRef, image); // store image for later use (no need to load again)
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return image;
    }

    public void drawImage(String imageRef, float x, float y) { // note this loadImage is different to game.loadImage, maybe change later
        PImage image = getImage(imageRef);
        game.image(image, x * scaleFactor, y *scaleFactor, image.width * scaleFactor, image.height * scaleFactor);
    }

    public void setLevelSize(int levelWidth, int levelHeight) {
        this.levelWidth = levelWidth; // can potentially get rid of these variables and instead use .length on the arrays, do so if need dynamic
        this.levelHeight = levelHeight;
        levelLayout = new String[this.levelHeight][this.levelWidth];
    }

    public void updatelevelLayout(int x, int y, String pngName) {
        levelLayout[y][x] = pngName;
    }

    public void drawLevel() {
        for (int y = 0; y < levelHeight; y++) {
            for (int x = 0; x < levelWidth; x++) {
                if (levelLayout[y][x] == null) continue;
                drawImage(levelLayout[y][x], x * CELLSIZE, y * CELLSIZE);
            }
        }
    }

    public boolean typeTouching(int x, int y) {
        return (levelLayout[y][x] != null);
    }
}