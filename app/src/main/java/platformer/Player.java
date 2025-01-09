package platformer;

import platformer.Framework.PhysicsObject;
import processing.core.PVector;

public class Player implements PhysicsObject {

    // constants - delegate to config later
    private final float SPEED = 100;
    private final String IMAGE_REF = "player";
    
    // core values
    private PVector pos;
    private PVector vel;

    // other
    private boolean[] touched;

    public Player(float x, float y) {
        pos = new PVector(x, y);
        vel = new PVector(0, 0);

        touched = new boolean[4]; // up, down, left, right respectively
    }

    // apply movement
    public void moveLeft() {
        vel.x = -SPEED;
    }
    public void moveRight() {
        vel.x = SPEED;
    }
    public void jump() {
        if (touched[1]) vel.y -= 60;
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
    public void setTouched(boolean[] touched) {
        this.touched = touched;
    }
    public boolean[] getTouched() {
        return touched;
    }

    // imageRef
    // @Override - until handled by config is left constant therefore no setting
    // public void setImageRef(String imageRef) {
    //     this.IMAGE_REF = imageRef;
    // }
    @Override
    public String getImageRef() {
        return IMAGE_REF;
    }
}
