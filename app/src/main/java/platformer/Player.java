package platformer;

import processing.core.PApplet;
import processing.core.PVector;

public class Player extends GameObject {

    private float speed;

    public Player(float x, float y, float speed) {
        pos = new PVector(x, y);
        vel = new PVector(0, 0);
        this.speed = speed;
    }

    public void moveLeft() {
        vel.x = -speed;
    }

    public void moveRight() {
        vel.x = speed;
    }

    public void stopMoving() {
        vel.x = 0;
    }

    public void update(float deltaTime) {
        pos.x += vel.x;
    }

    public void draw(PApplet app) {
        app.rect(pos.x, pos.y, 50, 50);
    }
}
