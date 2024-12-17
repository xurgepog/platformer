package platformer;

import processing.core.PVector;

public interface PhysicsObject {
    void setPos(PVector pos);
    PVector getPos();

    void setVel(PVector vel);
    PVector getVel();
}
