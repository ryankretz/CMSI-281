package edu.lmu.cmsi.ryan.homework2;


public class Circle {
	private Point centerP;
	private double radius;
	private double diameter;
	private double circumference;
	private double area;


	//creates circle based upon parameters
	public Circle(Point center, double radius) {
		//check to make sure input is valid
		if (Double.isNaN(radius) || radius < 0) {
			throw new IllegalArgumentException("Please make sure all constructor values are valid");
		}
		this.centerP = center;
		this.radius = radius;
	}

	//returns circle center point
	public Point getCenter() {
		return this.centerP;
	}

	//return circle radius
	public double getRadius() {
		return this.radius;
	}

	//return circle diameter
	public double getDiameter() {
		this.diameter = this.getRadius()*2;
		return this.diameter;
	}

	//return circle circumference
	public double getCircumference() {
		this.circumference = diameter * Math.PI;
		return this.circumference;
	}

	//return circle area
	public double getArea() {
		this.area = Math.PI * radius * radius;
		return this.area;
	}

	//translates a circle point based upon parameters
	//checks to see if parameters are valid and checks if translate values will
	//produce a circle thats not in quadrant 1. If the parameters pass
	//these test, then a circle is created
	public void translate(double horiz, double vert) {
		double newX = this.centerP.getX() + horiz;
		double newY = this.centerP.getY() + vert;
		if (Double.isNaN(horiz) || Double.isNaN(vert) || newX < 0 || newY < 0) {
			throw new IllegalArgumentException("Please make sure all translate values are valid");
		} else {
		Point newCord = new Point(newX, newY);
		this.centerP = newCord;
		}
	}

	//returns a rectangle that bounds the circle by making a point that is the distance
	//of the raidus away. It then creates the rectangle with that point as the top left
	//and side lengths that are twice as long as the raidus 
	public Rectangle getBoundingRectangle() {
		double boundingX = this.centerP.getX() - radius;
		double boundingY = this.centerP.getY() - radius;
		Point boundingTopLeft = new Point(boundingX, boundingY);
		double boundingSideLength = radius * 2 + 10;
		Rectangle boundingRect = new Rectangle(boundingTopLeft, boundingSideLength, boundingSideLength);
		return boundingRect;
	}

	//returns whether the point is inside the circle or not. It checks if the distance 
	//from the point to the parameter point is less than the radius. If the distance
	//is less than the radius, the point is in. Otherwise, it is out.
	//contains means inside, not on edge
	public boolean containsPoint(Point p) {
		double distance = this.centerP.distanceTo(p);
		boolean isIn = false;
		if (distance < radius) {
			isIn = true;
			return isIn;
		} else {
			return isIn;
		}
	}
	
}