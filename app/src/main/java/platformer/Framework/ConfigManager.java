package platformer.Framework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;

import platformer.Game;
import processing.data.JSONArray;
import processing.data.JSONObject;

public class ConfigManager {
    
    private final String CONFIG_LOC = "src/main/resources/config/config.json";

    private FrameworkManager FWMan;

    private JSONObject configData;
    private JSONObject files;
    private JSONObject directories;

    private JSONObject settingsData;
    
    private JSONObject saveData;

    private JSONObject levelData;
    private String levelLayoutsDir;
    private JSONArray levels;
    private JSONObject tiles;
    private JSONObject imageRefs;
    private JSONObject attributes;

    public ConfigManager() {
        // load framwork manager
        FWMan = FrameworkManager.getFrameworkManager();
        Game game = FWMan.getGame(); // game required to loadJSONObjects

        // setup config files
        configData = game.loadJSONObject(CONFIG_LOC);
        
        // retrieve the data for directories and files from within the paths jsonobject
        JSONObject paths = configData.getJSONObject("paths");
        files = paths.getJSONObject("files");
        directories = paths.getJSONObject("directories");

        // load the other json files
        String configDir = directories.getString("config");
        settingsData = game.loadJSONObject(configDir + files.getString("settings"));
        saveData = game.loadJSONObject(configDir + files.getString("save"));
        levelData = game.loadJSONObject(configDir + files.getString("levels"));

        // levels loading
        levelLayoutsDir = directories.getString("level-layouts");
        levels = levelData.getJSONArray("levels");
        tiles = levelData.getJSONObject("tiles");
        imageRefs = tiles.getJSONObject("image-refs");
        attributes = tiles.getJSONObject("attributes");
    }

    public void setupInterdependencies() {        
        // physics manager
        PhysicsManager physicsManager = FWMan.getPhysicsManager();
        
        JSONObject physics = configData.getJSONObject("physics");
        HashMap<String, Float> physicsValues = new HashMap<>();

            // grab values from physics object in config.json and send them to physicsManager
        physicsValues.put("gravity", physics.getFloat("gravity"));
        physicsValues.put("friction-coeff", physics.getFloat("friction-coeff"));
        physicsValues.put("terminal-vel", physics.getFloat("terminal-vel"));

        physicsManager.setPhysics(physicsValues);

        // renderer
        Renderer renderer = FWMan.getRenderer();
        String imagesLoc = directories.getString("images");
        renderer.setImageLoc(imagesLoc);
    }

    // draws the level onto the screen by reading the appropriate text file
    public void loadLevel(int levelNum) {      
        Renderer renderer = FWMan.getRenderer();  
        
        JSONObject level = levels.getJSONObject(levelNum);        
        String levelLayout = level.getString("layout");
        
        // open file to read
        try(BufferedReader reader = new BufferedReader(new FileReader(levelLayoutsDir + levelLayout))) {
            
            String line;
            int lineCount = 0;
            // read each line
            while ((line = reader.readLine()) != null) {
                
                String key;
                // read each character
                for (int i = 0; i < line.length(); i++) {
                    key = Character.toString(line.charAt(i));
                    if (i + 1 < line.length() && Character.isDigit(line.charAt(i + 1))) { // if next letter is a number, add to key and skip over it
                        key += line.charAt(i + 1);
                        i++;
                    }
                    String pngName = imageRefs.getString(key); // get the png name of the key
                    renderer.updateTile(i, lineCount, pngName); // when adding more folders to images/ will have to update
                }
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}