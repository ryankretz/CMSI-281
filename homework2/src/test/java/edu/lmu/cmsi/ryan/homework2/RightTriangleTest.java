package edu.lmu.cmsi.ryan.homework2;
import edu.lmu.cmsi.ryan.homework2.Point;
import edu.lmu.cmsi.ryan.homework2.Rectangle;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class RightTriangleTest {

	@Test
	public void testGetters() {
		RightTriangle r = new RightTriangle(new Point(5.0, 5.0), 4.0, 3.0);
		Point rTop = r.getTopLeft();
		Point topLeft = new Point(5.0, 5.0);
		double c = Math.sqrt(3.0*3.0 + 4.0 * 4.0);
		double perim = c + 3.0 + 4.0;
		assertEquals("failure - did not return top left corner point", true, rTop.equalTo(topLeft));
		assertEquals("failure - did not calculate area correctly", 0.5*3.0*4.0, r.getArea(), 0);
		assertEquals("failure - did not calculate perimeter correctly", perim, r.getPerimeter(), 0);
	}

	@Test
	public void testContains() {
		RightTriangle tri = new RightTriangle(new Point(4.0, 5.0), 10.0, 10.0);
		Point inside = new Point(6.0, 6.0);
		Point outside = new Point(100.0, 100.0);
		assertEquals("failure - did not check for contains point correctly", true, tri.containsPoint(inside));
		assertEquals("failure - did not check for contains point correctly", false, tri.containsPoint(outside));
	}

	@Test
	public void testTranslate() {
		RightTriangle r = new RightTriangle(new Point(5.0, 5.0), 3.0, 4.0);
		Point rTop = r.getTopLeft();
		r.translate(1.0, 1.0);
		RightTriangle r2 = new RightTriangle(new Point(6.0,6.0), 3.0, 4.0);
		assertEquals("failure - didn't translate top left point correctly", true, r.getTopLeft().equalTo(r2.getTopLeft()));
	}

	@Test
	public void testBoundingRect() {
		RightTriangle r = new RightTriangle(new Point(5.0, 5.0), 3.0, 4.0);
		Point topLeft = r.getBoundingRectangle().getTopLeft();
		assertEquals("failure - didn't find the correct bounding rectangle", true, topLeft.equalTo(new Point(5.0, 5.0)));
	}
}