/**
 * 
 */
package ue6;

import java.util.ArrayList;

/**
 * @author Michael Kinzkofer
 *
 */
public class Cage <T> {
	private static final int maxCageContent =  2200;
	private  ArrayList<T>  cageContent;
	private int capacity, currentWeight, xPosition, YPosition;
	
	
	/**
	 * creates new cage with max. capacity 
	 */
	public Cage() {
		this.capacity = maxCageContent;	
	}
	
	/**
	 * creates new Cage with given capacity
	 * 
	 * @param capacity capacity of the cage
	 */
	public Cage(int capacity) {
		this.capacity = capacity;
	}
	
	
	
	
	
	

}
