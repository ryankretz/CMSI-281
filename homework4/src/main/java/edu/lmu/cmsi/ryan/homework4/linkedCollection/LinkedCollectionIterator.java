package edu.lmu.cmsi.ryan.homework4.linkedCollection;

import java.util.Iterator;

import edu.lmu.cmsi.ryan.homework4.Node;

public class LinkedCollectionIterator<A> implements Iterator<A> {
	private Node<A> nextNode = null;
	private Node<A> start = null;

	public LinkedCollectionIterator(A starter) {
		this.start = new Node(starter);
		this.nextNode = this.start;
	}

	public boolean hasNext() {
		return this.nextNode.getNext() != null;
	}

	public A next() {
		if(this.hasNext()) {
			this.nextNode = this.nextNode.getNext();
			return nextNode.getValue();
		} else {
			throw new IllegalArgumentException("Collection does not have a next value");
		}
	}
}