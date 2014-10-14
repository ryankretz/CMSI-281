package edu.lmu.cmsi.ryan.homework3.gameObjects.moveable;

import edu.lmu.cmsi.ryan.homework3.gameObjects.*;
import edu.lmu.cmsi.ryan.homework3.core.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.things.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.boss.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.monsters1.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.monsters2.*;


public class Player extends Moveable {

	public Player(int x, int y, int dx, int dy) {
		super(x,y,dx,dy);
	}

	//returns player's character
	@Override 
	public char getRenderedCharacter() {
		return 'p';
	}

	//checks collision with game object (wall, rock, tree)
	//if coordinates are the same as a wall, the player coordinates 
	//get inverted
	@Override
	public void checkCollision(GameObject o) {
		if (this.getLocation().getX() == o.getLocation().getX() && this.getLocation().getY() == o.getLocation().getY()) {
			//if game object coordinates are same as player's
			if (o instanceof Stationary) {
				//if the object is stationary
				if (!o.getClass().getSimpleName().equals("Wall")) {
					//if its not a wall
					//tree or rock hits player
					this.hp += 1;
				} else {
					//coordinates get inverted if its a wall
					getDisplacement().invert();
				}
			}
			else {
				double randomNum = Math.random();
				if (o instanceof Monster1) {
					//if its a monster1
					if (randomNum <= 0.5) {
						//monster hits player
						this.hp += 1;
					}
				} else if (o instanceof Monster2) {
					//if its a monster2
					if (randomNum <= 0.6) {
						//monster hits player
						this.hp += 1;
					}
				} else if (o instanceof Boss) {
					//if its a boss
					if (randomNum <= 0.7) {
						//boss hits player
						this.hp += 1;
					}
				}
			}
		}
	}
}


