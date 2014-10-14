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

	@Override
	public void checkCollision(GameObject o) {
		if (this.getLocation().getX() == o.getLocation().getX() && this.getLocation().getY() == o.getLocation().getY()) {
			//if game object coordinates are same as boss's
			//boss's coordinates get inverted
			if (o instanceof Stationary) {
				if (!o.getClass().getSimpleName().equals("Wall")) {
					//tree or rock hits boss
					this.hp += 1;
				} else {
					getDisplacement().invert();
				}
			}
			else if (o instanceof Player) {
				double randomNum = Math.random();
				if (randomNum <= 0.3) {
					//player hits boss
					this.hp += 1;
				}
			}
		}
	}
}