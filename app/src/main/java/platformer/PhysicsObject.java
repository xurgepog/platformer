package platformer;

import processing.core.PVector;

public interface PhysicsObject {
    void setPos(PVector pos);
    PVector getPos();

    void setVel(PVector vel);
    PVector getVel();

    void setOnGround(boolean onGround);
    boolean getOnGround();

    void setDimensions(PVector dimensions);
    PVector getDimensions();

    void setImageRef(String imageRef);
    String getImageRef();
}
