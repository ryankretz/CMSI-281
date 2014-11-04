	package edu.lmu.cmsi.ryan.homework4.arrayCollection;

import java.util.Iterator;

public class ArrayCollectionIterator<A> implements Iterator<A> {
	private int curr;
	private Object[] currCollection = null;

	public ArrayCollectionIterator(Object[] curr) {
		this.currCollection = curr;
		this.curr = 0;
	}

	public boolean hasNext() {
		if (this.curr >= this.currCollection.length - 1) {
			return false;
		} else {
			return this.currCollection[this.curr + 1] != null;
		}
	}

	public A next() {
		if(this.hasNext()) {
			this.curr++;
			return (A)this.currCollection[this.curr];
		} else {
			throw new IllegalArgumentException("Collection does not have a next value");
		}
	}
}