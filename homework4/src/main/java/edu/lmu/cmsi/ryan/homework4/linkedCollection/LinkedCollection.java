package edu.lmu.cmsi.ryan.homework4.linkedCollection;

import java.util.Iterator;

import edu.lmu.cmsi.ryan.homework4.TheCollection;
import edu.lmu.cmsi.ryan.homework4.Node;

public class LinkedCollection<A> extends TheCollection<A> {
	private Node<A> starter = null;
	private Node<A> mostRecent = null;

	public LinkedCollection(int recent) {
		super(recent);
	}

	@Override
	public void add(A o1) {
		if( o1 == null ) {
			throw new IllegalArgumentException("Collection does not take in nulls");
		} else {
			if (this.size == 0) {
				Node<A> newNode = new Node<A>(o1);
				this.starter = newNode;
				this.mostRecent = newNode;
			} else if (this.size < this.recent) {
				Node<A> nextNode = new Node<A>(o1);
				this.mostRecent.setNext(nextNode);
				this.mostRecent = nextNode;
			} else {
				Node<A> nextStart = this.starter.getNext();
				this.starter = nextStart;
				Node<A> nextMostRecent = new Node<A>(o1);
				this.mostRecent.setNext(nextMostRecent);
				this.mostRecent = nextMostRecent;
			}
			this.size++;
		}
	}

	@Override
	public A getNewest() {
		return this.mostRecent.getValue();
	}

	@Override
	public A getOldest() {
		return this.starter.getValue();
	}

	@Override
	public void reset() {
		this.starter = null;
		this.mostRecent = null;
		this.size = 0;
	}

	public Iterator<A> iterator() {
		return new LinkedCollectionIterator<A>(this.starter.getValue());
	}
}