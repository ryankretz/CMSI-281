package edu.lmu.cmsi.ryan.homework3.gameObjects;

import edu.lmu.cmsi.ryan.homework3.core.*;
import edu.lmu.cmsi.ryan.homework3.gameObjects.*;

public abstract class Moveable extends GameObject {
	private Displacement displacement;
	protected int hp;

	public Moveable(int x, int y, int dx, int dy) {
		super(x, y);
		this.displacement = new Displacement(dx, dy);
		this.hp = 0;
	}

	//return objects displacement
	public Displacement getDisplacement() {
		return this.displacement;
	}

	//return moveable object's x displacement
	public int getXDisplacement() {
		return this.displacement.getXDisplacement();
	}

	//return moveable object's x displacement
	public int getYDisplacement() {
		return this.displacement.getYDisplacement();
	}

	//abstract checkCollision because all moveable objects need to
	//check their collision with other objects
	public abstract void checkCollision(GameObject o);

	//return moveable object's hp
	public int getHP() {
		return hp;
	}

	//updates moveable object's position
	public void update() {
    	this.getLocation().setX(this.getLocation().getX() + this.displacement.getXDisplacement());
    	this.getLocation().setY(this.getLocation().getY() + this.displacement.getYDisplacement());
  }
}

