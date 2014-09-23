package edu.lmu.cmsi.ryan.homework2;


public class Rectangle {
	private Point topLeft;
	private double height;
	private double width;
	private double area;
	private double perimeter;

	//creates a rectangle based upon parameters
	public Rectangle(Point topLeft, double height, double width) {
		//checks to see if the side lengths parameters are valid 
		if (Double.isNaN(height) || height < 0 || Double.isNaN(width) || width < 0 ) {
			throw new IllegalArgumentException("Please make sure all constructor values are valid");
		}
		this.topLeft = topLeft;
		this.height = height;
		this.width = width;
	}

	//return topLeft point
	public Point getTopLeft() {
		return this.topLeft;
	}

	//returns rectangle area
	public double getArea() {
		this.area = height * width;
		return this.area;
	}

	//returns rectangle perimeter
	public double getPerimeter() {
		this.perimeter = height * 2 + width * 2;
		return this.perimeter;
	}

	//returns if a point is inside the rectangle
	//checks to see if the point passed in is between the x and y coordinates of the
	//the rectangle. If it is, then the point is inside the rectangle
	public boolean containsPoint(Point p) {
		double pointX = p.getX();
		double pointY = p.getY();
		boolean isIn = false;
		if (this.topLeft.getX() < pointX 
			&& pointX < this.topLeft.getX() + width) {
			if (this.topLeft.getY() < pointY 
				&& pointY < this.topLeft.getY() + height) {
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
		double boundingHeight = this.height;
		double boundingWidth = this.width;
		Rectangle boundingRect = new Rectangle(boundingTopLeft, boundingHeight, boundingWidth);
		return boundingRect;
	}
	
}