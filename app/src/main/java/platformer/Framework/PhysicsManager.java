package platformer.Framework;

import java.util.ArrayList;
import java.util.List;

import platformer.Game;
import platformer.Wrappers.TouchingData;
import processing.core.PVector;

public class PhysicsManager {

    private FrameworkManager FWMan;
    
    private List<PhysicsObject> physicsObjects = new ArrayList<>();
    private float gravity;
    private float frictionCoeff;

    private final int LENIENCY = 5; // pixels into player that is still considered above or below
    private final int SQUISH = 5; // pixels player can walk into block on sides before stopping

    public PhysicsManager() {
        // load framwork manager
        FWMan = FrameworkManager.getFrameworkManager();
    }

    public void addObject(PhysicsObject obj) {
        physicsObjects.add(obj);
    }

    public void update(float deltaTime) {
        Renderer renderer = FWMan.getRenderer();

        for (PhysicsObject obj : physicsObjects) {
            
            // retrieving main variables
            PVector pos = obj.getPos();
            PVector vel = obj.getVel();
            String imageRef = obj.getImageRef();            

            // get tiles being touched
            TouchingData touching = renderer.typesTouching((int) pos.x, (int) pos.y, imageRef);
            List<String> touchingType = touching.getTouchingTypes();
            List<PVector> touchingPos = touching.getTouchingPos();
            PVector dimensions = touching.getDimensions();

            boolean touched[] = new boolean[4]; // up, down, left, right respectively
            int tileSize = renderer.getTileSize();
            for (int i = 0; i < touchingType.size(); i++) {
                if (touchingType.get(i).equals("ground")) {

                    PVector tile = new PVector(touchingPos.get(i).x, touchingPos.get(i).y);
                    
                    // System.out.println("pos.y: " + (pos.y + dimensions.y) + " yTouch: " + yTouch);

                    boolean topCheck = tile.y + tileSize - LENIENCY < pos.y;
                    boolean botCheck = tile.y + LENIENCY > pos.y + dimensions.y;
                    boolean edgeCheck = tile.x + 5 < pos.x + dimensions.x && tile.x + tileSize - 5 > pos.x; // look out for magic numbers, could also fail if fast

                    // top collision
                    if (topCheck && edgeCheck) {
                        touched[0] = true;
                    }

                    // bottom collision
                    if (botCheck && edgeCheck) {
                        touched[1] = true;
                    }

                    // if tile touched is to the sides, compare centre of object vs tile
                    if (!topCheck && !botCheck) {
                        // left collision
                        if (tile.x + (tileSize / 2) < pos.x + (dimensions.x / 2)) {
                            touched[2] = true;
                        }
                        
                        // right collision
                        if (tile.x + (tileSize / 2) > pos.x + (dimensions.x / 2)) {
                            touched[3] = true;
                        }
                    }
                }
            }
            obj.setTouched(touched);

            // stopping phasing part way through blocks
            for (int i = 0; i < touched.length; i++) {
                if (touched[i]) {
                    if (Math.abs(vel.y) > Math.abs(vel.x) && (i == 0 || i == 1)) {
                        if (pos.y % 16 != 0) {
                            if (vel.y > 0) pos.y = pos.y - (pos.y % 16);
                            else pos.y = pos.y + (16 - (pos.y % 16));
                        }
                    }
                    
                    break;
                }
            }
            

            // apply forces
            if (vel.y < 200) vel.y += gravity;
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

            obj.update(deltaTime); // maybe have a centralised updater later

            renderer.drawImage(imageRef, pos.x, pos.y);
        }
    }

    // setters and getters
    public void setPhysics(float gravity, float frictionCoeff) { // maybe use list as param laters
        this.gravity = gravity;
        this.frictionCoeff = frictionCoeff;
    }
}
