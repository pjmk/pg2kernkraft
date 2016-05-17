package ue6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class provides the ability to iterate over Animals stored in a cage.
 * 
 * @author Paul Jureschek
 *
 * @param <T> Object-Specification of Animals stored in Cage.
 */

public class CageIterator<T extends Animal> implements Iterator<T> {
	int index;
	ArrayList<T> animals;
	int nextCounter = 0;
	
	/**
	 * Generates CageIterator object.
	 * @param animals ArrayList that will be iterated
	 */
	public CageIterator(ArrayList<T> animals) {
		index = 0;
		this.animals = animals;
	}
	
	/**
	 * Returns true if there is an element at the current index. Else false.
	 * @return true if there is an element at the current index. Else false
	 */
	@Override
	public boolean hasNext() {
		if (index >= animals.size()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Returns Element at current index and increments index.
	 * @return element at current index
	 */
	@Override
	public T next() {
		if (hasNext()) {
			index++;
			nextCounter = 1;
			return animals.get(index - 1);
		} else {
			throw new NoSuchElementException("At Index " + index + " in cage is no element");
		}
	}
	
	/**
	 * Removes last returned element (index-1).
	 * My only be called once per iteration.
	 * It also decrements index by one, so indices stay up-to-date.
	 */
	@Override
	public void remove() {
		if (nextCounter == 1) {
			animals.remove(index - 1);
			nextCounter = 0;
			index -= 1;
		} else {
			throw new IllegalStateException("Must not call remove function more than once per iteration!");
		}
	}
}
