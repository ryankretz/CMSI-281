package edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.monsters.monsters2;

import edu.lmu.cmsi.ryan.homework3.gameObjects.*;
import edu.lmu.cmsi.ryan.homework3.core.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.moveable.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.things.*;


public abstract class Monster2 extends Moveable {

	public Monster2(int x, int y, int dx, int dy) {
		super(x, y, dx, dy);
	}

	@Override
	public void checkCollision(GameObject o) {
		if (this.getLocation().getX() == o.getLocation().getX() && this.getLocation().getY() == o.getLocation().getY()) {
			//if game object coordinates are same as monsters's
			//monsters's coordinates get inverted
			getDisplacement().invert();
			if (o instanceof Stationary) {
				if (!o.getClass().getSimpleName().equals("Wall")) {
					//tree or rock hits monster
					this.hp += 1;
				}
			}
			else {
				double randomNum = Math.random();
				if (o instanceof Monster2) {
					if (randomNum <= 0.5) {
						//player hits monster
						this.hp += 1;
					}
				} 
			}
		}
	}



/*
	//checks collision with game object (wall, rock, tree)
	//if coordinates are the same, the player coordinates 
	//get inverted
	@Override
	public void checkCollision(Stationary o) {
		if (this.getX() == o.getX() && this.getY() == o.getY()) {
			if (!o.getClass().getSimpleName().equals("Wall")) {
				this.hp += 1;
			}
			this.displacement.invert();
		}
	}

	//checks collision with player
	//if player hits monster, monster's hp is increased and coordinates
	//are inverted
	@Override
	public void checkCollision(Player p) {
		double randomNum = Math.random();
		if (this.getX() == p.getX() && this.getY() == p.getY()) {
			if (randomNum <= 0.5) {
				//monster gets hip by player
				this.hp += 1;
			}
			this.displacement.invert();
		}
	}
	*/
}