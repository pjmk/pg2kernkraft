package ue5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
*
* This class provides a "Biome", which can store multiple numbers of Villages.
* It has to have a name and a kind of biome (e.g. "desert", "gras"...).
*
* @author Paul Jureschek, Michael Kinzkofer
*
*/


public class Biome implements Iterator<Village>{
	private static final int MAX_NUM_VILLAGES = 20;
	private String name;
	private Nature nature;
	private int amountVillages;
	private Village[] village;
	private final int MAX_NUM_ANIMALS = 20; // Because we don't know dynamic arrays yet
	private WildAnimal animals[] = new WildAnimal[MAX_NUM_ANIMALS];
	
	private int index = 0; // For Iterator implementation
	
	/**
	 * Generates new Biome.
	 * @param name name of biome
	 * @param nature kind of biome (e.g. "desert", "gras"...)
	 */
	
	public Biome(String name, Nature nature) {
		this.name = name;
		this.nature = nature;
		setVillage(new Village [MAX_NUM_VILLAGES]);
	}
	
	/**
	 * Generates new Biome.
	 * @param row String containing all attributes
	 */
	
	public Biome(String row) {
		//splits each word in inputData[] array
		String[] inputData = row.split(";|\\:");
		for (int i = 0; i < inputData.length; i += 2) {
			switch(inputData[i]) {
				case Keywords.BIOME:	this.name = inputData[i + 1];			
										break;
				case Keywords.NATURE: 	this.nature = Nature.valueOf(inputData[i + 1].toUpperCase());
										break;							
			}
		}
		setVillage(new Village [MAX_NUM_VILLAGES]);
	}

	/**
	 * Returns name of Biom.
	 * @return name of Biom
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Returns constant MAX number of Villages.
	 * @return constant MAX number of Villages
	 */
	
	public static int getMaxNumVillages() {
		return MAX_NUM_VILLAGES;
	}

	/**
	 * Returns Village saved in Biome (built on Biome).
	 * @return Village saved in Biome (built on Biome)
	 */
	
	public Village[] getVillage() {
		return village;
	}

	/**
	 * Adds existing Village to Biome.
	 * @param village Village Element of type Village that should be added to this Biome
	 */
	
	public void addVillage(Village village) {
		if (amountVillages >= 20) {
			System.out.println("Too many villages on biome");
			return;
		}
		this.village[amountVillages] = village;
		amountVillages++;
	}
	
	/**
	 * Return  string, which contains name of biome and kind of nature.
	 * @return  String, which contains name of biome and kind of nature
	 */
	@Override
	public String toString() {
		return "BIOME:"+ name + ";NATURE:" + WorldUtilities.convertUpper(nature.toString());
	}
	
	/**
	 * Returns nature on biome.
	 * @return the nature
	 */
	public Nature getNature() {
		return nature;
	}

	/**
	 * Returns number of Villages on biome.
	 * @return the amountVillages
	 */
	public int getAmountVillages() {
		return amountVillages;
	}

	/**
	 * Set the array village.
	 * @param village Village[] array
	 */
	
	private void setVillage(Village[] village) {
		this.village = village;
	}
	
	/**
	 * Adds WildAnimal to this Biome. 
	 * @param animal WildAnimal to be added to this Biome
	 */
	public void addWildAnimal(WildAnimal animal) {		
		for (int i = 0; i < MAX_NUM_ANIMALS; i++) {
			if (animals[i] == null) {
				animals[i] = animal;
				return;
			}	
		}
		System.out.println("No more WildAnimals allowed on this Biome");
	}

	/**
	 * Returns current index used by iterator to iterator over village[].
	 * @return the current index for iterator
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Reset index, so iterator can go over everything again.
	 * Sets index used by Iterator implementation to 0.
	 */
	public void resetIndex() {
		index = 0;
	}

	/**
	 * Returns animals living on this Biome right now.
	 * @return animals living on this Biome right now
	 */
	public WildAnimal[] getAnimals() {
		return animals;
	}

	/**
	 * Checks if there is another Village after the current index or not.
	 * @return whether there is another Village after the index or not as boolean
	 */
	@Override
	public boolean hasNext() {
		if (village[index] == null || village.length == index) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Returns Village object from village[] at current index. 
	 * Additionally it increments index if there is an village after the current index.
	 * @return Village object
	 */
	@Override
	public Village next() {
		int oldIndex = index;
		if (hasNext()) {
			index++;
			return village[oldIndex];
		} else {
			throw new NoSuchElementException("No further village in array at position: village[" + index + "]");
		}
	}
}