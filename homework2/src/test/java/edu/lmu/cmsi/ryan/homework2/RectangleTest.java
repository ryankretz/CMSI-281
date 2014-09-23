package edu.lmu.cmsi.ryan.homework2;
import edu.lmu.cmsi.ryan.homework2.Point;
import edu.lmu.cmsi.ryan.homework2.Rectangle;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class RectangleTest {
		
	@Test
	public void testGetters() {
		Rectangle s = new Rectangle(new Point(10.0, 10.0), 2.0, 4.0);
		assertEquals("failure- didn't set area correctly", 8.0, s.getArea(), 0.0);
		assertEquals("failure- didn't set perimeter correctly", 12.0, s.getPerimeter(), 0.0);
	}

	@Test
	public void containsTest() {
		Rectangle s = new Rectangle(new Point(10.0, 10.0), 2.0, 4.0);
		Point p = new Point(11.0, 11.0);
		assertEquals("failure - didn't check contains point correctly", s.containsPoint(p), true);
	}

	@Test
	public void translateTest() {
		Rectangle s = new Rectangle(new Point(10.0, 10.0), 2.0, 4.0);
		s.translate(1.0, 1.0);
		Rectangle s2 = new Rectangle(new Point(11.0,11.0), 2.0, 4.0);
		assertEquals("failure - didn't translate top left point correctly", true, s.getTopLeft().equalTo(s2.getTopLeft()));
	}

	@Test
	public void boundingRectTest() {
		Rectangle s = new Rectangle(new Point(10.0, 10.0), 2.0, 4.0);
		Rectangle s1 = s.getBoundingRectangle();
		Rectangle s2 = new Rectangle(new Point(10.0, 10.0), 2.0, 4.0);
		assertEquals("failure- didn't find expected bounding rectangle", true, s1.getTopLeft().equalTo(s2.getTopLeft()));
	}


}