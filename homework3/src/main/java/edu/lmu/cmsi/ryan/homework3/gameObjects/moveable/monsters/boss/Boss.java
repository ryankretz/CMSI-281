package edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.boss;

import edu.lmu.cmsi.ryan.homework3.gameObjects.*;
import edu.lmu.cmsi.ryan.homework3.core.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.things.*;


public abstract class Boss extends Moveable {

	//abstract boss constructor
	public Boss(int x, int y, int dx, int dy) {
		super(x, y, dx, dy);
	}

	//checks collision with game object (wall, rock, tree)
	//if coordinates are the same as a wall, the boss coordinates 
	//get inverted
	@Override
	public void checkCollision(GameObject o) {
		if (this.getLocation().getX() == o.getLocation().getX() && this.getLocation().getY() == o.getLocation().getY()) {
			//if game object coordinates are same as boss's
			if (o instanceof Stationary) {
				//if the object is stationary
				if (!o.getClass().getSimpleName().equals("Wall")) {
					//if its not a wall
					//tree or rock hits boss
					this.hp += 1;
				} else {
					//coordinates gets inverted if its a wall
					getDisplacement().invert();
				}
			}
			else if (o instanceof Player) {
				//if its a player
				double randomNum = Math.random();
				if (randomNum <= 0.3) {
					//player hits boss
					this.hp += 1;
				}
			}
		}
	}
}