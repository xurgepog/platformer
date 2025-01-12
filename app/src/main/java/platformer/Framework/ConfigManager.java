package platformer.Framework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import platformer.Game;
import processing.data.JSONArray;
import processing.data.JSONObject;

public class ConfigManager {
    
    private final String CONFIG_LOC = "src/main/resources/config/config.json";

    private FrameworkManager FWMan;

    private JSONObject configData;
    private JSONObject directories; //remove later?? - maybe add all as global??

    private JSONObject settingsData;
    
    private JSONObject saveData;

    private JSONObject levelData;
    private String levelsLoc;
    private JSONArray levels;

    public ConfigManager() {
        // load framwork manager
        FWMan = FrameworkManager.getFrameworkManager();
        Game game = FWMan.getGame();

        // setup config files
        configData = game.loadJSONObject(CONFIG_LOC);
        
        // retrieve the data for directories and files from within the paths jsonobject
        JSONObject paths = configData.getJSONObject("paths");
        directories = paths.getJSONObject("directories");
        JSONObject files = paths.getJSONObject("files");

        // load the other json files
        settingsData = getConfig(game, directories, files, "settings");
        saveData = getConfig(game, directories, files, "save");
        levelData = getConfig(game, directories, files, "levels");
    }

    // returns loaded jsonobject using its reference in config.json paths
    private JSONObject getConfig(Game game, JSONObject directories, JSONObject files, String reference) {
        return game.loadJSONObject(directories.getString(reference) + files.getString(reference));
    }

    public void setupInterdependencies() { // temp name, probs change later??
        // setup other managers - need to put somewhere else, maybe in setting up interdependencies section
        // physics manager
        PhysicsManager physicsManager = FWMan.getPhysicsManager();
        JSONObject defaultPhysics = configData.getJSONObject("default-values");
        physicsManager.setPhysics(defaultPhysics.getFloat("gravity"), defaultPhysics.getFloat("friction-coeff")); // maybe send a list later

        // renderer
        Renderer renderer = FWMan.getRenderer();
        String imagesLoc = directories.getString("images");
        renderer.setImageLoc(imagesLoc);
    }

    public void loadLevel(Renderer renderer, int levelNum) {
        // if levels location or levels info has not been loaded before, do so
        if (levelsLoc == null) 
            levelsLoc = levelData.getString("levelsLocation");
        if (levels == null)
            levels = levelData.getJSONArray("levels");
        
        JSONObject level = levels.getJSONObject(levelNum);
        
        // draws the level onto the screen by reading the appropriate text file
        String levelFile = level.getString("layout");
        try(BufferedReader reader = new BufferedReader(new FileReader(levelsLoc + levelFile))) {
            String line;
            int lineCount = 0;
            JSONObject references = levelData.getJSONObject("references");
            while ((line = reader.readLine()) != null) {
                
                String key;
                for (int i = 0; i < line.length(); i++) {
                    key = Character.toString(line.charAt(i));
                    if (i + 1 < line.length() && Character.isDigit(line.charAt(i + 1))) { // if next letter is a number, add to key and skip over it
                        key += line.charAt(i + 1);
                        i++;
                    }
                    String pngName = getPngName(references, key); // get the png name of the key
                    renderer.updateTile(i, lineCount, pngName); // when adding more folders to images/ will have to update
                }
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getPngName(JSONObject refs, String key) {
        return refs.getString(key);
    }
}