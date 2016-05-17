package ue6;

import java.util.ArrayList;
import java.util.Iterator;

public class CageIterator implements Iterator<ICatchable> {
	int index;
	ArrayList animals;
	
	public CageIterator(ArrayList<ICatchable> animals) {
		index = 0;
		this.animals = animals;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ICatchable next() {
		// TODO Auto-generated method stub
		return null;
	}

}
