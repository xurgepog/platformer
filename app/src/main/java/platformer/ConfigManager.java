package platformer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import processing.data.JSONArray;
import processing.data.JSONObject;

public class ConfigManager {
    
    private JSONObject configData;

    private JSONObject settingsData;
    
    private JSONObject saveData;

    private JSONObject levelData;
    private String levelsLoc;
    private JSONArray levels;

    private String imagesLoc;

    // loads all json / config files
    public ConfigManager(Game game, String configFilename) {
        configData = game.loadJSONObject(configFilename);
        
        JSONObject paths = configData.getJSONObject("paths");
        JSONObject directories = paths.getJSONObject("directories");
        JSONObject files = paths.getJSONObject("files");

        settingsData = getConfig(game, directories, files, "settings");
        saveData = getConfig(game, directories, files, "save");
        levelData = getConfig(game, directories, files, "levels");

        imagesLoc = directories.getString("images");
    }

    private JSONObject getConfig(Game game, JSONObject directories, JSONObject files, String reference) {
        return game.loadJSONObject(directories.getString(reference) + files.getString(reference));
    }

    public void loadLevel(Renderer renderer, int levelNum) {
        if (levelsLoc == null) 
            levelsLoc = levelData.getString("levelsLocation");
        if (levels == null)
            levels = levelData.getJSONArray("levels");
        
        JSONObject level = levels.getJSONObject(levelNum);

        int levelWidth = level.getInt("levelWidth");
        int levelHeight = level.getInt("levelHeight");
        renderer.setLevelSize(levelWidth, levelHeight);      
        
        String levelFile = level.getString("layout");
        try(BufferedReader reader = new BufferedReader(new FileReader(levelsLoc + levelFile))) {
            String line;
            int lineCount = 0;
            JSONObject references = levelData.getJSONObject("references");
            while ((line = reader.readLine()) != null) {
                
                String key;
                for (int i = 0; i < line.length(); i++) {
                    key = Character.toString(line.charAt(i));
                    if (i + 1 < line.length() && Character.isDigit(line.charAt(i + 1))) { // if next letter is a number, add to key avoid checking it on next iteration
                        key += line.charAt(i + 1);
                        i++;
                    }
                    String pngName = getPngName(references, key); 
                    renderer.updatelevelLayout(i, lineCount, imagesLoc + pngName); // when adding more folders to images/ will have to update
                    System.out.print(key);
                }
                System.out.println();
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