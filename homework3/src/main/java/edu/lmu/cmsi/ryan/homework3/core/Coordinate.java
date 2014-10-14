package edu.lmu.cmsi.ryan.homework3.core;

public class Coordinate {
	private int x;
	private int y;

	public Coordinate(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int x) {
		 this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

}