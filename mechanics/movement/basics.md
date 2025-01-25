# Basic Movement 

## Requirements
- The player can move left and right using keyboard input.
- Gravity will naturally pull the player downward unless they are standing on a surface.
- The player will stop falling when colliding with the ground.
- Jumping will allow the player to ascend for a fixed height, then fall back down.

## Break Down
### Left and Right walking
- Trigger: 'A' and 'D' keys.
- Behaviour: For now, move left or right at a fixed velocity.

### Collision - with default tile
- Edge pixels don't flag above or below
- If top or below flagged, don't check some tile for side collision.
- If inside a tile push player out in opposite direction of current movement. This is since the movement that placed player in the tile tells us where they should have ended up.

### Jumping
- On ground. When jump wait until in air, then landed on ground again to allow another jump.
- This is since if jumps are allowed for all frames on ground, can be stacked.

### Dashing
- Planning on making dash increase velocity for a set amount of time.
- Disables forces while dashing

### Friction - part of collision? - have file just for collisions?
- For now a constant friction force is always applied. Later will make it so depending on tile touching, applied different frictions.
- Maybe apply to walls as well? Terraria bear class looking ahh sliding.

### Camera movement
- Lag camera a bit behind player. Speed up based on distance from player.
- Calculate where camera should be, then move all tiles based on that. Since no actual camera movement in processing to my knowledge.

### Framework - maybe instead of just having mechanics, include all finalised decisions - proof of concept?? - just show ideas were intentional
### Breakdown - in main folder of all breakdowns

## Psuedocode
### Left and Right walking
- On 'A' press set player velocity to -speed
- On 'D' press set player velocity to speed