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

	@Override
	public void checkCollision(GameObject o) {
		if (this.getLocation().getX() == o.getLocation().getX() && this.getLocation().getY() == o.getLocation().getY()) {
			//if game object coordinates are same as monsters's
			//monsters's coordinates get inverted
			if (o instanceof Stationary) {
				if (!o.getClass().getSimpleName().equals("Wall")) {
					//tree or rock hits monster
					this.hp += 1;
				} else {
					getDisplacement().invert();
				}
			} else if (o instanceof Player) {
				double randomNum = Math.random();
				if (randomNum <= 0.5) {
					//player hits monster
						this.hp += 1;
				} 
			}
		}
	}
}