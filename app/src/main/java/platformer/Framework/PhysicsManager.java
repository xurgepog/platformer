package platformer.Framework;

import java.util.ArrayList;
import java.util.List;

import platformer.Game;
import platformer.Wrappers.TouchingData;
import processing.core.PVector;

public class PhysicsManager {
    
    private List<PhysicsObject> physicsObjects = new ArrayList<>();
    private float gravity;
    private float frictionCoeff;

    private final int LENIENCY = 10; // how many pixels of the players bottom and top counts as below and above

    public void addObject(PhysicsObject obj) {
        physicsObjects.add(obj);
    }

    public void update(Game game, Renderer renderer, float deltaTime) {
        for (PhysicsObject obj : physicsObjects) {
            
            // retrieving main variables
            PVector pos = obj.getPos();
            PVector vel = obj.getVel();
            String imageRef = obj.getImageRef();            

            // get tiles being touched
            TouchingData touching = renderer.typesTouching(game, (int) pos.x, (int) pos.y, imageRef);
            List<String> touchingType = touching.getTouchingTypes();
            List<PVector> touchingPos = touching.getTouchingPos();
            PVector dimensions = touching.getDimensions();

            boolean touched[] = new boolean[4]; // up, down, left, right respectively
            for (int i = 0; i < touchingType.size(); i++) {
                if (touchingType.get(i).equals("ground")) {
                    float yTouch = touchingPos.get(i).y;
                    float xTouch = touchingPos.get(i).x;
                    // System.out.println("pos.y: " + (pos.y + dimensions.y) + " yTouch: " + yTouch);
                    if (pos.y + LENIENCY > yTouch) {
                        touched[0] = true;
                    }
                    if (pos.y + dimensions.y - LENIENCY < yTouch) {
                        touched[1] = true;
                        if (pos.y != yTouch - dimensions.y) {
                            pos.y = yTouch - dimensions.y; // used to stop player falling partway through block
                            break;
                        }
                    }
                    if (pos.x > xTouch && pos.y + dimensions.y != yTouch) {
                        touched[2] = true;
                    }
                    if (xTouch > pos.x && pos.y + dimensions.y != yTouch) {
                        touched[3] = true;
                        // pos.x = xTouch - dimensions.x;
                    }
                }
            }
            obj.setTouched(touched);

            // apply forces
            vel.y += gravity;
            vel.x *= frictionCoeff; // apply friction (same in air and on ground for now)

            // stop movement in certain directions
            if (touched[0] && vel.y < 0) vel.y = 0;
            if (touched[1] && vel.y > 0) vel.y = 0;
            if (touched[2] && vel.x < 0) vel.x = 0;
            if (touched[3] && vel.x > 0) vel.x = 0;

            // update object's variables
            pos.add(PVector.mult(vel, deltaTime));

            obj.setPos(pos);
            obj.setVel(vel);

            renderer.drawImage(game, imageRef, pos.x, pos.y);
        }
    }

    // setters and getters
    public void setPhysics(float gravity, float frictionCoeff) { // maybe use list as param laters
        this.gravity = gravity;
        this.frictionCoeff = frictionCoeff;
    }
}
