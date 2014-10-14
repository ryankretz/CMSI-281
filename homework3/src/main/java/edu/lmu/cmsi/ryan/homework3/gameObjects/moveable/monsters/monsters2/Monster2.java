package edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.monsters2;

import edu.lmu.cmsi.ryan.homework3.gameObjects.*;
import edu.lmu.cmsi.ryan.homework3.core.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.things.*;


public abstract class Monster2 extends Moveable {

	//abstract constructor of monster2
	public Monster2(int x, int y, int dx, int dy) {
		super(x, y, dx, dy);
	}

	//checks collision with game object (wall, rock, tree)
	//if coordinates are the same as a wall, the monster2 coordinates 
	//get inverted
	@Override
	public void checkCollision(GameObject o) {
		if (this.getLocation().getX() == o.getLocation().getX() && this.getLocation().getY() == o.getLocation().getY()) {
			//if game object coordinates are same as monster2's
			if (o instanceof Stationary) {
				if (!o.getClass().getSimpleName().equals("Wall")) {
					//if its not a wall
					//tree or rock hits monser2
					this.hp += 1;
				} else {
					//coordinates get inverted if its a wall
					getDisplacement().invert();
				}
			} else if (o instanceof Player) {
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