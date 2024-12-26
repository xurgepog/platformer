package platformer;

import processing.core.PVector;

public class Player implements PhysicsObject {
    
    private PVector pos;
    private PVector vel;
    private float speed;

    private boolean onGround;
    private PVector dimensions;
    private String imageRef;

    public Player(float x, float y, float speed, String imageRef) {
        pos = new PVector(x, y);
        vel = new PVector(0, 0);
        this.speed = speed;
        this.imageRef = imageRef;
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

    public void jump() {
        if (onGround) vel.y -= 20;
    }

    // setters and getters
    // pos
    @Override
    public void setPos(PVector pos) {
        this.pos = pos;
    }
    @Override
    public PVector getPos() {
        return pos;
    }

    // vel
    @Override
    public void setVel(PVector vel) {
        this.vel = vel;
    }
    @Override
    public PVector getVel() {
        return vel;
    }

    // onGround
    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }
    public boolean getOnGround() {
        return onGround;
    }

    // dimensions
    public void setDimensions(PVector dimensions) {
        this.dimensions = dimensions;
    }
    public PVector getDimensions() {
        return dimensions;
    }

    // imageRef
    @Override
    public void setImageRef(String imageRef) {
        this.imageRef = imageRef;
    }
    @Override
    public String getImageRef() {
        return imageRef;
    }
}
