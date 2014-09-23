package edu.lmu.cmsi.ryan.homework2;

public class LineSegment {
	private Point a;
	private Point b;

	//creatse a LineSegment based upon two input points
	public LineSegment(Point a, Point b) {
		//check if input is valid
		this.a = a;
		this.b = b;
	}

	//return start point
	public Point getStartPoint() {
		return this.a;
	}

	//return end point
	public Point getEndPoint() {
		return this.b;
	}

	//segmentLength calls distanceTo in order to find the
	//distance between the two points of the line, which is
	//the length
	public double segmentLength() {
		double distance = this.a.distanceTo(this.b);
		return distance;
	}

	//returns max of x values of line
	public double getMaxX() {
		return Math.max(this.a.getX(), this.b.getX());
	}

	//returns min of x values of line
	public double getMinX() {
		return Math.min(this.a.getX(), this.b.getX());
	}

	//returns max of y values of line
	public double getMaxY() {
		return Math.max(this.a.getY(), this.b.getY());
	}

	//returns min of y values of line
	public double getMinY() {
		return Math.min(this.a.getY(), this.b.getY());
	}

	//getMidPoint takes in a line segment as a parameter and gets
	//the two points associated with it. It then calculates the
	//average (midpoint) of the x and y values respectively. It then
	//creates and returns a new point with the midpoint values 
	//as the parameters
	public Point getMidPoint() {
		Point one = this.a;
		Point two = this.b;
		double x = (one.getX() + two.getX())/2;
		double y = (one.getY() + two.getY())/2;
		Point mid = new Point(x,y);
		return mid;
	}

	//method takes in a line segment as a parameter and gets the 
	//two points associated with it. It then checks to see if 
	//the points are equal to the two points of the other line. 
	//If both points are equal, it returns true. Otherwise, it
	//returns false
	public boolean equalTo(LineSegment l) {
		Point one = l.a;
		Point two = l.b;
		boolean isEqual = false;
		if (this.a.equalTo(one)) {
			if (this.b.equalTo(two)) {
				isEqual = true;
				return isEqual;
			} else {
				return isEqual;
			}
		} else if (this.a.equalTo(two)) {
			if (this.b.equalTo(one)) {
				isEqual = true;
				return isEqual;
			} else {
				return isEqual;
			}
		}
		return isEqual;
	}

	//**********figure out how to find if they intersect
	public boolean intersectsWith(LineSegment l) {
			boolean intersect = true;
			double x1 = this.a.getX();
			double y1 = this.a.getY();
			double x2 = this.b.getX();
			double y2 = this.b.getY();
			double x3 = l.a.getX();
			double y3 = l.a.getY();
			double x4 = l.b.getX();
			double y4 = l.b.getY();
			double parallel = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
			if (parallel == 0) {
				intersect = false;
			} else {
				double xNum = (x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4);
				double yNum = (x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4);
				double xPoint = xNum / parallel;
				double yPoint = yNum / parallel;
				if ( xPoint < this.getMinX() || this.getMaxX() < xPoint) {
					intersect = false;
					return intersect;
				} else if ( yPoint < this.getMinY() || this.getMaxY() < yPoint) {
					intersect = false;
					return intersect;
				} else if ( xPoint < l.getMinX() || l.getMaxX() < xPoint) {
					intersect = false;
					return intersect;
				} else if ( yPoint < l.getMinY() || l.getMaxY() < yPoint) {
					intersect = false;
					return intersect;
				}
			}
			return intersect;
	}

}

