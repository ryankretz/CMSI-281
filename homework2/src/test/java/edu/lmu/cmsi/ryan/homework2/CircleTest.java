package edu.lmu.cmsi.ryan.homework2;
import edu.lmu.cmsi.ryan.homework2.Point;
import edu.lmu.cmsi.ryan.homework2.Rectangle;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CircleTest {
	
	@Test
	public void testGetters() {
		Point center = new Point(6.0, 6.0);
		Circle c = new Circle(center, 1.0);
		assertEquals("failure - didn't create circle with correct radius", 1.0, c.getRadius(), 0.0);
		assertEquals("failure - didn't create circle with correct diameter", 2.0, c.getDiameter(), 0.0);
		assertEquals("failure - didn't create circle with correct circumference", 2.0*Math.PI, c.getCircumference(), 0.0);
		assertEquals("failure - didn't create circle with correct area", 1.0*Math.PI, c.getArea(), 0.0);
		assertEquals("failure - didn't create circle with correct center point", true, c.getCenter().equalTo(center));
	}

	@Test
	public void testTranslate() {
		Point c1 = new Point(7.0, 7.0);
		Circle c = new Circle(c1, 5.0);
		c.translate(1.0, 1.0);
		Point c2 = new Point(8.0, 8.0);
		Circle newC = new Circle(c2, 5.0);
		Point center1 = c.getCenter();
		Point center2 = newC.getCenter();
		assertEquals("failure - didn't translate center point correctly", true, center1.equalTo(center2));
	}

	@Test
	public void containsTest() {
		Point c1 = new Point(3.0, 3.0);
		Circle c = new Circle(c1, 5.0);
		assertEquals("failure - didn't check if contains point correctly", true, c.containsPoint(new Point(4.0, 4.0)));
		assertEquals("failure - didn't check if contains point correctly", true, c.containsPoint(new Point(7.0, 3.0)));
	}

	@Test
	public void boundingRectTest() {
		Circle c = new Circle(new Point(10.0, 10.0), 3.0);
		Rectangle cRect = c.getBoundingRectangle();
		Point rectPoint = cRect.getTopLeft();
		Rectangle newR = new Rectangle(new Point(7.0, 7.0), 6.0, 6.0);
		Point newPoint = newR.getTopLeft();
		assertEquals("failure - didn't corectly find bounding rectangle", true, rectPoint.equalTo(newPoint));
	}
}











