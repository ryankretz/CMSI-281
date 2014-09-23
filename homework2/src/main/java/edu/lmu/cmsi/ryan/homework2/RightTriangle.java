package edu.lmu.cmsi.ryan.homework2;

public class RightTriangle {
	private Point topLeftCorner;
	private double base;
	private double height;
	private double area;
	private double perimeter;

	//creates right triangle based upon parameters specified
	public RightTriangle(Point topLeftCorner, double base, double height) {
		//checks to see if input is valid
		if (Double.isNaN(base) || base < 0 || Double.isNaN(height) || height < 0 ) {
			throw new IllegalArgumentException("Please make sure all constructor values are valid");
		}
		this.topLeftCorner = topLeftCorner;
		this.base = base;
		this.height = height;
	}

	//returns top left corner point
	public Point getTopLeft() {
		return this.topLeftCorner;
	}

	//returns the area of right triangle 
	public double getArea() {
		this.area = 0.5 * base * height;
		return this.area;
	}

	//return the perimeter of right triangle
	public double getPerimeter() {
		double c = Math.sqrt(base * base + height * height);
		this.perimeter = this.base + this.height + c;
		return this.perimeter;
	}

	//calculates the locations of the three points of the triangle. Then performs the cross product
	//between each point and a point of the triangle. If all the cross products are greater than zero or
	// less than zero, then the point is inside the traingle. Otherwise, it is out of the triangle
	public boolean containsPoint(Point p) {
		boolean contains = false;
		double upperX = this.getTopLeft().getX();
		double upperY = this.getTopLeft().getY();
		Point rTop = new Point(upperX, upperY);
		Point rBottom = new Point(upperX, upperY + this.height);
		Point rSide = new Point(upperX + this.base, upperY);
		double denom = (rBottom.getY() - rSide.getY())*(rTop.getX() - rSide.getX()) + ((rSide.getX() - rBottom.getX())*(rTop.getY() - rSide.getY()));
		double a = ((rBottom.getY()-rSide.getY())*(p.getX()- rSide.getX()) + (rSide.getX() - rBottom.getX())*(p.getY()-rSide.getY()))/denom;
		double b = ((rSide.getY()-rTop.getY())*(p.getX()- rSide.getX()) + (rTop.getX() - rSide.getX())*(p.getY()-rSide.getY()))/denom;
		double c = 1 - a - b;
		if ( 0 <= a && a <= 1 && 0 <= b && b <= 1 && 0 <= c && c <= 1) {
			contains = true;
		}
		return contains;
	}

	public void translate(double horiz, double vert) {
		Point newCord = new Point(this.topLeftCorner.getX() + horiz, this.topLeftCorner.getY() + vert);
		this.topLeftCorner = newCord;
	}

	public Rectangle getBoundingRectangle() {
		double boundingX = this.topLeftCorner.getX();
		double boundingY = this.topLeftCorner.getY();
		Point boundingRectP = new Point(boundingX, boundingY);
		double boundingBase = base;
		double boundingHeight = height;
		Rectangle boundingRect = new Rectangle(boundingRectP, boundingBase, boundingHeight);
		return boundingRect;
	}
}