package edu.lmu.cmsi.ryan.homework3.gameObjects;

import edu.lmu.cmsi.ryan.homework3.core.Coordinate;
import edu.lmu.cmsi.ryan.homework3.Iface.*;

public abstract class GameObject implements Render {
	private Coordinate location;

	public GameObject(int x, int y ){
		this.location = new Coordinate(x,y);
	}

	//return objects location
	public Coordinate getLocation() {
		return this.location;
	}

	//return objects x coord
	public int getX() {
		return this.location.getX();
	}

	//return objects y coord
	public int getY() {
		return this.location.getY();
	}
}