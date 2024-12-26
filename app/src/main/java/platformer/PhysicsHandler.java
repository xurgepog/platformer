package platformer;

import java.util.ArrayList;
import java.util.List;

import processing.core.PVector;

public class PhysicsHandler {
    
    private List<PhysicsObject> physicsObjects = new ArrayList<>();
    private float gravity;
    private float frictionCoeff; // change later, but for now will do
    
    private String imagesLoc;

    PhysicsHandler(float gravity) {
        this.gravity = gravity;
        frictionCoeff = 0.8f;
    }

    public void addObject(PhysicsObject obj) {
        physicsObjects.add(obj);
    }

    public void update(Renderer renderer, float deltaTime) {
        for (PhysicsObject obj : physicsObjects) {
            // dimensions
            String imageRef = obj.getImageRef();
            PVector dimensions = obj.getDimensions();
            if (dimensions == null) {
                dimensions = new PVector(renderer.getImage("/assets/images/" + imageRef).width, renderer.getImage("/assets/images/" + imageRef).height);
                obj.setDimensions(dimensions);
                System.out.println(dimensions.y);
            }

            // updating pos and vel
            PVector pos = obj.getPos();
            PVector vel = obj.getVel();
            
            // gravity
            if (!renderer.typeTouching((int) ((pos.x + dimensions.x) / 16), (int) ((pos.y + dimensions.y) / 16))) // for bottom middle of player (remove magic numbers later)
                vel.y += gravity; // fix index error if off screen??
            else
                vel.y = 0;
                if (vel.x != 0) vel.x *= frictionCoeff;

            // updating pos and vel
            pos.add(PVector.mult(vel, deltaTime));

            obj.setPos(pos);
            obj.setVel(vel);

            renderer.drawImage("/assets/images/" + imageRef, pos.x, pos.y);
        }
    }
}
