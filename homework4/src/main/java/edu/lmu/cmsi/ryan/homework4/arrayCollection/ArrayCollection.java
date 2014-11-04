package edu.lmu.cmsi.ryan.homework4.arrayCollection;;

import java.util.Iterator;
import edu.lmu.cmsi.ryan.homework4.TheCollection;


public class ArrayCollection<A> extends TheCollection<A> {
	private Object[] currCollection;

	public ArrayCollection(int recent) {
		super(recent);
	}

	@Override
	public void add(A o1) {
		if(o1 == null) {
			throw new IllegalArgumentException("Collection does not take in nulls");
		} else {
		this.size++;
			if( this.size <= this.recent) {
				Object[] newArray = new Object[this.size];
				for( int i = 0; i < this.getSize() - 1; i++) {
					newArray[i] = this.currCollection[i];
				}
				newArray[this.size - 1] = o1;
				this.currCollection = newArray;
			} else {
				Object[] newArray = new Object[recent];
				for (int i = 0; i < this.recent - 1; i++) {
					newArray[i] = this.currCollection[i + 1];
				}
				newArray[recent - 1] = o1;
				this.currCollection = newArray;
			}
		}
	}

	@Override
	public A getOldest() {
			return (A)this.currCollection[0];
	}

	@Override
	public A getNewest() {
		if( this.getSize() < recent) {
			return (A)this.currCollection[this.getSize()-1];
		} else {
			return (A)this.currCollection[recent - 1];
		}
	}

	@Override
	public void reset() {
		Object[] newArray = new Object[0];
		this.currCollection = newArray;
		this.size = 0;
	}

	public Iterator<A> iterator() {
		return new ArrayCollectionIterator<A>(this.currCollection);
	}
	
}