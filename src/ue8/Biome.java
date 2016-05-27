package ue8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
*
* This class provides a "Biome", which can store multiple numbers of Villages.
* It has to have a name and a kind of biome (e.g. "desert", "gras"...).
*
* @author Paul Jureschek, Michael Kinzkofer
*
*/


public class Biome implements Iterable<Village>{
	private String name;
	private Nature nature;
	/*
	 * We decided to choose an array list. 
	 * The main reason is, we wanted a ordered and dynamic data structure.
	 * This guarantees the same sequence every time the world is saved or red.
	 * Furthermore it is possible to work with indices.
	 */
	private Map<String, Village> villages =  new HashMap<>();
	private List<WildAnimal> wildAnimalList =  new ArrayList<>();
	
	/**
	 * Generates new Biome.
	 * @param name name of biome
	 * @param nature kind of biome (e.g. "desert", "gras"...)
	 */
	
	public Biome(String name, Nature nature) {
		this.name = name;
		this.nature = nature;
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
	}

	/**
	 * Returns name of Biom.
	 * @return name of Biom
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Returns Map of Villages saved in Biome (built on Biome).
	 * @return Map Village saved in Biome (built on Biome)
	 */
	
	public Map<String, Village> getVillages() {
		return villages;
	}

	/**
	 * Adds existing Village to Biome.
	 * @param village Village Element of type Village that should be added to this Biome
	 */
	
	public void addVillage(Village village) {
		villages.put(village.getName(), village);
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
		return villages.size();
	}
	
	/**
	 * Returns list of wild animals.
	 * @return array list of wild animals
	 */
	public List<WildAnimal> getAnimals() {
		return wildAnimalList;
	}
	
	/**
	 * Adds WildAnimal to this Biome. 
	 * @param animal WildAnimal to be added to this Biome
	 */
	
	public void addWildAnimal(WildAnimal animal) {		
		wildAnimalList.add(animal);
	}
	
	@Override
	public Iterator<Village> iterator() {
		return villages.values().iterator();
	}
}