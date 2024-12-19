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

## Psuedocode
### Left and Right walking
- On 'A' press set player velocity to -speed
- On 'D' press set player velocity to speed