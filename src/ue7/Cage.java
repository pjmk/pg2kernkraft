package ue7;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The generic class Cage can contain different kinds of catchable Animals.
 * 
 * @author Michael Kinzkofer, Paul Jureschek
 *
 */
public class Cage <T extends Animal> implements IMovable, Iterable<T>{
	private static final int maxCageContent =  2200;
	// ArrayList because we sometimes need to delete elements in the middle
	private  ArrayList<T>  cageContent = new ArrayList<T>();
	private int capacity, currentWeight, xCoordinate, yCoordinate;	
	
	/**
	 * creates new cage with max. capacity 
	 */
	public Cage() {
		this.capacity = maxCageContent;
		this.setCoordinates();
	}
	
	/**
	 * creates new Cage with given capacity
	 * @param capacity capacity of the cage
	 */
	public Cage(int capacity) {
		this.capacity = capacity;
		this.setCoordinates();
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
			cageContent.add((T)animal);
			checkWolfEatsChicken();
					
		}
	}
	
	/**
	 * Check whether a wolf eats the chicken in the cage.
	 */
	private void checkWolfEatsChicken(){
		Iterator<T> cageIterator = iterator();
		
		while(cageIterator.hasNext()) {
			/* test cage containing wolf */
			if (cageIterator.next() instanceof Wolf) {
				/* restart */
				cageIterator = iterator();
				
				while(cageIterator.hasNext()) {
					/* wolf kills chicken */
					ICatchable currentAnimal = (ICatchable) cageIterator.next();
					if (currentAnimal instanceof Chicken) {
						this.currentWeight -= currentAnimal.getWeight(); 
						cageIterator.remove();
						System.out.println("Oh the wolf killed a chicken, bad decision bro");
					}
				}
				break;
			}
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
		//logCoordinates();	
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
	
	/**
	 * returns a String with the content, capacity and position of the cage.
	 */
	@Override
	public String toString() {
		return "Cage [cageContent=" + cageContent + ", capacity=" + capacity + ", currentWeight=" + currentWeight
				+ ", xCoordinate=" + xCoordinate + ", yCoordinate=" + yCoordinate + "]";
	}

	/**
	 * Returns iterator for Animals in cage.
	 * @return iterator over animals in cage
	 */
	@Override
	public Iterator<T> iterator() {
		return cageContent.iterator();
	}
}
