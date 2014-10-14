package edu.lmu.cmsi.ryan.homework3.core;

public class Displacement {
	
	private int dx;
	private int dy;

	public Displacement(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public int getXDisplacement() {
		return this.dx;
	}

	public int getYDisplacement() {
		return this.dy;
	}

	public void invert() {
		this.dx = this.dx * -1;
		this.dy = this.dy * -1;
	}
}