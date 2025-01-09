package platformer.Framework;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import platformer.Game;
import platformer.Wrappers.TouchingData;

import java.util.ArrayList;

import processing.core.PImage;
import processing.core.PVector;

public class Renderer {

    // constants
    private final int TILE_SIZE = 16;
    
    // lists
    private HashMap<String, PImage> images;
    private List<List<String>> levelTiles; // tiles are in order of position to be drawn
    // private List<String> entities;

    // others
    private int scaleFactor;
    private String imageLoc;

    public Renderer(int scaleFactor) {
        images = new HashMap<>();
        levelTiles = new ArrayList<>();

        this.scaleFactor = scaleFactor;
    }

    private PImage getImage(Game game, String imageRef) { // need to think about unloading images to save memory, as well as preloading common assests
        String imagePath = imageLoc + imageRef;
        PImage image = images.get(imageRef);
        // if image not already stored, load
        if (image == null) {
            try {
                image = game.loadImage(URLDecoder.decode(this.getClass().getResource(imagePath +".png").getPath(), StandardCharsets.UTF_8.name()));
                images.put(imageRef, image); // store image for later use (no need to load again)
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return image;
    }

    public void drawImage(Game game, String imageRef, float x, float y) {
        PImage image = getImage(game, imageRef);
        game.image(image, x * scaleFactor, y * scaleFactor, image.width * scaleFactor, image.height * scaleFactor);
    }

    public void updateTile(int x, int y, String pngName) {
        // ensure row exists
        int rows = levelTiles.size();
        while (y + 1 > rows) { // +1 since y is the requested index
            levelTiles.add(new ArrayList<>());
            rows++;
        }

        // ensure column in requested row exists
        int cols = levelTiles.get(y).size();
        while (x + 1 > cols) { // +1 since x is the requested index
            levelTiles.get(y).add(null);
            cols++;
        }

        // add tile png
        levelTiles.get(y).set(x, pngName);
    }

    public void drawLevel(Game game) {
        // draw tiles
        for (int y = 0; y < levelTiles.size(); y++) {
            for (int x = 0; x < levelTiles.get(y).size(); x++) {
                if (levelTiles.get(y).get(x) == null) continue;
                drawImage(game, levelTiles.get(y).get(x), x * TILE_SIZE, y * TILE_SIZE);
            }
        }
    }

    // returns array list of all tiles in image hitbox - expand to entities later
    public TouchingData typesTouching(Game game, int x, int y, String imageRef) {
        PImage image = getImage(game, imageRef);

        List<String> touchingTypes = new ArrayList<>();
        List<PVector> touchingPos = new ArrayList<>();
        PVector dimensions = new PVector(image.width, image.height);
        TouchingData touching = new TouchingData(touchingTypes, touchingPos, dimensions);

        // checking entire 'hitbox' or image (i.e. everything the image touches, assuming image is rectangle)
        for (int y2 = y / TILE_SIZE; y2 <= (y + image.height) / TILE_SIZE; y2++) { // <= ??? only for y
            for (int x2 = x / TILE_SIZE; x2 <= (x + image.width) / TILE_SIZE; x2++) {
                if ((y2 >= 0 && y2 < levelTiles.size()) && (x2 >= 0 && x2 < levelTiles.get(y2).size())) {
                    String type = levelTiles.get(y2).get(x2);
                    // System.out.println(type);
                    if (type != null) {
                        touchingTypes.add(type);
                        touchingPos.add(new PVector(x2 * TILE_SIZE, y2 * TILE_SIZE));
                    }
                }
            }
        }
        return touching;
    }

    // setters and getters
    public void setScaleFactor(int scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public void setImageLoc(String imageLoc) {
        this.imageLoc = imageLoc;
    }
}