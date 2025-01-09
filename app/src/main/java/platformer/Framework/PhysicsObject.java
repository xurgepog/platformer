package platformer.Framework;

import processing.core.PVector;

public interface PhysicsObject {
    // physics
    void setPos(PVector pos);
    PVector getPos();

    void setVel(PVector vel);
    PVector getVel();

    // other
    void setTouched(boolean[] touched);
    boolean[] getTouched();

    // void setImageRef(String imageRef);
    String getImageRef();
}
