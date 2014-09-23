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
		Point rTop = this.getTopLeft();
		Point rBottom = new Point(this.getTopLeft().getX(), this.getTopLeft().getY()+ this.height);
		Point rSide = new Point(this.getTopLeft().getX() + this.base, this.getTopLeft().getY());
		double crossTB = rTop.crossProduct(p);
		double crossTS = rBottom.crossProduct(p);
		double crossBS = rSide.crossProduct(p);
		if ((crossTB > 0 && crossTS > 0 && crossBS > 0) || (crossTB < 0 && crossTS < 0 && crossBS < 0)) {
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