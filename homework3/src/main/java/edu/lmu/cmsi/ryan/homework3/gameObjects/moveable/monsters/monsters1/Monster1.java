package edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.monsters1;

import edu.lmu.cmsi.ryan.homework3.gameObjects.*;
import edu.lmu.cmsi.ryan.homework3.core.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.things.*;


public abstract class Monster1 extends Moveable {

	//abstract constructor for monster1
	public Monster1(int x, int y, int dx, int dy) {
		super(x, y, dx, dy);
	}

	//checks collision with game object (wall, rock, tree)
	//if coordinates are the same as a wall, the monster1 coordinates 
	//get inverted
	@Override
	public void checkCollision(GameObject o) {
		if (this.getLocation().getX() == o.getLocation().getX() && this.getLocation().getY() == o.getLocation().getY()) {
			//if game object coordinates are same as monster1's
			if (o instanceof Stationary) {
				if (!o.getClass().getSimpleName().equals("Wall")) {
					//if its not a wall
					//tree or rock hits monser1
					this.hp += 1;
				} else {
					//coordinates gets inverted if its a wall
					getDisplacement().invert();
				}
			}
			else if (o instanceof Player) {
				//if its a player
				double randomNum = Math.random();
				if (randomNum <= 0.5) {
					//player hits monster
					this.hp += 1;
				}
			}
		}
	}
}