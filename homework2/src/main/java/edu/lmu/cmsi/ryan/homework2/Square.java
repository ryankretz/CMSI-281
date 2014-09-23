package edu.lmu.cmsi.ryan.homework2;


public class Square {
	private Point topLeft;
	private double sideLength;
	private double area;
	private double perimeter;

	//creates a square based upon parameters
	public Square(Point p, double sideLength) {
		//checks to see if the sideLength parameter is valid 
		if (Double.isNaN(sideLength) || sideLength < 0) {
			throw new IllegalArgumentException("Please make sure all constructor values are valid");
		}
		this.topLeft = p;
		this.sideLength = sideLength;
	}

	//return top left point
	public Point getTopLeft() {
		return this.topLeft;
	}

	//returns the square area
	public double getArea() {
		this.area = sideLength * sideLength;
		return this.area;
	}

	//returns the square perimeter
	public double getPerimeter() {
		this.perimeter = sideLength * 4;
		return this.perimeter;
	}

	//contains means that if it lies inside, not on the edge
	//returns if a point is inside the rectangle
	//checks to see if the point passed in is between the x and y coordinates of the
	//the rectangle. If it is, then the point is inside the rectangle
	public boolean containsPoint(Point p) {
		double pointX = p.getX();
		double pointY = p.getY();
		boolean isIn = false;
		if (this.topLeft.getX() < pointX 
			&& pointX < this.topLeft.getX() + sideLength) {
			if (this.topLeft.getY() < pointY 
				&& pointY < this.topLeft.getY() + sideLength) {
				isIn = true;
				return isIn;
			}
		}
		return isIn;
	}

	//moves the top left point the desired distances
	//checks the parameters to make sure the translate values will not make the 
	//square go out of quadrant 1
	public void translate(double horiz, double vert) {
		double newX = this.topLeft.getX() + horiz;
		double newY = this.topLeft.getY() + vert;
		if (Double.isNaN(horiz) || Double.isNaN(vert) || newX < 0 || newY < 0) {
			throw new IllegalArgumentException("Please make sure all translate values are valid");
		} else {
		Point newCord = new Point(newX, newY);
		this.topLeft = newCord;
		}
	}

	//returns a rectangle that is the same rectangle as that is the smallest
	//bounding rectangle possible
	public Rectangle getBoundingRectangle() {
		double boundingX = this.topLeft.getX();
		double boundingY = this.topLeft.getY();
		Point boundingTopLeft = new Point(boundingX, boundingY);
		double boundingSideLength = this.sideLength;
		Rectangle boundingRect = new Rectangle(boundingTopLeft, boundingSideLength, boundingSideLength);
		return boundingRect;
	}
}