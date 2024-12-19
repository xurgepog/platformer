package platformer;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import processing.core.PImage;

public class Renderer {

    private int CELLSIZE = 16; // 16 x 16 pixels for now
    
    private HashMap<String, PImage> images;
    private String[][] levelLayout;
    private int levelWidth;
    private int levelHeight;

    public Renderer() {
        images = new HashMap<>();
    }

    private PImage getImage(Game game, String imageRef) { // need to think about unloading images to save memory, as well as preloading common assests
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

    public void drawImage(Game game, String imageRef, float x, float y) { // note this loadImage is different to game.loadImage, maybe change later
        PImage image = getImage(game, imageRef);
        game.image(image, x, y); // will have to scale
        // System.out.println(image.height);
    }

    public void setLevelSize(int levelWidth, int levelHeight) {
        this.levelWidth = levelWidth; // can potentially get rid of these variables and instead use .length on the arrays, do so if need dynamic
        this.levelHeight = levelHeight;
        levelLayout = new String[this.levelHeight][this.levelWidth];
        // System.out.println(this.levelHeight);
    }

    public void updatelevelLayout(int x, int y, String pngName) {
        levelLayout[y][x] = pngName;
        // System.out.println(pngName);
    }

    public void drawLevel(Game game) {
        // System.out.println(levelLayout[levelHeight-1][levelWidth-1]);
        for (int y = 0; y < levelHeight; y++) {
            for (int x = 0; x < levelWidth; x++) {
                if (levelLayout[y][x] == null) continue;
                drawImage(game, levelLayout[y][x], x * CELLSIZE, y * CELLSIZE);
                // System.out.println(y);
            }
        }
    }
}