package edu.lmu.cmsi.ryan.homework4;

import java.util.Iterator;

public abstract class TheCollection<A> implements Iterable<A>  {
	protected int size = 0;
	protected int recent;

	public TheCollection(int recent) {
		this.recent = recent;
	}

	public int getSize() {
		return this.size;
	}

	public abstract void add(A o1);

	public abstract A getOldest();

	public abstract A getNewest();

	public abstract void reset();
}