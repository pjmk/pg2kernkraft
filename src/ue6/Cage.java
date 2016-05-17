/**
 * 
 */
package ue6;

import java.util.ArrayList;

/**
 * @author Michael Kinzkofer
 *
 */
public class Cage <T extends Animal> implements IMovable{
	private static final int maxCageContent =  2200;
	private  ArrayList<T>  cageContent;
	private int capacity, currentWeight, xCoordinate, yCoordinate;
	
	
	/**
	 * creates new cage with max. capacity 
	 */
	public Cage() {
		this.capacity = maxCageContent;	
	}
	
	/**
	 * creates new Cage with given capacity
	 * @param capacity capacity of the cage
	 */
	public Cage(int capacity) {
		this.capacity = capacity;
	}
	
	
	/**
	 * Put an animal in the cage.
	 * @param animal animal which should be put in the cage
	 */
	public void putInCage(T animal){
		if ( !(animal instanceof ICatchable))
			System.out.println("The animal is not catchable");
		
		else if(currentWeight +  ((ICatchable) animal).getWeight() > capacity)
			System.out.println("cage is full! animal does not fit in ");
		else {
			this.currentWeight += ((ICatchable) animal).getWeight();
			cageContent.add(animal);
		}
	}
	
	/**
	 *  set the coordinates of the Cage.
	 *  @param xCoordinate x-coordinate of the Cage in the biome
	 *  @param yCoordinate y-coordinate of the Cage in the biome
	 */
	@Override
	public void setCoordinates(int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;	
	}

	/**
	 * Generates random coordinates and log the coordinates
	 *  of the Cage to the console
	 */
	@Override
	public void setCoordinates() {
		this.xCoordinate = (int) (100 * Math.random());
		this.yCoordinate = (int) (100 * Math.random());
		logCoordinates();	
	}
	
	
	/**
	 * Returns x-coordinate of the Cage.
	 * @return x-coordinate of the Cage
	 */
	@Override
	public int getXCoordinate() {
		return xCoordinate;
	}

	/**
	 * Returns y-coordinate of the Cage.
	 * @return y-coordinate of the Cage
	 */
	@Override
	public int getYCoordinate() {
		return yCoordinate;
	}

	/**
	 * Log the Cage coordinates to the console
	 */
	@Override
	public void logCoordinates() {
		System.out.println("Cage:" +  "X-COORDINATE:" + getXCoordinate() + ";Y-COORDINATE:" + getYCoordinate());
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cage [cageContent=" + cageContent + ", capacity=" + capacity + ", currentWeight=" + currentWeight
				+ ", xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate + "]";
	}
	
	

}
