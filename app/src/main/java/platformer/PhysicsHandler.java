package platformer;

import java.util.ArrayList;
import java.util.List;

public class PhysicsHandler {
    private List<GameObject> gameObjects = new ArrayList<>();

    public void addObject(GameObject obj) {
        gameObjects.add(obj);
    }

    public void update(float deltaTime) {
        for (GameObject obj : gameObjects) {
            obj.update(deltaTime);
        }
    }
}
