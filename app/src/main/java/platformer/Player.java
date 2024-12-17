package platformer;

import processing.core.PApplet;
import processing.core.PVector;

public class Player implements PhysicsObject {
    
    private PVector pos;
    private PVector vel;
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

    // public void update(float deltaTime) {
    //     pos.x += vel.x * deltaTime;
    // }

    public void draw(PApplet app) {
        app.rect(pos.x, pos.y, 50, 50);
    }

    // setters and getters
    @Override
    public void setPos(PVector pos) {
        this.pos = pos;
    }

    @Override
    public PVector getPos() {
        return pos;
    }

    @Override
    public void setVel(PVector vel) {
        this.vel = vel;
    }
    
    @Override
    public PVector getVel() {
        return vel;
    }
}
