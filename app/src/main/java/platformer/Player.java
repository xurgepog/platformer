package platformer;

import processing.core.PVector;

public class Player {


    // constants - delegate to config later
    private final float SPEED = 100;
    private final String IMAGE_REF = "player";
    private final float DASH_TIME = 0.5f;
    
    // core values
    private PVector pos;
    private PVector vel;

    // other
    private boolean[] touched;

    private boolean jumped;

    private boolean dashed;
    private boolean dashing;
    private float dashTimer;

    // temp / testing
    private boolean[] wasd;

    public Player(float x, float y) {
        pos = new PVector(x, y);
        vel = new PVector(0, 0);

        touched = new boolean[4]; // up, down, left, right respectively


        jumped = false;

        dashing = false;
        dashTimer = DASH_TIME;
        dashed = false;

        // temp / testing
        wasd = new boolean[4];
    }

    public void update(float deltaTime) {
        if (!touched[1]) jumped = false;
        if (touched[1]) dashed = false;

        if (dashing) {
            dashTimer -= deltaTime;
            if (dashTimer <= 0) {
                dashing = false;
            }
            else {
                int dashPower = 200;
                if (wasd[0] && vel.y > -dashPower) vel.y = -dashPower;
                if (wasd[1] && vel.x > -dashPower) vel.x = -dashPower;
                if (wasd[2] && vel.y < dashPower) vel.y = dashPower;
                if (wasd[3] && vel.x < dashPower) vel.x = dashPower;
            }
        }
    }

    // apply movement
    public void moveLeft() {
        if (vel.x > -SPEED) vel.x = -SPEED;
    }
    public void moveRight() {
        if (vel.x < SPEED) vel.x = SPEED;
    }
    // public void stopMoving() {
    //     vel.x *= 0.8; // magic number!!
    // }
    public void jump() {
        if (touched[1] && !jumped) {
            vel.y -= 150;
            jumped = true;
        }
    }
    public void dash(boolean[] wasd) {
        if (!dashed && !dashing) {
            vel.x = 0;
            vel.y = 0;
            this.wasd = wasd;
            dashed = true;
            dashing = true;
            dashTimer = DASH_TIME;
        }
    }

    // setters and getters
    // pos
    public void setPos(PVector pos) {
        this.pos = pos;
    }
    public PVector getPos() {
        return pos;
    }

    // vel
    public void setVel(PVector vel) {
        this.vel = vel;
    }
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
    public String getImageRef() {
        return IMAGE_REF;
    }
}
