package edu.lmu.cmsi.ryan.homework2;

public class Point {
	private double x;
	private double y;
	
	//Creates a point based upon x and y input coordinates
	public Point(double x, double y) {
		//check if inputs are valid
		if (Double.isNaN(x) || Double.isNaN(y) || x < 0 || y < 0) {
			throw new IllegalArgumentException("Please make sure all constructor values are valid");
		}
		this.x = x;
		this.y = y;
	}

	//returns x coordinate
	public double getX() {
		return this.x;
	}

	//returns y coordinate
	public double getY() {
		return this.y;
	}

	//returns the cross product of two points
	public double crossProduct(Point p) {
		double cross = this.getX()* p.getY() - this.getY()* p.getX();
		return cross;
	}

	//distanceTo takes in a point as a parameter and returns
	//the distance from one point to another specified point
	public double distanceTo(Point p) {
		return Math.sqrt((this.y-p.y)*(this.y-p.y) + (this.x-p.x)*(this.x-p.x));
	}

	//equalTo takes in a point as a parameter and calls distanceTo method to see what the distance is. If it is
	//istanceTo method to see what the distance is. If it is
	//0, then the points are equal. If it is not 0, then it is 
	//not equal to 
	public boolean equalTo(Point p) {
		if (this.distanceTo(p) == 0) {
			return true;
		}
		else {
			return false;
		}
	}
}