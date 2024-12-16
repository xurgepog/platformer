package platformer;

import processing.core.PVector;

public abstract class GameObject {
    protected PVector pos;
    protected PVector vel;

    public abstract void update(float deltaTime);
}
