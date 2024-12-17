package platformer;

import java.util.ArrayList;
import java.util.List;

import processing.core.PVector;

public class PhysicsHandler {
    
    private List<PhysicsObject> physicsObjects = new ArrayList<>();
    private float gravity;

    PhysicsHandler(float gravity) {
        this.gravity = gravity;
    }

    public void addObject(PhysicsObject obj) {
        physicsObjects.add(obj);
    }

    public void update(float deltaTime) {
        for (PhysicsObject obj : physicsObjects) {
            PVector pos = obj.getPos();
            PVector vel = obj.getVel();
            
            // gravity
            vel.y += gravity;


            // apply vel
            pos.add(PVector.mult(vel, deltaTime));

            // update values
            obj.setPos(pos);
            obj.setVel(vel);
        }
    }
}
