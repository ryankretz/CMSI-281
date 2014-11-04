package edu.lmu.cmsi.ryan.homework4.linkedListCollection;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Iterator;

import edu.lmu.cmsi.ryan.homework4.TheCollection;
import edu.lmu.cmsi.ryan.homework4.linkedListCollection.*;

public class LinkedListCollectionTest {

	//test to make sure LinkedListCollection returns oldest element when
	//size is less than collection length
	@Test
	public void testSmallOldest() {
		LinkedListCollection<Integer> intsOnly = new LinkedListCollection<Integer>(5);
		for ( int i = 1; i < 5; i++) {
			Integer curr = i;
			intsOnly.add(curr);
		}
		Integer oldest = intsOnly.getOldest();
		Integer expected  = 1;
		assertEquals("failure - did not add elements and get oldest properly", expected, oldest);
	}

	//test to make sure LinkedListCollection returns oldest element when
	//size is greater than collection length	
	@Test
	public void testBigOldest() {
		LinkedListCollection<Integer> intsOnly = new LinkedListCollection<Integer>(5);
		for ( int i = 1; i <= 6; i++) {
			Integer curr = i;
			intsOnly.add(curr);
		}
		Integer oldest = intsOnly.getOldest();
		Integer expected  = 2;
		assertEquals("failure - did not add elements and get oldest properly", expected, oldest);
	}

	//test to make sure LinkedListCollection returns newest element when
	//size is less than collection length
	@Test 
	public void testSmallNew() {
		LinkedListCollection<Integer> intsOnly = new LinkedListCollection<Integer>(5);
		for ( int i = 1; i < 5; i++) {
			Integer curr = i;
			intsOnly.add(curr);
		}
		Integer newest = intsOnly.getNewest();
		Integer expected  = 4;
		assertEquals("failure - did not add elements and get newest properly", expected, newest);
	}

	//test to make sure LinkedListCollection returns newest element when
	//size is greater than collection length
	@Test
	public void testBigNew() {
		LinkedListCollection<Integer> intsOnly = new LinkedListCollection<Integer>(5);
		for ( int i = 1; i < 6; i++) {
			Integer curr = i;
			intsOnly.add(curr);
		}
		Integer newest = intsOnly.getNewest();
		Integer expected  = 5;
		assertEquals("failure - did not add elements and get newest properly", expected, newest);
	}

	//test getSize method
	@Test
	public void testSize() {
		LinkedListCollection<Integer> intsOnly = new LinkedListCollection<Integer>(5);
		for ( int i = 1; i < 5; i++) {
			Integer curr = i;
			intsOnly.add(curr);
		}
		Integer currSize = intsOnly.getSize();
		Integer expected  = 4;
		assertEquals("failure - did not add elements and get size properly", expected, currSize);
	}

	//tests getSize method after collection has been reset
	@Test
	public void testResetAndSize() {
		LinkedListCollection<Integer> intsOnly = new LinkedListCollection<Integer>(5);
		for ( int i = 1; i < 5; i++) {
			Integer curr = i;
			intsOnly.add(curr);
		}
		intsOnly.reset();
		Integer resestSize = intsOnly.getSize();
		Integer expected  = 0;
		assertEquals("failure - did not add elements, rest, and return correct size", expected, resestSize);
	}

	//tests to make sure LinkedListCollection is iterable and its in the right order
	@Test
	public void testIteration() {
		LinkedListCollection<Integer> intsOnly = new LinkedListCollection<Integer>(20);
		for ( int i = 0; i < 6; i++) {
			Integer curr = i;
			intsOnly.add(curr);
		}
		Iterator<Integer> intIter = intsOnly.iterator();
		Integer predicted = 0;
		while(intIter.hasNext()) {
			assertEquals("failure - iteration is not done properly", predicted, intIter.next());
			predicted++;
		}
	}

	//tests to make sure nulls cannot be added to the collection
	@Test (expected = IllegalArgumentException.class)
	public void testNullAdd() {
		LinkedListCollection<Integer> intsOnly = new LinkedListCollection<Integer>(5);
		intsOnly.add(null);
	}
}