package ue6;

import java.util.Iterator;

public interface ICatchable extends Iterable<ICatchable> {
	public int getWeight();
	public Iterator<ICatchable> iterator();
}
