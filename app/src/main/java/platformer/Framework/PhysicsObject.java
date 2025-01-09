package platformer.Framework;

import processing.core.PVector;

public interface PhysicsObject {

    void update(float deltaTime);

    // physics
    void setPos(PVector pos);
    PVector getPos();

    void setVel(PVector vel);
    PVector getVel();

    // other
    void setTouched(boolean[] touched);
    boolean[] getTouched(); // not used yet, but may be required for some interactions.

    // void setImageRef(String imageRef);
    String getImageRef();
}
