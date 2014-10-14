package edu.lmu.cmsi.ryan.homework3;

import edu.lmu.cmsi.ryan.homework3.core.Coordinate;
import edu.lmu.cmsi.ryan.homework3.core.Displacement;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class coreTest {

	@Test
	public void testGetters() {
		Coordinate point = new Coordinate(5,5);
		assertEquals("failure - didn't create coordinate x-val", 5, point.getX(), 0.0);
		assertEquals("failure - didn't create coordinate y-val", 5, point.getY(), 0.0);
		}
}