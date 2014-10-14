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
	//if coordinates are the same, the player coordinates 
	//get inverted
	@Override
	public void checkCollision(GameObject o) {
		if (this.getLocation().getX() == o.getLocation().getX() && this.getLocation().getY() == o.getLocation().getY()) {
			//if game object coordinates are same as player's
			//player's coordinates get inverted
			getDisplacement().invert();
			if (o instanceof Stationary) {
				if (!o.getClass().getSimpleName().equals("Wall")) {
					//tree or rock hits player
					this.hp += 1;
				}
			}
			else {
				double randomNum = Math.random();
				if (o instanceof Monster1) {
					if (randomNum <= 0.5) {
						//monster hits player
						this.hp += 1;
					}
				} else if ( o instanceof Monster2) {
					if (randomNum <= 0.6) {
						//monster hits player
						this.hp += 1;
					}
				} else if (o instanceof Boss) {
					if (randomNum <= 0.7) {
						//boss hits player
						this.hp += 1;
					}
				}
			}
		}
	}

/*
	//checks collision with monsters a and s
	//if monster hits player, player's hp is increased and coordinates
	//are inverted
	@Override
	public void checkCollision(Monster2 m) {
		double randomNum = Math.random();
		if (this.getX() == m.getX() && this.getY() == m.getY()) {
			if (randomNum <= 0.6) {
				//player gets hit by monter
				this.hp += 1;
			}
			this.displacement.invert();
		}
	}

	//checks collision with boss o and k
	//if boss hits player, player's hp is increased and coordinates
	//are inverted
	@Override
	public void checkCollision(Boss b) {
		double randomNum = Math.random();
		if (this.getX() == b.getX() && this.getY() == b.getY()) {
			if (randomNum <= 0.7) {
				//player gets hit by boss
				this.hp += 1;
			}
			this.displacement.invert();
		}
	}

	//checks collision with monsters z and x
	//if monster hits player, player's hp is increased and coordinates
	//are inverted
	@Override
	public void checkCollision(Monster1 m) {
		double randomNum = Math.random();
		if (this.getX() == m.getX() && this.getY() == m.getY()) {
			if (randomNum <= 0.5) {
				//player gets hit by monter
				this.hp += 1;
			}
			this.displacement.invert();
		}
	}
	*/	
}


