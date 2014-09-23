package edu.lmu.cmsi.ryan.homework2;
import edu.lmu.cmsi.ryan.homework2.Point;
import edu.lmu.cmsi.ryan.homework2.Rectangle;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LineSegmentTest {

	@Test
	public void testGetters() {
		LineSegment l = new LineSegment(new Point(3.0, 3.0), new Point(5.0, 3.0));
		Point one = l.getStartPoint();
		Point two = l.getEndPoint();
		Point mid = l.getMidPoint();
		Point predictedMid = new Point(4.0, 3.0);
		assertEquals("failure - did not calculate correct length", 2.0, l.segmentLength(), 0.0);
		assertEquals("failure - did not find max x correctly", 5.0, l.getMaxX(), 0.0);
		assertEquals("failure - did not find min x correctly", 3.0, l.getMinX(), 0.0);
		assertEquals("failure - did not find max y correctly", 3.0, l.getMaxY(), 0.0);
		assertEquals("failure - did not find min y correctly", 3.0, l.getMinY(), 0.0);
		assertEquals("failure - did not calculate midpoint correctly", true, mid.equalTo(predictedMid));
	}

	@Test
	public void equalToTest() {
		LineSegment l = new LineSegment(new Point(3.0, 3.0), new Point(5.0, 3.0));
		LineSegment l2 = new LineSegment(new Point(3.0, 3.0), new Point(5.0, 3.0));
		assertEquals("failure - did not recognize same line", true, l.equalTo(l2));
	}

	@Test
	public void intersectsTest() {
		LineSegment l = new LineSegment(new Point(3.0, 3.0), new Point(5.0, 3.0));
		LineSegment l2 = new LineSegment(new Point(4.0, 2.0), new Point(4.0, 4.0));
		LineSegment l3 = new LineSegment(new Point(4.0, 4.0), new Point(4.0, 5.0));
		assertEquals("failure - did not recognize line intersection", true, l.intersectsWith(l2));
		assertEquals("failure - did not recognize lines did not intersect", false, l.intersectsWith(l3));
	}
}