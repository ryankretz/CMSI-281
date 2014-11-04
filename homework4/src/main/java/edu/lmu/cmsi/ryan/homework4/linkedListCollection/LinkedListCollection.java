package edu.lmu.cmsi.ryan.homework4.linkedListCollection;

import java.util.*;

import edu.lmu.cmsi.ryan.homework4.TheCollection;
import edu.lmu.cmsi.ryan.homework4.Node;

public class LinkedListCollection<A> extends TheCollection<A> {
	private LinkedList<A> currCollection = new LinkedList();
	//private Node<A> head;

	public LinkedListCollection(int recent) {
		super(recent);
	}

	@Override
	public void add(A o1) {
		if( o1 == null ) {
			throw new IllegalArgumentException("Collection does not take in nulls");
		} else if( this.size == 0) {
			this.currCollection.add(o1);
			this.size++;
		} else {
			this.size++;
			if (this.size <= this.recent) {
				this.currCollection.add(o1);
			} else {
				this.currCollection.removeFirst();
				this.currCollection.addLast(o1);
			}
		}
	}

	@Override
	public A getNewest() {
		return this.currCollection.getLast();
	}

	@Override
	public A getOldest() {
		return this.currCollection.getFirst();
	}

	@Override
	public void reset() {
		this.currCollection.clear();
		this.size = 0;
	}

	public Iterator<A> iterator() {
		return this.currCollection.iterator();
	}
}