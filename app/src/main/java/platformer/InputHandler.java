package platformer;

public class InputHandler {
    
    private final boolean[] keys = new boolean[128];

    public void keyPressed(char key) {
        if (key < keys.length) {
            keys[key] = true;
        }
    }

    public void keyReleased(char key) {
        if (key < keys.length) {
            keys[key] = false;
        }
    }

    public boolean isKeyPressed(char key) {
        return key < keys.length && keys[key];
    }
}
