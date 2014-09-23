package edu.lmu.cmsi.ryan.homework2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PointTest {
	
	@Test
	public void testGetters() {
		Point p = new Point(4.0, 6.0);
		assertEquals("failure - point did not set x value correctly", 4.0, p.getX(), 0.0);
		assertEquals("failure - point did not set y value correctly", 6.0, p.getY(), 0.0);
	}

	@Test
	public void testEqualTo() {
		Point p = new Point(3.0, 5.0);
		Point r = new Point(3.0,5.0);
		assertEquals("failure- same points do not equal", p, p);
		assertEquals("failure- created same point but not equal", true, p.equalTo(r));
		assertEquals("failure- equalTo method does not recognize equal points", true, p.equalTo(p));
	}

	@Test
	public void crossProduct() {
		Point p = new Point(3.0, 5.0);
		Point r = new Point(4.0,6.0);
		double cross = p.crossProduct(r);
		double calcCross = p.getX()*r.getY() - p.getY()*r.getX();
		assertEquals("failure - didn't calculate cross product correctly", calcCross, cross, 0);
	}

	@Test
	public void testDistanceTo() {
		Point p = new Point(2.0, 4.0);
		Point r = new Point(8.0, 4.0);
		assertEquals("failure - distance calculated is incorrect",  6.0, p.distanceTo(r), 0.0);
		assertEquals("failure - distance calculated is incorrect",  6.0, r.distanceTo(p), 0.0);
	}
}